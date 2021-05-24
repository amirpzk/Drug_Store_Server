package com.Prana.Latifi.service.Impl;

import com.Prana.Latifi.entity.*;
import com.Prana.Latifi.exception.*;
import com.Prana.Latifi.jwt.JwtFactory;
import com.Prana.Latifi.jwt.JwtWrapper;
import com.Prana.Latifi.repository.CompanyDetailRepo;
import com.Prana.Latifi.repository.ProfileRepo;
import com.Prana.Latifi.repository.RoleRepo;
import com.Prana.Latifi.repository.UserRepo;
import com.Prana.Latifi.response.CompanyDetailResponse;
import com.Prana.Latifi.service.ContextService;
import com.Prana.Latifi.service.EmailService;
import com.Prana.Latifi.service.TimeService;
import com.Prana.Latifi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserRepo userRepo;

  @Autowired private UserRepo userRepository;
  @Autowired private TimeService timeService;
  @Autowired private Environment env;
  @Autowired private PasswordEncoder passwordEncoder;
  @Autowired private EmailService emailService;
  @Autowired private ContextService contextService;
  @Autowired private SpringTemplateEngine templateEngine;
  @Autowired private JwtFactory jwtFactory;
  @Autowired private RoleRepo roleRepo;
  @Autowired private CompanyDetailRepo companyDetailRepo;
  @Autowired private ProfileRepo profileRepo;


  @Override
  public User register(
      String email,
      String phoneNumber,
      UserUsernameType type,
      List<Role> roles,
      String introduceCode,
      ProfileType profileType) {
    String username = null;
    CompanyDetail foundedCompanyDetail = null;
    User savedUser = null;
    if (type == UserUsernameType.EMAIL) {
      username = email;
    } else if (type == UserUsernameType.PHONE_NUMBER) {
      username = phoneNumber;
    }
    Role userRole = roleRepo.findByName("USER");
    List<Role> userRoleList = new ArrayList<>();
    userRoleList.add(userRole);
    Profile profile = new Profile();
    profile.setType(profileType);
    if (profileType.equals(ProfileType.COMPANY)){
      CompanyDetail companyDetail = new CompanyDetail();
      String newIntroduceCode = generateRandomString(5);
      companyDetail.setIntroduceCode(newIntroduceCode);
      profile.setCompanyDetail(companyDetail);
    }
    if (!introduceCode.isEmpty()){
      foundedCompanyDetail = companyDetailRepo.findByIntroduceCode(introduceCode);
    }
    if (userRepository.existsByUsername(username)) {
      User founded = userRepository.findByUsername(username);
      if (founded.isVerified()) {
        throw new VerifiedUserExistsException();
      } else {
        String verificationCode = generateRandomString(6);
        founded.setVerificationCode(verificationCode);
        handleSMSOrEmailRegister(founded);
        savedUser = userRepository.save(
            new User(
                founded.getId(),
                founded.getUsername(),
                founded.getEmail(),
                founded.getPhoneNumber(),
                founded.getType(),
                founded.getVerificationCode(),
                timeService.nowUnix(),
                null,
                0,
                false,
                false,
                userRoleList,
                new Profile()));
        if (foundedCompanyDetail != null){
          foundedCompanyDetail.getItroducedProfiles().add(savedUser.getProfile());
          companyDetailRepo.save(foundedCompanyDetail);
        }
        return savedUser;
      }
    }
    User user =
        new User(
            username,
            email,
            phoneNumber,
            type,
            generateRandomString(6),
            timeService.nowUnix(),
            null,
            0,
            false,
            false,
            userRoleList,
            new Profile());
    if (foundedCompanyDetail != null){
      foundedCompanyDetail.getItroducedProfiles().add(savedUser.getProfile());
      companyDetailRepo.save(foundedCompanyDetail);
    }
    handleSMSOrEmailRegister(user);
    if (userRepository.existsByUsername(username)){
      userRepository.delete(user);
    }
    return userRepository.save(user);
  }

  @Override
  public User verify(String username, String verificationCode, String password) {
    if (!userRepository.existsByUsername(username)) {
      throw new NotFoundException();
    }
    User founded = userRepository.findByUsername(username);
    if (timeService
        .convertUnixTimeToLocalDateTimeUtc(founded.getVerificationCodeDate())
        .plusMinutes(Long.parseLong(env.getProperty("minutes-for-verification")))
        .isBefore(timeService.now())) {
      throw new VerificationCodeExpiredException();
    }
    if (!founded.getVerificationCode().equals(verificationCode)) {
      throw new WrongVerificationCodeException();
    }
    User user =
        new User(
            founded.getId(),
            founded.getUsername(),
            founded.getEmail(),
            founded.getPhoneNumber(),
            founded.getType(),
            null,
            0,
            null,
            0,
            true,
            true,
            founded.getRoles(),
            founded.getProfile());
    user.setPassword(passwordEncoder.encode(password));
    return userRepository.save(user);
  }

  @Override
  public String login(String username, String password) {
    if (!userRepository.existsByUsername(username)) {
      throw new NotFoundException();
    }
    User founded = userRepository.findByUsername(username);
    if (!founded.isActive()) {
      throw new NotActiveUserException();
    }
    if (!founded.isVerified()) {
      throw new NotVerifiedUserException();
    }
    if (!BCrypt.checkpw(password, founded.getPassword())) {
      throw new WrongLoginPasswordException();
    }
    Map<String, User> userMap = new HashMap<>();
    userMap.put(username, founded);
    String token = jwtFactory.generateToken(username, new JwtWrapper(userMap));
    return token;
  }

  @Override
  public User forgetPasswordRequest(String username) {
    if (!userRepository.existsByUsername(username)) {
      throw new NotFoundException();
    }
    User founded = userRepository.findByUsername(username);
    if (!founded.isActive()) {
      throw new NotActiveUserException();
    }
    if (!founded.isVerified()) {
      throw new NotVerifiedUserException();
    }
    String forgetPasswordCode = generateRandomString(6);
    founded.setForgetPasswordCode(forgetPasswordCode);
    handleSMSOrEmailForgetPassword(founded);
    return userRepository.save(
        new User(
            founded.getId(),
            founded.getUsername(),
            founded.getEmail(),
            founded.getPhoneNumber(),
            founded.getType(),
            null,
            0,
            founded.getForgetPasswordCode(),
            timeService.nowUnix(),
            founded.isVerified(),
            founded.isActive(),
            founded.getRoles(),
            founded.getProfile()));
  }

  @Override
  public User forgetPasswordVerifying(String username, String forgetPasswordCode, String password) {
    if (!userRepository.existsByUsername(username)) {
      throw new NotFoundException();
    }
    User founded = userRepository.findByUsername(username);
    if (!founded.isActive()) {
      throw new NotActiveUserException();
    }
    if (!founded.isVerified()) {
      throw new NotVerifiedUserException();
    }
    if (timeService
        .convertUnixTimeToLocalDateTimeUtc(founded.getForgetPasswordCodeDate())
        .plusMinutes(Long.parseLong(env.getProperty("minutes-for-forget-password")))
        .isBefore(timeService.now())) {
      throw new ForgetPasswordCodeExpiredException();
    }
    if (!founded.getForgetPasswordCode().equals(forgetPasswordCode)) {
      throw new WrongForgetPasswordCode();
    }
    founded.setPassword(passwordEncoder.encode(password));
    return userRepository.save(
        new User(
            founded.getId(),
            founded.getUsername(),
            founded.getEmail(),
            founded.getPhoneNumber(),
            founded.getType(),
            founded.getVerificationCode(),
            founded.getVerificationCodeDate(),
            null,
            0,
            founded.isVerified(),
            founded.isActive(),
            founded.getRoles(),
            founded.getProfile()));
  }

  //  @Override
  //  public User changePasswordDuringForgetPassword(String username, String password) {
  //    if ( !userRepository.existsByUsername(username) ){
  //      throw new NotFoundException();
  //    }
  //    User founded = userRepository.findByUsername(username);
  //    if (!founded.isActive()){
  //      throw new NotActiveUserException();
  //    }
  //    if (!founded.isVerified()){
  //      throw new NotVerifiedUserException();
  //    }
  //    founded.setPassword(passwordEncoder.encode(password));
  //    return userRepository.save(founded);
  //  }

  @Override
  public User changePassword(String username, String lastPassword, String newPassword) {
    if (!userRepository.existsByUsername(username)) {
      throw new NotFoundException();
    }
    User founded = userRepository.findByUsername(username);
    if (!founded.isActive()) {
      throw new NotActiveUserException();
    }
    if (!founded.isVerified()) {
      throw new NotVerifiedUserException();
    }
    if (!BCrypt.checkpw(lastPassword, founded.getPassword())) {
      throw new WrongPasswordForChanginPasswordException();
    }
    founded.setPassword(passwordEncoder.encode(newPassword));
    return userRepository.save(founded);
  }

  private String generateRandomString(int length) {
    SecureRandom random = new SecureRandom();
    String CHAR_LOWER = "";
    String CHAR_UPPER = "";
    String NUMBER = "0123456789";

    String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {

      int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
      char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

      sb.append(rndChar);
    }

    return sb.toString();
  }

  private void handleSMSOrEmailForgetPassword(User user) {
    if (user.getType() == UserUsernameType.EMAIL) {
      sendForgetPasswordEmail(user);
    }
    if (user.getType() == UserUsernameType.PHONE_NUMBER) {
      new SmsComponent(env).sendMessage(user.getUsername(), user.getForgetPasswordCode(), user.getProfile().getFirstName());
    }
  }

  private void handleSMSOrEmailRegister(User user) {
    if (user.getType() == UserUsernameType.EMAIL) {
      sendWelcomeEmail(user);
    }
    if (user.getType() == UserUsernameType.PHONE_NUMBER) {
      String sms = "کد تایید شما در داروخانه لطیفی: " + user.getVerificationCode();
      new SmsComponent(env).sendMessage(user.getUsername(), sms, user.getProfile().getFirstName());
    }
  }

  @Async
  void sendWelcomeEmail(User user) {
    String from = contextService.getEmailFrom();
    String to = user.getEmail();
    String subject = "خوش آمدید";
    String content = getContentWelcomeEmail(user);
    emailService.sendEmail(from, to, subject, content);
  }

  private String getContentWelcomeEmail(User user) {
    Context context = new Context();
    context.setVariable("welcome_api", user.getVerificationCode());
    return templateEngine.process("welcome", context);
  }

  @Async
  void sendForgetPasswordEmail(User user) {
    String from = contextService.getEmailFrom();
    String to = user.getEmail();
    String subject = "بازیابی رمز عبور داروخانه لطیفی";
    String content = getContentForgetPasswordEmail(user);
    emailService.sendEmail(from, to, subject, content);
  }

  private String getContentForgetPasswordEmail(User user) {
    Context context = new Context();
    context.setVariable("forget_password", user.getForgetPasswordCode());
    return templateEngine.process("forgetPasswordEmail", context);
  }
}
