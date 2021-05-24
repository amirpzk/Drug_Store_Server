package com.Prana.Latifi.exception;

import com.Prana.Latifi.handler.CustomException;
import org.springframework.http.HttpStatus;

public class BuyTheCourse extends CustomException {

    public BuyTheCourse() {
        super("Please buy the course first!", HttpStatus.LOCKED);
    }
}
