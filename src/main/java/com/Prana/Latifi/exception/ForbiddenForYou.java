package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class ForbiddenForYou extends CustomException {

    public ForbiddenForYou() {
        super("This operation is forbidden for you!", HttpStatus.FORBIDDEN);
    }
}
