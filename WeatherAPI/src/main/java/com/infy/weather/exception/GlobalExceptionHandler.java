package com.infy.weather.exception;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { IOException.class })
	public ResponseEntity<ErrorResponse> badRequest(Exception ex)
	{
		ErrorResponse errorResponse = new ErrorResponse(400, "Bad Request");
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ErrorResponse> unKnownException(Exception ex)
	{
		ErrorResponse errorResponse = new ErrorResponse(400, "Bad Request");
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}
