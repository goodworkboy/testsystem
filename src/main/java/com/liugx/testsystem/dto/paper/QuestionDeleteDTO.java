package com.liugx.testsystem.dto.paper;

import lombok.Data;

@Data
public class QuestionDeleteDTO {
	private Integer questionNum;
	private Long paperId;
	private Long questionId;
	private Boolean status;
}
