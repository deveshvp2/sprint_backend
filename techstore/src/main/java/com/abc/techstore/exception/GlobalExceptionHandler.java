package com.abc.techstore.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abc.techstore.payload.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value=ProductAlreadyExistingException.class)
	public ResponseEntity<?> handleProductAlreadyExistingException(Exception e){
		ErrorResponse errorResponse = new ErrorResponse(); 
		errorResponse.setError(e.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(Exception e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setError(e.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		
		body.put("status", status.value());

		// Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);
	}
}
