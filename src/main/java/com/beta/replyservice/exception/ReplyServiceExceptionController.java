package com.beta.replyservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReplyServiceExceptionController {

	@ExceptionHandler(value = ReplyServiceInvalidInputException.class)
	public ResponseEntity<Object> exception(ReplyServiceInvalidInputException exception){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST+" Invalid Input", HttpStatus.BAD_REQUEST);
	}
}
