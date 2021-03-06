package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class NoTokenInRequest extends CustomException {

    public NoTokenInRequest() {
        super("There is no Token in your request", HttpStatus.BAD_GATEWAY);
    }
}
