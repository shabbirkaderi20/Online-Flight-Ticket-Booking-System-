package com.kingflyer.exception;

@SuppressWarnings("serial")
public class PasswordNotMatchedException extends RuntimeException{

	public PasswordNotMatchedException() {
		super();
	}

	public PasswordNotMatchedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PasswordNotMatchedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordNotMatchedException(String message) {
		super(message);
	}

	public PasswordNotMatchedException(Throwable cause) {
		super(cause);
	}
	
}
