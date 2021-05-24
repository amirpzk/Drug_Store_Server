package com.Prana.Latifi.request;

public class UserVerificationRequest {

  private String username;
  private String password;
  private String verificationCode;

  public UserVerificationRequest() {
  }

  public UserVerificationRequest(String username, String password, String verificationCode) {
    this.username = username;
    this.password = password;
    this.verificationCode = verificationCode;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getVerificationCode() {
    return verificationCode;
  }
}
