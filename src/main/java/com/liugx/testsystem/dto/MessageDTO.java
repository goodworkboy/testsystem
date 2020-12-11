package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class MessageDTO {
	private Long id;
	private Long testId;
	private String message;
	private Long createTime;
	private Boolean status;
	private Integer messageType;
}
