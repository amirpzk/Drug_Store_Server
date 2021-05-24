package com.Prana.Latifi.request;

public class UserChangePasswordRequest {

  private String username;
  private String lastPassword;
  private String newPassword;

  public UserChangePasswordRequest() {
  }

  public UserChangePasswordRequest(String username, String lastPassword, String newPassword) {
    this.username = username;
    this.lastPassword = lastPassword;
    this.newPassword = newPassword;
  }

  public String getUsername() {
    return username;
  }

  public String getLastPassword() {
    return lastPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }
}
