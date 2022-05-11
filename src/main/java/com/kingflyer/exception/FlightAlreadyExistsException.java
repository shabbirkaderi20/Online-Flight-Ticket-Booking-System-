package com.kingflyer.exception;

@SuppressWarnings("serial")
public class FlightAlreadyExistsException extends RuntimeException{

	public FlightAlreadyExistsException() {
		super();
	}

	public FlightAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FlightAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public FlightAlreadyExistsException(String message) {
		super(message);
	}

	public FlightAlreadyExistsException(Throwable cause) {
		super(cause);
	}
	
}
