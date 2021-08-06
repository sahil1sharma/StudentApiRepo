package com.trantor.springbootassignment.model;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Response POJO created to return specific type of response
 * 
 * @author Sahil Sharma
 *
 */
@Component
public class Response {
	private String status;
	private Object data;
	private String message;

	public Response(String status, List<Student> data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public Response() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
