package com.myapp.dev.controller;

import com.myapp.dev.exception.NotFoundException;
import com.myapp.dev.model.error.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Error> notFoundExceptionHandler(NotFoundException exception) {
        Error error = new Error(
                exception.getHttpStatus().value(),
                exception.getMessage()
        );
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(error, exception.getHttpStatus());
    }
}
