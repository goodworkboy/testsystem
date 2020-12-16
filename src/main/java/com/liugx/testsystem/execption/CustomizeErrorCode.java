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
	QUESTION_HAD_ADDED(2009,"该题目已经被加入到该试卷中了"), 
	TEST_NAME_IS_NULL(2010,"试卷名称为空！"), 
	START_TIME_TOO_EARLY(2011,"考试开始时间过早！"),
	DURATION_TOO_QUICK(2012,"持续时间太短了！"), 
	TEST_NOT_FIND(2013,"测试未找到！"), 
	TEST_IS_STARTED(2014,"测试已经开始了！"), 
	HAD_SIGN_UP(2015,"您已报名该场考试！"), 
	TEST_IS_ENDED(2016,"测试已结束！"), 
	USER_NOT_SIGN_UP(2017,"用户未报名该考试！"), 
	MESSAGE_NOT_FOUND(2018,"消息未找到！"), 
	READ_MESSAGE_FAIL(2019,"读取消息失败！"), 
	UNKNOW_ERROR(3000,"未知错误"), 
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
