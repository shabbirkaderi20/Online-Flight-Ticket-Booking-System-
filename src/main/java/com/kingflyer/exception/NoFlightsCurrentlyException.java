package com.kingflyer.exception;

@SuppressWarnings("serial")
public class NoFlightsCurrentlyException extends RuntimeException{

	public NoFlightsCurrentlyException() {
		super();
	}

	public NoFlightsCurrentlyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoFlightsCurrentlyException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoFlightsCurrentlyException(String message) {
		super(message);
	}

	public NoFlightsCurrentlyException(Throwable cause) {
		super(cause);
	}
	
}
