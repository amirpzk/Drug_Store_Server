package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class WrongVerificationCodeException extends CustomException {

  public WrongVerificationCodeException() {
    super("Wrong verification code during register", HttpStatus.NOT_ACCEPTABLE);
  }
}
