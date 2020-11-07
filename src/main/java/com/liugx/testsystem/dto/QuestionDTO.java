package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class QuestionDTO {
	private Long id;
	private String head;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private String answer;
	private boolean status;
	
}
