package com.plantapp.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class PlanterNotFoundException extends Exception{
    
	public PlanterNotFoundException(String message) {
		super(message);
	}
}