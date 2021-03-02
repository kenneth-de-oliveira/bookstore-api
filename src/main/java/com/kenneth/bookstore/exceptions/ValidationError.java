package com.kenneth.bookstore.exceptions;

import java.util.ArrayList;

import com.kenneth.bookstore.resources.exceptions.StandardError;

public class ValidationError extends StandardError {
	
	private ArrayList<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError() {
		super();
	}

	public ValidationError(Long timestamp, Integer staus, String error) {
		super(timestamp, staus, error);
	}

	public ArrayList<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

}
