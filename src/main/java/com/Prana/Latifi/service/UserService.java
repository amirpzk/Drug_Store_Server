package com.Prana.Latifi.service;


import com.Prana.Latifi.entity.ProfileType;
import com.Prana.Latifi.entity.Role;
import com.Prana.Latifi.entity.User;
import com.Prana.Latifi.entity.UserUsernameType;

import java.util.List;

public interface UserService {

    User register(String email, String phoneNumber, UserUsernameType type, List<Role> roles, String introduceCode, ProfileType profileType);

    User verify(String username, String verificationCode, String password);

    String login(String username, String password);

    User forgetPasswordRequest(String username);

    User forgetPasswordVerifying(String username, String forgetPasswordCode, String password);

    User changePassword(String username, String lastPassword, String newPassword);

}
