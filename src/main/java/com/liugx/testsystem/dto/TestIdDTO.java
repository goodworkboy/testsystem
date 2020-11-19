package com.liugx.testsystem.dto;

import java.io.Serializable;

public class TestIdDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long testId;
	public TestIdDTO(Long testId) {
		this.testId =testId;
	}
	public TestIdDTO() {}
	public void setTestId(Long testId) {
		this.testId=testId;
	}
	public Long getTestId() {
		return this.testId;
	}
}

