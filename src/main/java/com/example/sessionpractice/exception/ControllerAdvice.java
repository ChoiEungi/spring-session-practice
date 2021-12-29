package com.example.sessionpractice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorMessage> handleCustomException(CustomException exception) {
        return ResponseEntity.badRequest().body(new ErrorMessage(BAD_REQUEST.name(), exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(CustomException exception) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ErrorMessage(INTERNAL_SERVER_ERROR.name(), exception.getMessage()));
    }
}
