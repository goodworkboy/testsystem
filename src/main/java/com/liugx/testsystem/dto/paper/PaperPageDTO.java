package com.liugx.testsystem.dto.paper;

import java.util.List;

import lombok.Data;

@Data
public class PaperPageDTO {
	private Long id;
	private String name;
	private Long modifyTime;
	private Long createTime;
	private Integer questionNum;
	private Integer page;
	private Long questionId;
	private Boolean status;
}
