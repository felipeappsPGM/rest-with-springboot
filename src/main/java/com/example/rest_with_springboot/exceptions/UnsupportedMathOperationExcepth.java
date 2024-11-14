package com.example.rest_with_springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationExcepth extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public UnsupportedMathOperationExcepth(String ex){
        super(ex);
    }
}
