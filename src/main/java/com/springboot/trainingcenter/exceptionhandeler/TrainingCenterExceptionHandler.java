package com.springboot.trainingcenter.exceptionhandeler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class TrainingCenterExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler({ProperValidationsExceptions.class})
	public ResponseEntity<Object> handleValidationsException(ProperValidationsExceptions error,WebRequest request){
		return handleExceptionInternal(error, error.getMessage(), new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	@ExceptionHandler({MethodNotAllowedException.class})
	public ResponseEntity<Object> handleMethoNotAllowd(MethodNotAllowedException error, WebRequest request){
		return handleExceptionInternal(error,error.getMessage(), new HttpHeaders(),HttpStatus.METHOD_NOT_ALLOWED, request);
	}
	
	@ExceptionHandler({CenterAlreadyExistException.class})
	public ResponseEntity<Object> handleCenterAlreadyExist(CenterAlreadyExistException error,WebRequest request){
		return handleExceptionInternal(error, error.getMessage(), new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
