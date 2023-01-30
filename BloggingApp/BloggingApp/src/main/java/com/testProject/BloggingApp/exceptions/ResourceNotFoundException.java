package com.testProject.BloggingApp.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
        super();
	}
	
    public ResourceNotFoundException(String message) {
		super(message);
	}
    
}
