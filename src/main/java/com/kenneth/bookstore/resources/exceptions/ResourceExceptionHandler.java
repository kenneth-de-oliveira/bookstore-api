package com.kenneth.bookstore.resources.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kenneth.bookstore.exceptions.ObjetoNotFoundException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjetoNotFoundException.class)
	public ResponseEntity<StandardError> objetoNotFoundException(ObjetoNotFoundException obj) {
		StandardError se = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				obj.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
	}

	@ExceptionHandler(com.kenneth.bookstore.exceptions.DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> objetoNotFoundException(
			com.kenneth.bookstore.exceptions.DataIntegrityViolationException obj) {
		StandardError se = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				obj.getMessage());
		return ResponseEntity.status(BAD_REQUEST).body(se);
	}

}
