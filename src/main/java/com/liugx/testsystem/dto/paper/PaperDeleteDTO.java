package com.liugx.testsystem.dto.paper;

import lombok.Data;

@Data
public class PaperDeleteDTO {
	private Long paperId;
	private Boolean status;
	private String message;
}
