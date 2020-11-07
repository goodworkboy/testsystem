package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class QuestionCreateDTO {
	private String head;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private Character answer;
	private boolean status;
	
	public void setAnswer(String answer) {
		this.answer=answer.charAt(0);
	}
	
	public String getAnswer() {
		return String.valueOf(answer);
	}
	
}
