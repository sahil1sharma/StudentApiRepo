package com.trantor.springbootassignment.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.trantor.springbootassignment.service.StudentService;

/**
 * StudentExceptionController having @ControllerAdvice annotation and
 * multiple @ExceptionHandlers used to handle exceptions globally.
 * 
 * @author Sahil Sharma
 *
 */
@ControllerAdvice
public class StudentExceptionController {
	@Autowired
	private ErrorResponse errorDetails;
	private static final Logger lOGGER = LoggerFactory.getLogger(StudentService.class.getName());

	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		List<String> errors = new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			errors.add(error.getDefaultMessage());
		});
		errorDetails.setMessage(errors.toString());
		errorDetails.setExceptionDetail(ex.getLocalizedMessage());
		lOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex) {
		errorDetails.setMessage(ex.getParameterName() + " parameter is missing");
		errorDetails.setExceptionDetail(ex.getLocalizedMessage());
		lOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
		errorDetails.setMessage(ex.getName() + " should be of type " + ex.getRequiredType().getName());
		errorDetails.setExceptionDetail(ex.getLocalizedMessage());
		lOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex) {
		errorDetails.setMessage("Resource not found");
		errorDetails.setExceptionDetail(ex.getLocalizedMessage());
		lOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception ex) {
		errorDetails.setMessage("Exception Raised");
		errorDetails.setExceptionDetail(ex.getLocalizedMessage());
		lOGGER.error(ex.getMessage(), ex);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
