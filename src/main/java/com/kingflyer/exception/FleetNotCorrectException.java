package com.kingflyer.exception;

@SuppressWarnings("serial")
public class FleetNotCorrectException extends RuntimeException{

	public FleetNotCorrectException() {
		super();
	}

	public FleetNotCorrectException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FleetNotCorrectException(String message, Throwable cause) {
		super(message, cause);
	}

	public FleetNotCorrectException(String message) {
		super(message);
	}

	public FleetNotCorrectException(Throwable cause) {
		super(cause);
	}
	
}
