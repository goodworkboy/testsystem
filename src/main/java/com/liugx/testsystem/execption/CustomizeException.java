package com.liugx.testsystem.execption;

public class CustomizeException extends RuntimeException{
	private String message;
	private Integer code;
	
	public CustomizeException(ICustomizeErrorCode errorcode) {
		this.message=errorcode.getMessage();
		this.code=errorcode.getCode();
	}

	public String getMessage() {
		return message;
	}
	
	public Integer getCode() {
		return code;
	}
	
}
