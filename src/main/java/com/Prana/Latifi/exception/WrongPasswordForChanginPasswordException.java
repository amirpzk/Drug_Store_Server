package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class WrongPasswordForChanginPasswordException extends CustomException {

  public WrongPasswordForChanginPasswordException() {
    super("Wrong last password", HttpStatus.FORBIDDEN);
  }
}
