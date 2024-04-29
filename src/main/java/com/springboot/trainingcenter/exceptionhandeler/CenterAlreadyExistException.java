package com.springboot.trainingcenter.exceptionhandeler;

public class CenterAlreadyExistException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CenterAlreadyExistException(String errorMessage) {
		super(errorMessage);
	}

}
