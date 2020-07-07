package com.feedback.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND)
public class BusinessException extends Exception{
	
	public BusinessException() {
		// TODO Auto-generated constructor stub
	}
	
	public BusinessException(String message) {
		super(message);
	}

}
