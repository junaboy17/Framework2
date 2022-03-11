package com.eisrem.AppUtils.Exceptions;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.SkipException;

import com.eisrem.AppUtils.SeleniumHelper;

public class MainException extends RuntimeException{

//	public MainException() {
//		super("Error occured when executing test steps. Some test steps have not been executed.");
//	}
	
	public MainException(String message) {
		super(message);
	}
	
	public MainException(String message, Throwable cause) {
		super(message);
	}
	
	private static final long serialVersionUID = -8581828050819448586L;
	private int errorType;
	private String errorMessage;
	private Exception exception;

	public MainException() {
		super();
		this.errorType = ErrorTypes.UNKNOWN_EXCEPTION;
		this.errorMessage = "This is an unknown error! Please be more descriptive!";
		this.exception = new IllegalArgumentException(this.errorMessage);
	}

	public MainException(int errorType) {
		super();
		this.errorType = errorType;

	}

	public MainException(int errorType, String errorMessage) {
		super(errorMessage);
		this.errorType = errorType;
		this.errorMessage = errorMessage;
		this.exception = new IllegalArgumentException(this.errorMessage);

	}

	public MainException(int errorType, List<String> errorMessages) {
		super(StringUtils.join(errorMessages, "<br>"));
		this.errorType = errorType;
		this.errorMessage = StringUtils.join(errorMessages, "<br>");
		this.exception = new IllegalArgumentException(this.errorMessage);

	}

	public MainException(int errorType, String errorMessage, Exception exception) {
		super(errorMessage, exception.getCause());
		this.errorType = errorType;
		this.errorMessage = errorMessage;
		this.exception = exception;

	}

	public MainException(int errorType, List<String> errorMessages, Exception exception) {
		super(StringUtils.join(errorMessages, "<br>"), exception.getCause());
		this.errorType = errorType;
		this.errorMessage = StringUtils.join(errorMessages, "<br>");
		this.exception = exception;

	}

	public MainException(Exception exception) {
		super(exception.getMessage(), exception.getCause());
		this.exception = exception;
		this.errorType = ErrorTypes.UNKNOWN_EXCEPTION;
		this.errorMessage = this.exception.getMessage();
	}

	public int getErrorType() {
		return this.errorType;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public Exception getException() {
		return this.exception;
	}

	public MainException log() {
		SeleniumHelper.log.error("\n -------------- \n Error Type: [" + this.errorType + "] \n Error Message: ["
				+ this.errorMessage + "] \n Exception: [" + this.exception.getMessage() + "] \n --------------");
		return this;
	}
	
	public void throwError() throws MainException {
		throw this;
	}

	public void assertFalse() {
		log();
		Assert.assertTrue(false);
	}

	public void skipTest() {
		log();
		throw new SkipException(getErrorMessage());
	}

	public boolean isEmptyDataTable() {
		return getErrorType() == ErrorTypes.EMPTY_DATATABLE_EXCEPTION;
	}

	public boolean isUnexpectedValue() {
		return getErrorType() == ErrorTypes.UNEXPECTED_VALUE;
	}

	public boolean isUnknownException() {
		return getErrorType() == ErrorTypes.UNKNOWN_EXCEPTION;
	}
	
}
