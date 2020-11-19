package com.liugx.testsystem.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.dto.ResultDTO;
import com.liugx.testsystem.dto.TestIdDTO;
import com.liugx.testsystem.dto.TestCreateDTO;
import com.liugx.testsystem.dto.TestDTO;
import com.liugx.testsystem.execption.CustomizeErrorCode;
import com.liugx.testsystem.execption.CustomizeException;
import com.liugx.testsystem.mapper.PaperMapper;
import com.liugx.testsystem.mapper.TestMapper;
import com.liugx.testsystem.mapper.UserAndTestMapper;
import com.liugx.testsystem.model.Paper;
import com.liugx.testsystem.model.Test;
import com.liugx.testsystem.model.TestExample;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.model.UserAndTest;
import com.liugx.testsystem.model.UserAndTestExample;

@Service
public class TestService {

	@Autowired
	private PaperMapper paperMapper;
	
	@Autowired
	private TestMapper testMapper;
	
	
	
	public void  publishTest(TestCreateDTO testCreateDTO) {
		// TODO Auto-generated method stub
		Test test = new Test();
		Paper paper = paperMapper.selectByPrimaryKey(testCreateDTO.getPaperId());
		if(paper ==null ) {
			throw new CustomizeException(CustomizeErrorCode.PAPER_NOT_FOUND);
		}
		paper.setStatus(true);
		paperMapper.updateByPrimaryKey(paper);
		test.setDuration(testCreateDTO.getDuration().getTime());
		System.out.println(test.getDuration());
		test.setStartTime(testCreateDTO.getStartTime().getTime());
		test.setEndTime(test.getStartTime()+test.getDuration());
		test.setCreateTime(System.currentTimeMillis());
		test.setModifyTime(test.getCreateTime());
		test.setPaperId(testCreateDTO.getPaperId());
		test.setId(testCreateDTO.getId());
		test.setName(testCreateDTO.getName());
		testMapper.insertSelective(test);
	}

	public PaginationDTO list(Integer page, Integer size) {
		// TODO Auto-generated method stub
		PaginationDTO paginationDTO=new PaginationDTO();
		Integer totalPage;
		Integer totalCount = (int) testMapper.countByExample(new TestExample());
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
        TestExample testExample =new TestExample();
        testExample.setOrderByClause("start_time asc");
        List<Test> tests = testMapper.selectByExampleWithRowbounds(testExample, new RowBounds(offset,size));
        List<TestDTO> testDTOList = new ArrayList<>();
        for (Test test : tests) {
            TestDTO testDTO = new TestDTO();
            BeanUtils.copyProperties(test, testDTO);
            testDTOList.add(testDTO);
        }
        paginationDTO.setData(testDTOList);
		return paginationDTO;
	}

	public TestDTO selectById(Long id, Long paperId) {
		// TODO Auto-generated method stub
		Test test =testMapper.selectByPrimaryKey(id);
		if(test == null) {
			throw new CustomizeException(CustomizeErrorCode.TEST_NOT_FIND);
		}
		TestDTO testDTO = new TestDTO();
		BeanUtils.copyProperties(test, testDTO);
		if(paperId!=null) {
			testDTO.setPaperId(paperId);
		}
		Paper paper = paperMapper.selectByPrimaryKey(testDTO.getPaperId());
		if(paper == null) {
			throw new CustomizeException(CustomizeErrorCode.PAPER_NOT_FOUND);
		}
		testDTO.setPaperName(paper.getName());
		testDTO.setQuestionNum(paper.getQuestionNum());
		return testDTO;
	}
	
	public TestDTO selectById(Long id) {
		// TODO Auto-generated method stub
		return selectById(id,null);
	}

	public Object modifyTest(TestCreateDTO testCreateDTO) {
		// TODO Auto-generated method stub
		Test test = testMapper.selectByPrimaryKey(testCreateDTO.getId());
		if(test.getStatus() || test.getStartTime() <= System.currentTimeMillis())
			return ResultDTO.errorOf(CustomizeErrorCode.TEST_IS_STARTED);
		Paper paper = paperMapper.selectByPrimaryKey(testCreateDTO.getPaperId());
		if(paper ==null ) {
			throw new CustomizeException(CustomizeErrorCode.PAPER_NOT_FOUND);
		}
		paper.setStatus(true);
		paperMapper.updateByPrimaryKey(paper);
		test.setDuration(testCreateDTO.getDuration().getTime());
		test.setStartTime(testCreateDTO.getStartTime().getTime());
		test.setEndTime(test.getStartTime()+test.getDuration());
		test.setModifyTime(System.currentTimeMillis());
		test.setPaperId(testCreateDTO.getPaperId());
		test.setName(testCreateDTO.getName());
		testMapper.updateByPrimaryKey(test);
		return null;
	}

	

}
