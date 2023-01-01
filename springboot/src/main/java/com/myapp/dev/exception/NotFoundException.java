package com.myapp.dev.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends RuntimeException{

    private final HttpStatus httpStatus;

    public NotFoundException() {
        super("Not found entity!");
        this.httpStatus = HttpStatus.NOT_FOUND;
    }

    public NotFoundException(String message) {
        super(message);
        this.httpStatus = HttpStatus.NOT_FOUND;
    }

}
