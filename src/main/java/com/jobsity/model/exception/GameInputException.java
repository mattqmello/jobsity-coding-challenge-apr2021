package com.jobsity.model.exception;

public class GameInputException extends Exception {

	public GameInputException() {}
	
	public GameInputException(String message) {
		super(message);
	}
	public GameInputException(Throwable throwable) {
		super(throwable);
	}

	public GameInputException(String message, Exception ex) {
		super(message, ex);
	}

}
