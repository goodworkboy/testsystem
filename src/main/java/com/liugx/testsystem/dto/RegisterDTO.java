package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class RegisterDTO {
	private String name;
	private String studentNum;
	private String password;
	private Long createT;
	private Long modifiedT;
}
