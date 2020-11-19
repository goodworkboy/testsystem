package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class UserQuestionQueryDTO {
	private Long userId;
	private Long testId;
	private Integer offset;
	private Integer size;
}
