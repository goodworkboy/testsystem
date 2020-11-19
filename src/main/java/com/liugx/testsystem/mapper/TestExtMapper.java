package com.liugx.testsystem.mapper;

import java.util.List;

import com.liugx.testsystem.dto.TestDTO;
import com.liugx.testsystem.dto.TestIdDTO;
import com.liugx.testsystem.dto.UserTestQueryDTO;
import com.liugx.testsystem.model.Test;

public interface TestExtMapper {
	
	List<Test> selectNotBeginTest(UserTestQueryDTO userTestQueryDTO);

	Integer countByUserTestQueryDTONotBegin(UserTestQueryDTO userTestQueryDTO);
	
	TestDTO selectByTestIdDTO(TestIdDTO testIdDTO);

	Integer countByUserTestQueryDTOEND(UserTestQueryDTO userTestQueryDTO);

	List<Test> selectEndTest(UserTestQueryDTO userTestQueryDTO);
	
	Integer countOfQuestionNum(TestIdDTO testIdDTO);
}
