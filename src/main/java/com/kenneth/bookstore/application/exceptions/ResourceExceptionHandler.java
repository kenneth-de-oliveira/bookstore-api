package com.kenneth.bookstore.application.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kenneth.bookstore.domain.exceptions.DataIntegrityViolationException;
import com.kenneth.bookstore.domain.exceptions.ObjetoNotFoundException;

@RestControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjetoNotFoundException.class)
	public ResponseEntity<StandardError> objetoNotFoundException(ObjetoNotFoundException obj) {
		StandardError se = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				obj.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(
			DataIntegrityViolationException obj) {
		StandardError se = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				obj.getMessage());
		return ResponseEntity.status(BAD_REQUEST).body(se);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationError(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		
		ValidationError errors = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Error in field validation");
		
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			errors.addErrors(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return ResponseEntity.status(BAD_REQUEST).body(errors);
	}

}
