package com.liugx.testsystem.execption;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
	
	
	STUDENTNUM_OR_PASSWORD_IS_NULL(2001, "用户名或密码为空！"), 
	QUESTION_NOT_FOUND(2002,"问题未找到！")
    ;
	
	private Integer code;
	private String message;
	
	
	CustomizeErrorCode(Integer code,String message) {
		// TODO Auto-generated constructor stub
		this.code=code;
		this.message=message;
	}
	
	@Override
	public Integer getCode() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
