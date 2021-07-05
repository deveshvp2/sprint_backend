package com.abc.techstore.exception;

public class ProductAlreadyExistingException extends RuntimeException {
	public ProductAlreadyExistingException(String message) {
		super(message);
	}

}
