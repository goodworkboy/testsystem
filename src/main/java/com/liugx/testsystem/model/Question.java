package com.liugx.testsystem.model;

import lombok.Data;

@Data
public class Question {
	private Long id;
	private String head;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private Character answer;
	private boolean status;
	
	public boolean getStatus() {
		return status;
	}
}
