package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class VerifiedUserExistsException extends CustomException {

  public VerifiedUserExistsException() {
    super("Verified user exists", HttpStatus.NOT_ACCEPTABLE);
  }
}
