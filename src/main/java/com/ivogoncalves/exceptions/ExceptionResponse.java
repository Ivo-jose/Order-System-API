package com.ivogoncalves.exceptions;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date timestamp;
	private String message;
	private String details;
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	
}
