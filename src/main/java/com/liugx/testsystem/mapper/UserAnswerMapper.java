package com.liugx.testsystem.mapper;

import java.util.List;

import com.liugx.testsystem.dto.QuestionAnswerDTO;
import com.liugx.testsystem.dto.UserQuestionQueryDTO;

public interface UserAnswerMapper {
	List<QuestionAnswerDTO> selectUserQuestion(UserQuestionQueryDTO userQuestionQueryDTO);
}
