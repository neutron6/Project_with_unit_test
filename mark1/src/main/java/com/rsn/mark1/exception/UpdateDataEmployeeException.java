package com.rsn.mark1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UpdateDataEmployeeException extends Exception {
    public UpdateDataEmployeeException(String msg){
        super("THE ENTERING DATA IS INVALID");
    }
}
