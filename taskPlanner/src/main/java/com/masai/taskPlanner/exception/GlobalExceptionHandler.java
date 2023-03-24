package com.masai.taskPlanner.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException ue, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setDetails(req.getDescription(false));
		err.setMessage(ue.getMessage());
		err.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SprintException.class)
	public ResponseEntity<MyErrorDetails> sprintExceptionHandler(SprintException se, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setDetails(req.getDescription(false));
		err.setMessage(se.getMessage());
		err.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(TaskException.class)
	public ResponseEntity<MyErrorDetails> taskExceptionHandler(TaskException te, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setDetails(req.getDescription(false));
		err.setMessage(te.getMessage());
		err.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> genericExceptionHandler(Exception e, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setDetails(req.getDescription(false));
		err.setMessage(e.getMessage());
		err.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(NoHandlerFoundException nhfe, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setDetails(req.getDescription(false));
		err.setMessage(nhfe.getMessage());
		err.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodArgNotValidExceptionHandler(MethodArgumentNotValidException manve, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();

		err.setDetails(req.getDescription(false));
		err.setMessage(manve.getMessage());
		err.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
}
