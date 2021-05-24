package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class NotVerifiedUserException extends CustomException {

  public NotVerifiedUserException() {
    super("Not verified user", HttpStatus.LOCKED);
  }
}
