package com.kingflyer.exception;

@SuppressWarnings("serial")
public class NoSeatsAvailableException extends RuntimeException{

	public NoSeatsAvailableException() {
		super();
	}

	public NoSeatsAvailableException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoSeatsAvailableException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSeatsAvailableException(String message) {
		super(message);
	}

	public NoSeatsAvailableException(Throwable cause) {
		super(cause);
	}
	
}
