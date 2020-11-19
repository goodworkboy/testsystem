package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class UserAnswerDTO {
	private Long testId;
	private Long questionId;
	private String answer;	
}
