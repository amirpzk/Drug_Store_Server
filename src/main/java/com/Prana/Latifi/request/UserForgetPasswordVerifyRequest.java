package com.Prana.Latifi.request;

public class UserForgetPasswordVerifyRequest {

  private String username;
  private String forgetPasswordCode;
  private String password;

  public UserForgetPasswordVerifyRequest() {
  }

  public UserForgetPasswordVerifyRequest(String username, String forgetPasswordCode,
      String password) {
    this.username = username;
    this.forgetPasswordCode = forgetPasswordCode;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getForgetPasswordCode() {
    return forgetPasswordCode;
  }

  public String getPassword() {
    return password;
  }
}
