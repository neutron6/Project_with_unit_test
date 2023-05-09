package com.rsn.mark1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UpdateDataEmployeeException extends Exception {

	public UpdateDataEmployeeException(String msg) {
		super("The enter Id of employee is not Valid");
	}
}
