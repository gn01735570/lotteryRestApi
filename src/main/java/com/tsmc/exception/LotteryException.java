package com.tsmc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class LotteryException {

	  @ExceptionHandler(value = HttpClientErrorException.class)
	   public ResponseEntity<Object> exception(HttpClientErrorException exception) {
	      return new ResponseEntity<>(exception.getMessage(), exception.getStatusCode());
	   }
}
