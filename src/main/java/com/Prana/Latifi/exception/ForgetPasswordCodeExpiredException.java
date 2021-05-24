package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class ForgetPasswordCodeExpiredException extends CustomException {

  public ForgetPasswordCodeExpiredException() {
    super("Forget password code expired", HttpStatus.NOT_ACCEPTABLE);
  }
}
