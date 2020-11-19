package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class UserTestQueryDTO {
	private Long userId;
	private Long testId;
	private Long currentTime;
	private Integer size;
	private Integer offset;
}
