package com.Prana.Latifi.request;

import com.Prana.Latifi.entity.ProfileType;
import com.Prana.Latifi.entity.Role;
import com.Prana.Latifi.entity.UserUsernameType;

import java.util.ArrayList;
import java.util.List;

public class UserRegisterRequest {

  private String email;
  private String phoneNumber;
  private UserUsernameType type;
  private String introduceCode;
  private ProfileType profileType;
  private List<Role> roles;

  public UserRegisterRequest() {
    this.roles = new ArrayList<>();
  }

  public UserRegisterRequest(
      String email,
      String phoneNumber,
      UserUsernameType type,
      String introduceCode,
      ProfileType profileType,
      List<Role> roles) {
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.type = type;
    this.introduceCode = introduceCode;
    this.profileType = profileType;
    this.roles = roles;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public UserUsernameType getType() {
    return type;
  }

  public void setType(UserUsernameType type) {
    this.type = type;
  }

  public String getIntroduceCode() {
    return introduceCode;
  }

  public void setIntroduceCode(String introduceCode) {
    this.introduceCode = introduceCode;
  }

  public ProfileType getProfileType() {
    return profileType;
  }

  public void setProfileType(ProfileType profileType) {
    this.profileType = profileType;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }
}
