package com.sparta.schedule.excaption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<RestApiException> handleException(IllegalArgumentException ex) {
        RestApiException restApiException = new RestApiException(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(
                restApiException, HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<RestApiException> handleException(RuntimeException e) {
        RestApiException restApiException = new RestApiException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(
                restApiException, HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
