package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class WrongPhoneNumberException extends CustomException {

  public WrongPhoneNumberException() {
    super("Wrong phone number exception", HttpStatus.EXPECTATION_FAILED);
  }
}
