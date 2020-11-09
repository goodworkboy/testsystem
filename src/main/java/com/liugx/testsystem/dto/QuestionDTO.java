package com.liugx.testsystem.dto;

import org.springframework.beans.BeanUtils;

import com.liugx.testsystem.model.Question;

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
	
	public QuestionDTO(Question question) {
		BeanUtils.copyProperties(this, question);
	}
	
	public QuestionDTO() {
		
	}
}
