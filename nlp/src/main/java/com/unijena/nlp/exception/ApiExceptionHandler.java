package com.unijena.nlp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {StringLimitException.class})
    public ResponseEntity<Object> handleApiRequestException(StringLimitException exp){
        ApiException apiException = new ApiException(
                exp.getMessage(),
                HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {RequestLimitException.class})
    public ResponseEntity<Object> handleRequestLimitException(RequestLimitException exp){
        ApiException apiException = new ApiException(
                exp.getMessage(),
                HttpStatus.TOO_MANY_REQUESTS);
        return new ResponseEntity<>(apiException, HttpStatus.TOO_MANY_REQUESTS);
    }
}
