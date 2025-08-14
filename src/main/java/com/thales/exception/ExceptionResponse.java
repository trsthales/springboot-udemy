package com.thales.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private String message;
	private String details;

}
