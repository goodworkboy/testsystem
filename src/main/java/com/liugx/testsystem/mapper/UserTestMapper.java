package com.liugx.testsystem.mapper;

import java.util.List;

import com.liugx.testsystem.dto.RowQueryDTO;
import com.liugx.testsystem.dto.TestIdDTO;
import com.liugx.testsystem.dto.UserAnswerDTO;
import com.liugx.testsystem.dto.UserQuestionQueryDTO;
import com.liugx.testsystem.dto.UserRowDTO;
import com.liugx.testsystem.dto.UserTestDTO;
import com.liugx.testsystem.dto.UserTestQueryDTO;
import com.liugx.testsystem.model.UserTestInfo;

public interface UserTestMapper {
	List<UserTestDTO> selectStartingTest(UserTestQueryDTO userTestQueryDTO);

	Integer countStartingTest(UserTestQueryDTO userTestQueryDTO);
	
	Integer sumTotalScore(UserTestInfo userTestInfo);

	Integer countUserOfTest(RowQueryDTO rowQueryDTO);

	List<UserRowDTO> selectRow(RowQueryDTO rowQueryDTO);
	
	List<UserRowDTO> selectUserReport(RowQueryDTO rowQueryDTO);
}
