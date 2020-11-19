package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class UserTestDTO {
	private Long testId;
	private String testName;
	private Boolean status;
	private Long startTime;
	private Long endTime;
	private Long duration;
}
