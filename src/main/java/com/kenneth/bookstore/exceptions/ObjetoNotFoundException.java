package com.kenneth.bookstore.exceptions;

public class ObjetoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjetoNotFoundException(String msg, Throwable t) {
		super(msg, t);
	}

	public ObjetoNotFoundException(String msg) {
		super(msg);
	}
}
