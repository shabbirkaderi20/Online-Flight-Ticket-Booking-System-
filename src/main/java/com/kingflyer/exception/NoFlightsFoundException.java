package com.kingflyer.exception;

@SuppressWarnings("serial")
public class NoFlightsFoundException extends RuntimeException{

	public NoFlightsFoundException() {
		super();
	}

	public NoFlightsFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoFlightsFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoFlightsFoundException(String message) {
		super(message);
	}

	public NoFlightsFoundException(Throwable cause) {
		super(cause);
	}
	
}
