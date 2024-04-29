package com.springboot.trainingcenter.exceptionhandeler;

public class ProperValidationsExceptions extends Exception  {

	private static final long serialVersionUID = 1L;
	
	public ProperValidationsExceptions(String errorMessage) {
		super(errorMessage);
	}
}
