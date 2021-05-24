package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class NotActiveUserException extends CustomException {

  public NotActiveUserException() {
    super("Not active user", HttpStatus.LOCKED);
  }
}
