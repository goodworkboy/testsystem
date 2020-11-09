package com.liugx.testsystem.mapper;

import java.util.List;

import com.liugx.testsystem.dto.PaperQueryDTO;
import com.liugx.testsystem.dto.paper.PaperPageDTO;
import com.liugx.testsystem.model.Paper;

public interface PaperExtMapper {
	
	Long countByPaperQueryDTO(PaperQueryDTO paperQueryDTO);
	//比对试卷里是否已经存在该题目 传入paperid 和question id
	Integer countByPaperAndQuestion(PaperPageDTO paperPageDTO);
	
	int incQuestion(Paper paper); //增加question的数目
	
	int delQuestion(Paper paper); //增加question的数目
}
