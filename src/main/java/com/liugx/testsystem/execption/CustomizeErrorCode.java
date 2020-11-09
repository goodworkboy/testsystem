package com.liugx.testsystem.execption;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
	
	
	STUDENTNUM_OR_PASSWORD_IS_NULL(2001, "用户名或密码为空！"), 
	QUESTION_NOT_FOUND(2002,"问题未找到！"), 
	QUESTION_STATUS_UPDATE_FAILURE(2003,"问题状态更新失败！"), 
	PAPER_NOT_FOUND(2004,"试卷未找到！"), 
	SOME_QUESTIONS_OF_PAPER_DELETED(2005,"一些试卷的题目已经被删除"), 
	PAPER_DELETE_FAILURE(2006,"试卷删除失败！"), 
	PAPER_IS_USING(2007,"试卷正在被使用！"), 
	QUESTION_NUMBER_OF_PAPER_SHOULD_MORE_THAN_FIVE(2008,"试卷中的题目数量应该大于5个！"), 
	QUESTION_HAD_ADDED(2009,"该题目已经被加入到该试卷中了");
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
