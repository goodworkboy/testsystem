package com.liugx.testsystem.mapper;

import java.util.List;

import com.liugx.testsystem.dto.TestIdDTO;
import com.liugx.testsystem.model.Question;

public interface QuestionExtMapper {
	List<Question> selectQuestionOfTest(TestIdDTO testIdDTO);
}
