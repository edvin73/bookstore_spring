package com.edvin.projects.bookstore.handler;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler  {
	
	//not found exception handler
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex) {
		
		ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}
	
	//Global exception handler
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleGlobalException(Exception ex) {
		
		ApiError apiError = new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
