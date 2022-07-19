package com.cg.opna.planter.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.cg.opna.planter.exception.ErrorDetails;
import com.cg.opna.planter.exception.NoProperDataException;
import com.cg.opna.planter.exception.PlanterNotFoundException;




@ControllerAdvice
public class GlobalExceptionHandler {
    
	@ExceptionHandler(PlanterNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourseNotFoundException
	(PlanterNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails
				(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoProperDataException.class)
	public ResponseEntity<ErrorDetails> GlobalExceptionHandler(Exception ex, WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails
				(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	

		
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class,NullPointerException.class})
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
} 
