package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class TokenNotValidateWithThisSecretPass extends CustomException {

  public TokenNotValidateWithThisSecretPass() {
    super("Token not validated", HttpStatus.FORBIDDEN);
  }
}
