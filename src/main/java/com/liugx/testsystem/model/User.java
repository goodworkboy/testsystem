package com.liugx.testsystem.model;

import lombok.Data;

@Data
public class User {
	private Long id;
	private String name;
	private String studentNum;
	private String password;
	private Long createT;
	private Long modifiedT;
}
