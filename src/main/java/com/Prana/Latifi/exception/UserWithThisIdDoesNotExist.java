package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class UserWithThisIdDoesNotExist extends CustomException {

    public UserWithThisIdDoesNotExist() {
        super("User with this ID does not exist", HttpStatus.NOT_FOUND);
    }
}
