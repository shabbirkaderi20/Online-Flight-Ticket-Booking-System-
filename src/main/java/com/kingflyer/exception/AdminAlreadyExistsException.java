package com.kingflyer.exception;

@SuppressWarnings("serial")
public class AdminAlreadyExistsException extends RuntimeException{

	public AdminAlreadyExistsException() {
		super();
	}

	public AdminAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AdminAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdminAlreadyExistsException(String message) {
		super(message);
	}

	public AdminAlreadyExistsException(Throwable cause) {
		super(cause);
	}
	
}
