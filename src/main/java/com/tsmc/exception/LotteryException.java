package com.tsmc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class LotteryException {

	  @ExceptionHandler(value = HttpClientErrorException.class)
	   public ResponseEntity<Object> exception(HttpClientErrorException exception) {
	      return new ResponseEntity<>("Empty record with query criteria", HttpStatus.BAD_REQUEST);
	   }
}
