package com.example.rest_with_springboot.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
public class ExceptionsResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String  message;
    private String details;


}
