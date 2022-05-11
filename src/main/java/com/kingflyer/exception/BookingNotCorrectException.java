package com.kingflyer.exception;

@SuppressWarnings("serial")
public class BookingNotCorrectException extends RuntimeException{

	public BookingNotCorrectException() {
		super();
	}

	public BookingNotCorrectException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BookingNotCorrectException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookingNotCorrectException(String message) {
		super(message);
	}

	public BookingNotCorrectException(Throwable cause) {
		super(cause);
	}
	
}
