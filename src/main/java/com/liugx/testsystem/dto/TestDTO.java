package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class TestDTO {
	private Long id;
	private String name;
	private Long startTime;
	private Long endTime;
	private Long createTime;
	private Long modifyTime;
	private Long duration;
	private Boolean status;
	private Long paperId;
	private String paperName;
	private Integer questionNum;
}
