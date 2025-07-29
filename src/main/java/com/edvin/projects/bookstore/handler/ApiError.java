package com.edvin.projects.bookstore.handler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
	
	private HttpStatus status;
	private String message; 
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timestamp;  
	
	public ApiError(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status; 
		this.timestamp = LocalDateTime.now();
	}
	 
	 

}
