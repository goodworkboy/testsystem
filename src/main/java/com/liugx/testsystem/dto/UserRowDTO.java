package com.liugx.testsystem.dto;

import lombok.Data;

@Data
public class UserRowDTO {
	private Long userId;
	private String userName;
	private Integer score;
	private Long useTime;
	private Integer row;
}
