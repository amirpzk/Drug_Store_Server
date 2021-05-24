package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class WrongLoginPasswordException extends CustomException {

  public WrongLoginPasswordException() {
    super("Wrong login password", HttpStatus.FORBIDDEN);
  }
}
