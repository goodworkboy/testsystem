package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class UserAndTestDTO {
	private Long id;
	private Long userId;
	private Long testId;
	private Long createTime;
	private Long modifyTime;
	private Long start_time;
	private Long end_time;
	private boolean status;
	private Integer score;
}
