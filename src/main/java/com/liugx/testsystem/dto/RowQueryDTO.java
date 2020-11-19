package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class RowQueryDTO {
	private Long testId;
	private Long userId;
	private Integer offset;
	private Integer size;
}
