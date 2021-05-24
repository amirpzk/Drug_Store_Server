package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class VerificationCodeExpiredException extends CustomException {

  public VerificationCodeExpiredException() {
    super("Your verification code is expired", HttpStatus.NOT_ACCEPTABLE);
  }
}
