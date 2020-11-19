package com.liugx.testsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.dto.QuestionAnswerDTO;
import com.liugx.testsystem.dto.RowQueryDTO;
import com.liugx.testsystem.dto.TestDTO;
import com.liugx.testsystem.dto.TestIdDTO;
import com.liugx.testsystem.dto.UserAnswerDTO;
import com.liugx.testsystem.dto.UserQuestionQueryDTO;
import com.liugx.testsystem.dto.UserRowDTO;
import com.liugx.testsystem.mapper.TestExtMapper;
import com.liugx.testsystem.mapper.TestMapper;
import com.liugx.testsystem.mapper.UserAnswerMapper;
import com.liugx.testsystem.mapper.UserTestMapper;
import com.liugx.testsystem.model.Test;
import com.liugx.testsystem.model.TestExample;
import com.liugx.testsystem.model.User;

@Service
public class TestHistoryService {
	
	@Autowired
	private UserTestMapper userTestMapper;
	
	@Autowired
	private TestExtMapper testExtMapper;
	
	@Autowired
	private UserAnswerMapper userAnswerMapper;

	public PaginationDTO list(Integer page, Integer size, Long testId) {
		// TODO Auto-generated method stub
		PaginationDTO paginationDTO=new PaginationDTO();
		RowQueryDTO rowQueryDTO = new RowQueryDTO();
        rowQueryDTO.setTestId(testId);
		Integer totalPage;
		Integer totalCount = (int) userTestMapper.countUserOfTest(rowQueryDTO);
		if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage, page);
        Integer offset = page < 1 ? 0 : size * (page - 1);
        
        rowQueryDTO.setOffset(offset);
        rowQueryDTO.setSize(size);
        List<UserRowDTO> userRowDTOs = userTestMapper.selectRow(rowQueryDTO);
        int i=0;
        for (UserRowDTO userRowDTO : userRowDTOs) {
            userRowDTO.setRow(i+1+10*(page-1));
        }
        paginationDTO.setData(userRowDTOs);
		return paginationDTO;
	}


	public TestDTO selectByTestId(Long testId) {
		// TODO Auto-generated method stub
		return testExtMapper.selectByTestIdDTO(new TestIdDTO(testId));
	}


	public PaginationDTO userReport(Long testId, User user) {
		// TODO Auto-generated method stub
		PaginationDTO paginationDTO=new PaginationDTO();
		RowQueryDTO rowQueryDTO = new RowQueryDTO();
        rowQueryDTO.setTestId(testId);
        rowQueryDTO.setUserId(user.getId());
		Integer totalPage;
		Integer totalCount = (int) userTestMapper.countUserOfTest(rowQueryDTO);
		List<UserRowDTO> userRowDTOs = userTestMapper.selectUserReport(rowQueryDTO);
        paginationDTO.setData(userRowDTOs);
		return paginationDTO;
	}


	public PaginationDTO userQuestionOfTest(Long testId, User user, Integer page, Integer size) {
		// TODO Auto-generated method stub
		PaginationDTO paginationDTO=new PaginationDTO();
		Integer totalPage;
		Integer totalCount = testExtMapper.countOfQuestionNum(new TestIdDTO(testId));
		if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage, page);
        Integer offset = page < 1 ? 0 : size * (page - 1);
        UserQuestionQueryDTO userQuestionQueryDTO = new UserQuestionQueryDTO();
        userQuestionQueryDTO.setOffset(offset);
        userQuestionQueryDTO.setSize(size);
        userQuestionQueryDTO.setTestId(testId);
        userQuestionQueryDTO.setUserId(user.getId());
        List<QuestionAnswerDTO> questionAnswerDTOs = userAnswerMapper.selectUserQuestion(userQuestionQueryDTO);
        paginationDTO.setData(questionAnswerDTOs);
		return paginationDTO;
	}

}
