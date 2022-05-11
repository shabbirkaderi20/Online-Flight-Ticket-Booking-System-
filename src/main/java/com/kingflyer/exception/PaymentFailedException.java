package com.kingflyer.exception;

@SuppressWarnings("serial")
public class PaymentFailedException extends RuntimeException{

	public PaymentFailedException() {
		super();
	}

	public PaymentFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PaymentFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentFailedException(String message) {
		super(message);
	}

	public PaymentFailedException(Throwable cause) {
		super(cause);
	}
	
}
