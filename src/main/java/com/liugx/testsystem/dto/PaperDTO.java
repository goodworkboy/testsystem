package com.liugx.testsystem.dto;

import java.util.List;

import com.liugx.testsystem.model.Question;

import lombok.Data;

@Data
public class PaperDTO {
	private Long id;
	private String name;
	private Long modifyTime;
	private Long createTime;
	private Integer questionNum;
	private List<Question> lists;
	private boolean status;
}
