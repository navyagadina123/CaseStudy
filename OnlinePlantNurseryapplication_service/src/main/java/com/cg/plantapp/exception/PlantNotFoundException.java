package com.cg.plantapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class PlantNotFoundException extends Exception{
    
	public PlantNotFoundException(String message) {
		super(message);

	}
	
	
     
}

