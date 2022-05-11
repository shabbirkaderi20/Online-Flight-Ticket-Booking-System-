package com.kingflyer.exception;

@SuppressWarnings("serial")
public class FareNotCorrectException extends RuntimeException{

	public FareNotCorrectException() {
		super();
	}

	public FareNotCorrectException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FareNotCorrectException(String message, Throwable cause) {
		super(message, cause);
	}

	public FareNotCorrectException(String message) {
		super(message);
	}

	public FareNotCorrectException(Throwable cause) {
		super(cause);
	}
	
}
