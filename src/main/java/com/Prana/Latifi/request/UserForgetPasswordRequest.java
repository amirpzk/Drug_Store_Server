package com.Prana.Latifi.request;

public class UserForgetPasswordRequest {

  private String username;

  public UserForgetPasswordRequest() {
  }

  public UserForgetPasswordRequest(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }
}
