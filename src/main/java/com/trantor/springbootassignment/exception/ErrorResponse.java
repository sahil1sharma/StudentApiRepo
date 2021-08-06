package com.trantor.springbootassignment.exception;

import org.springframework.stereotype.Component;

/**
 * ErrorResponse POJO created to return specific error response messages
 * 
 * @author Sahil Sharma
 *
 */
@Component
public class ErrorResponse {
	private String message;
	private String exceptionDetail;

	public ErrorResponse(String message, String exceptionDetail) {
		super();
		this.message = message;
		this.exceptionDetail = exceptionDetail;
	}

	public ErrorResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}

}
