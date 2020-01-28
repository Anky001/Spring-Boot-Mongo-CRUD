package com.springmongo.springmongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionalHandlerController {
    @ExceptionHandler(value = ResourceNotFoundException.class)

    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        System.out.println("Not found exception::" + ex);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
