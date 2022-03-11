package com.eisrem.AppUtils.Exceptions;

public class InvalidPathForExcelException extends MainException{

	private static final long serialVersionUID = 1L;

	public InvalidPathForExcelException(String message) {
		super(message);
	}
	
	public InvalidPathForExcelException(String message, Throwable cause) {
		super(message);
	}
	
	
}
