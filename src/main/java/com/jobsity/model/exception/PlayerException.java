package com.jobsity.model.exception;

public class PlayerException extends Exception {

	public PlayerException() {	}
	
	public PlayerException(String message) {
		super(message);
	}

	public PlayerException(Exception e) {
		super(e);
	}
}
