package com.rsn.mark1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidCredentialsException extends RuntimeException{

    public InvalidCredentialsException(String msg){
        super("credentials are invalid");
    }
}
