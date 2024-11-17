package com.example.rest_with_springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredIsNullException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public RequiredIsNullException(String ex){
        super(ex);
    }

    public RequiredIsNullException(){
        super("It is not allowed to persisted a null object!");
    }
}