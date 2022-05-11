package com.kingflyer.exception;

@SuppressWarnings("serial")
public class StatusNotCorrectException extends RuntimeException {

	public StatusNotCorrectException() {
		super();
	}

	public StatusNotCorrectException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StatusNotCorrectException(String message, Throwable cause) {
		super(message, cause);
	}

	public StatusNotCorrectException(String message) {
		super(message);
	}

	public StatusNotCorrectException(Throwable cause) {
		super(cause);
	}
	
}
