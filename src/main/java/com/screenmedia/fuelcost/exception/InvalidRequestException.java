package com.screenmedia.fuelcost.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String msg) {
        super(msg);
    }
}
