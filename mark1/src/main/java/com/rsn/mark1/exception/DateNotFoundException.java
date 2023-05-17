package com.rsn.mark1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DateNotFoundException extends Exception{

    public DateNotFoundException(String msg){
        super("THE DATE YOU ENTER MIGHT BE INCORRECT");
    }
}
