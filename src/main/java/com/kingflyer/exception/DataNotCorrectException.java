package com.kingflyer.exception;

public class DataNotCorrectException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotCorrectException() {
		super();
	}

	public DataNotCorrectException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DataNotCorrectException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataNotCorrectException(String message) {
		super(message);
	}

	public DataNotCorrectException(Throwable cause) {
		super(cause);
	}
	
}
