package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class WrongForgetPasswordCode extends CustomException {

  public WrongForgetPasswordCode() {

    super("Wrong forget password code", HttpStatus.NOT_ACCEPTABLE);
  }
}
