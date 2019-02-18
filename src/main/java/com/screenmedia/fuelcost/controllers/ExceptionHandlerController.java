package com.screenmedia.fuelcost.controllers;

import com.screenmedia.fuelcost.exception.ErrorDetails;
import com.screenmedia.fuelcost.exception.InvalidRequestException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Date;
/*
    Class to handle exceptions with REST
 */
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidRequestException.class)
    public ErrorDetails handleNotFoundException(InvalidRequestException ex) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
                "Please send the correct format");
        return errorDetails;
    }
}