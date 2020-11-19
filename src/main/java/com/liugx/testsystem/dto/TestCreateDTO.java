package com.liugx.testsystem.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TestCreateDTO {
	private Long id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@JsonFormat( pattern = "yyyy-MM-dd'T'HH:mm",timezone="GMT+8")
	private Date startTime;
	@DateTimeFormat(pattern = "HH:mm")
	@JsonFormat( pattern = "HH:mm")
	private Date duration;
	private Date endTime;
	private Boolean status;
	private Long paperId;
}
