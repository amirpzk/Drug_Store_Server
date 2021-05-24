package com.Prana.Latifi.controller;

import com.Prana.Latifi.helper.ResponseHelper;
import com.Prana.Latifi.request.*;
import com.Prana.Latifi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired private UserService userService;

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ResponseEntity register(@RequestBody UserRegisterRequest request) {
    return ResponseHelper.response(
        userService.register(
            request.getEmail(),
            request.getPhoneNumber(),
            request.getType(),
            request.getRoles(),
            request.getIntroduceCode(),
            request.getProfileType()));
  }

  @RequestMapping(value = "/verify", method = RequestMethod.POST)
  public ResponseEntity verify(@RequestBody UserVerificationRequest request) {
    return ResponseHelper.response(
        userService.verify(
            request.getUsername(), request.getVerificationCode(), request.getPassword()));
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity login(@RequestBody UserLoginRequest request) {
    return ResponseHelper.response(userService.login(request.getUsername(), request.getPassword()));
  }

  @RequestMapping(value = "/forget-password/request", method = RequestMethod.POST)
  public ResponseEntity forgetPasswordRequest(@RequestBody UserForgetPasswordRequest request) {
    return ResponseHelper.response(userService.forgetPasswordRequest(request.getUsername()));
  }

  @RequestMapping(value = "/forget-password/complete", method = RequestMethod.POST)
  public ResponseEntity forgetPasswordVerifying(
      @RequestBody UserForgetPasswordVerifyRequest request) {
    return ResponseHelper.response(
        userService.forgetPasswordVerifying(
            request.getUsername(), request.getForgetPasswordCode(), request.getPassword()));
  }

  @RequestMapping(value = "/change-password", method = RequestMethod.POST)
  public ResponseEntity changePassword(@RequestBody UserChangePasswordRequest request) {
    return ResponseHelper.response(
        userService.changePassword(
            request.getUsername(), request.getLastPassword(), request.getNewPassword()));
  }
}
