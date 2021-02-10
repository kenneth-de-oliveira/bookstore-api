package com.kenneth.bookstore.exceptions;

public class ObjetoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjetoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjetoNotFoundException(String message) {
		super(message);
	}


}
