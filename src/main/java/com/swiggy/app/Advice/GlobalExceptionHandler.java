package com.swiggy.app.Advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.swiggy.app.GResponse.GResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	 GResponse gResponse = new GResponse();
	

	/*@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElement(NoSuchElementException noSuchElementException) {
		GResponse gResponse = new GResponse();
		gResponse.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<String>("Value is not present in DB,please check ur DB",HttpStatus.NOT_FOUND);
	}*/
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<GResponse> handleNoSuchElement(NoSuchElementException noSuchElementException) {
		gResponse.setData(null);
		gResponse.setError("Value is not Present in DB,please check");
		gResponse.setStatus(HttpStatus.NOT_FOUND.value());
		
		//System.out.println("Exception:"+gResponse);
		
		return new ResponseEntity<GResponse>(gResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleDefaultException(Exception e) {
		GResponse gResponse = new GResponse();
		gResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<String>("Bad request",HttpStatus.BAD_REQUEST);
	}
	
	
	
}
