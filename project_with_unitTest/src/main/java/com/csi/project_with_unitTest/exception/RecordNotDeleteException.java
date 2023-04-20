package com.csi.project_with_unitTest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class RecordNotDeleteException extends RuntimeException{

    public RecordNotDeleteException(String msg){
        super("Inserted data is not existed");
    }
}
