package com.liugx.testsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.dto.QuestionDTO;
import com.liugx.testsystem.dto.ResultDTO;
import com.liugx.testsystem.dto.TestIdDTO;
import com.liugx.testsystem.dto.UserAnswerDTO;
import com.liugx.testsystem.dto.UserTestDTO;
import com.liugx.testsystem.dto.TestDTO;
import com.liugx.testsystem.dto.UserTestQueryDTO;
import com.liugx.testsystem.enums.GeneratorIdEnum;
import com.liugx.testsystem.execption.CustomizeErrorCode;
import com.liugx.testsystem.execption.CustomizeException;
import com.liugx.testsystem.execption.ICustomizeErrorCode;
import com.liugx.testsystem.mapper.QuestionExtMapper;
import com.liugx.testsystem.mapper.QuestionMapper;
import com.liugx.testsystem.mapper.TestExtMapper;
import com.liugx.testsystem.mapper.TestMapper;
import com.liugx.testsystem.mapper.UserAndTestMapper;
import com.liugx.testsystem.mapper.UserTestInfoMapper;
import com.liugx.testsystem.mapper.UserTestMapper;
import com.liugx.testsystem.model.Question;
import com.liugx.testsystem.model.Test;
import com.liugx.testsystem.model.TestExample;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.model.UserAndTest;
import com.liugx.testsystem.model.UserAndTestExample;
import com.liugx.testsystem.model.UserTestInfo;
import com.liugx.testsystem.model.UserTestInfoExample;
import com.liugx.testsystem.model.UserTestInfoKey;
import com.liugx.testsystem.util.IdAutoGeneratorUtil;

@Service
public class UserAndTestService {
	@Autowired
	private UserAndTestMapper userAndTestMapper;
	
	@Autowired
	private TestExtMapper testExtMapper;
	
	@Autowired 
	private TestMapper testMapper;
	
	@Autowired
	private UserTestMapper userTestMapper;
	
	@Autowired
	private QuestionExtMapper questionExtMapper;
	
	@Autowired
	private UserTestInfoMapper userTestInfoMapper;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	
	
	public Object signUp(TestIdDTO testIdDTO, User user) {
		// TODO Auto-generated method stub
		UserAndTestExample userAndTestExample = new UserAndTestExample();
		userAndTestExample.createCriteria().andUserIdEqualTo(user.getId())
			.andTestIdEqualTo(testIdDTO.getTestId());
		List<UserAndTest> userAndTests=userAndTestMapper.selectByExample(userAndTestExample);
		if(userAndTests.size()!=0) {
			return new CustomizeException(CustomizeErrorCode.HAD_SIGN_UP);
		}
		Test test = testMapper.selectByPrimaryKey(testIdDTO.getTestId());
		if(test.getStartTime()<System.currentTimeMillis()) {
			return new CustomizeException(CustomizeErrorCode.TEST_IS_STARTED);
		}
		UserAndTest userAndTest = new UserAndTest();
		userAndTest.setUserId(user.getId());
		userAndTest.setTestId(testIdDTO.getTestId());
		userAndTest.setCreateTime(System.currentTimeMillis());
		userAndTest.setModifyTime(userAndTest.getCreateTime());
		userAndTest.setId(IdAutoGeneratorUtil.generatorId(GeneratorIdEnum.USER_AND_TEST.getKey()));
		userAndTestMapper.insertSelective(userAndTest);
		return null;
	}
	
	public Object signOut(TestIdDTO testIdDTO, User user) {
		// TODO Auto-generated method stub
		Test test = testMapper.selectByPrimaryKey(testIdDTO.getTestId());
		if(test.getStartTime()<System.currentTimeMillis()) {
			return new CustomizeException(CustomizeErrorCode.TEST_IS_STARTED);
		}
		UserAndTestExample userAndTestExample = new UserAndTestExample();
		userAndTestExample.createCriteria().andUserIdEqualTo(user.getId())
			.andTestIdEqualTo(testIdDTO.getTestId());
		userAndTestMapper.deleteByExample(userAndTestExample);
		return null;
	}

	public PaginationDTO listNotBegin(Integer page, Integer size, User user) {
		// TODO Auto-generated method stub
		UserTestQueryDTO userTestQueryDTO = new UserTestQueryDTO();
		userTestQueryDTO.setUserId(user.getId());
		userTestQueryDTO.setCurrentTime(System.currentTimeMillis());
		Integer totalPage;
		Integer totalCount = testExtMapper.countByUserTestQueryDTONotBegin(userTestQueryDTO);
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
        Integer offset = page < 1 ? 0 : size * (page - 1);
		userTestQueryDTO.setSize(size);
		userTestQueryDTO.setOffset(offset);
		List<Test> tests = testExtMapper.selectNotBeginTest(userTestQueryDTO);
		PaginationDTO paginationDTO = new PaginationDTO();
		System.out.println(totalPage+" "+page);
		paginationDTO.setPagination(totalPage, page);
		List<TestDTO> testlist = new ArrayList<TestDTO>();
		for(Test test:tests) {
			TestDTO testDTO =new TestDTO();
			BeanUtils.copyProperties(test, testDTO);
			testlist.add(testDTO);
		}
		paginationDTO.setData(testlist);
		return paginationDTO;
	}

	public PaginationDTO listStartingTest(Integer page, Integer size, User user) {
		// TODO Auto-generated method stub
		UserTestQueryDTO userTestQueryDTO = new UserTestQueryDTO();
		userTestQueryDTO.setUserId(user.getId());
		userTestQueryDTO.setCurrentTime(System.currentTimeMillis());
		Integer totalPage;
		Integer totalCount = userTestMapper.countStartingTest(userTestQueryDTO);
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
        Integer offset = page < 1 ? 0 : size * (page - 1);
		userTestQueryDTO.setSize(size);
		userTestQueryDTO.setOffset(offset);
		List<UserTestDTO> tests = userTestMapper.selectStartingTest(userTestQueryDTO);
		PaginationDTO paginationDTO = new PaginationDTO();
		System.out.println(totalPage+" "+page);
		paginationDTO.setPagination(totalPage, page);
		paginationDTO.setData(tests);
		return paginationDTO;
	}
	
	public UserTestDTO listStartingTest(Long testId, User user) {
		// TODO Auto-generated method stub
		UserTestQueryDTO userTestQueryDTO = new UserTestQueryDTO();
		userTestQueryDTO.setUserId(user.getId());
		userTestQueryDTO.setCurrentTime(System.currentTimeMillis());
		userTestQueryDTO.setTestId(testId);
		List<UserTestDTO> tests = userTestMapper.selectStartingTest(userTestQueryDTO);
		if(tests==null||tests.size()==0) {
			throw new CustomizeException(CustomizeErrorCode.USER_NOT_SIGN_UP);
		}
		return tests.get(0);
	}

	public Object testIsEnded(TestIdDTO testIdDTO) {
		// TODO Auto-generated method stub
		TestExample testExample = new TestExample();
		testExample.createCriteria().andIdEqualTo(testIdDTO.getTestId())
			.andEndTimeLessThanOrEqualTo(System.currentTimeMillis());
		List<Test> tests=testMapper.selectByExample(testExample);
		if(tests.size()!=0) {
			return ResultDTO.errorOf(CustomizeErrorCode.TEST_IS_ENDED);
		}
		return null;
	}

	public Object initUserTest(TestIdDTO testIdDTO, User user) {
		UserAndTestExample example= new UserAndTestExample();
		example.createCriteria().andTestIdEqualTo(testIdDTO.getTestId()).andUserIdEqualTo(user.getId());
		List<UserAndTest> userAndTests=userAndTestMapper.selectByExample(example);
		UserAndTest userAndTest=null;
		if(userAndTests.size()!=0) {
			userAndTest=userAndTests.get(0);
			if(userAndTests.get(0).getStatus()==true) {
				return null;
			}
		}else {
			throw new CustomizeException(CustomizeErrorCode.USER_NOT_SIGN_UP);
		}
		Object object = testIsEnded(testIdDTO);
		if(object !=null)  return object;
		List<Question> questions = questionExtMapper.selectQuestionOfTest(testIdDTO);
		for(Question question:questions) {
			UserTestInfo userTestInfo =new UserTestInfo();
			userTestInfo.setUserId(user.getId());
			userTestInfo.setTestId(testIdDTO.getTestId());
			userTestInfo.setQuestionId(question.getId());
			userTestInfo.setCreateTime(System.currentTimeMillis());
			userTestInfo.setModifyTime(userTestInfo.getCreateTime());
			userTestInfoMapper.insertSelective(userTestInfo);
		}
		userAndTest.setStatus(true);
		userAndTest.setStartTime(System.currentTimeMillis());
		userAndTest.setEndTime(System.currentTimeMillis());
		userAndTestMapper.updateByPrimaryKey(userAndTest);
		return null;
	}
	
	public UserTestInfo selectUserTestInfo(User user,TestIdDTO testIdDTO,Long questionId) {
		UserTestInfoKey userTestInfoKey = new UserTestInfoKey();
		userTestInfoKey.setUserId(user.getId());
		userTestInfoKey.setQuestionId(questionId);
		userTestInfoKey.setTestId(testIdDTO.getTestId());
		return userTestInfoMapper.selectByPrimaryKey(userTestInfoKey);
	}

	public PaginationDTO listTestQuestion(TestIdDTO testIdDTO, Integer page, Integer size, User user) {
		// TODO Auto-generated method stub
		PaginationDTO paginationDTO=new PaginationDTO();
		List<Question> questions = questionExtMapper.selectQuestionOfTest(testIdDTO);
		Integer totalPage;
		Integer totalCount = questions.size();
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
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        int limit = offset+size < questions.size() ? offset+size : questions.size();
        for (int i = offset ;i<limit;i++) {
            QuestionDTO questionDTO = new QuestionDTO();
            UserTestInfo userTestInfo = selectUserTestInfo(user, testIdDTO, questions.get(i).getId());
            BeanUtils.copyProperties(questions.get(i), questionDTO);
            questionDTO.setAnswer(userTestInfo.getUserAnswer());
            questionDTOs.add(questionDTO);
        }
        paginationDTO.setData(questionDTOs);
		return paginationDTO;
	}

	public TestDTO getTestByTestIdDTO(TestIdDTO testIdDTO) {
		// TODO Auto-generated method stub
		return testExtMapper.selectByTestIdDTO(testIdDTO);
	}


	public Object updateUserTestQuestionAnswer(User user, UserAnswerDTO userAnswerDTO) {
		// TODO Auto-generated method stub
		Object object = testIsEnded(new TestIdDTO(userAnswerDTO.getTestId()));
		if(object !=null ) return object;
		UserTestInfo userTestInfo =new UserTestInfo();
		Question question = questionMapper.selectByPrimaryKey(userAnswerDTO.getQuestionId());
		userTestInfo.setUserId(user.getId());
		userTestInfo.setTestId(userAnswerDTO.getTestId());
		userTestInfo.setQuestionId(userAnswerDTO.getQuestionId());
		userTestInfo.setUserAnswer(userAnswerDTO.getAnswer());
		userTestInfo.setModifyTime(System.currentTimeMillis());
		if(question.getAnswer().equals(userAnswerDTO.getAnswer())) {
			userTestInfo.setScore(1);
		}else {
			userTestInfo.setScore(0);
		}
		userTestInfoMapper.updateByPrimaryKeySelective(userTestInfo);
		return null;
	}

	public Integer countTotalScore(User user,Long testId) {
		UserTestInfo userTestInfo = new UserTestInfo();
		userTestInfo.setTestId(testId);
		userTestInfo.setUserId(user.getId());
		return userTestMapper.sumTotalScore(userTestInfo);
	}

	public void submitUserTest(User user, Long testId) {
		// TODO Auto-generated method stub
		Integer score = countTotalScore(user, testId);
		if(score ==null || score<0) {
			score = 0 ;
		}
		UserAndTest userAndTest = new UserAndTest();
		userAndTest.setScore(score);
		Long current = System.currentTimeMillis();
		Test test = testMapper.selectByPrimaryKey(testId);
		userAndTest.setEndTime(current < test.getEndTime() ? current : test.getEndTime());
		userAndTest.setModifyTime(current);
		userAndTest.setStatus(true);
		UserAndTestExample userAndTestExample = new UserAndTestExample();
		userAndTestExample.createCriteria().andUserIdEqualTo(user.getId()).andTestIdEqualTo(testId);
		userAndTestMapper.updateByExampleSelective(userAndTest,userAndTestExample);
	}

	public PaginationDTO listEnd(Integer page, Integer size, User user) {
		// TODO Auto-generated method stub
		UserTestQueryDTO userTestQueryDTO = new UserTestQueryDTO();
		userTestQueryDTO.setUserId(user.getId());
		userTestQueryDTO.setCurrentTime(System.currentTimeMillis());
		Integer totalPage;
		Integer totalCount = testExtMapper.countByUserTestQueryDTOEND(userTestQueryDTO);
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
        Integer offset = page < 1 ? 0 : size * (page - 1);
		userTestQueryDTO.setSize(size);
		userTestQueryDTO.setOffset(offset);
		List<Test> tests = testExtMapper.selectEndTest(userTestQueryDTO);
		PaginationDTO paginationDTO = new PaginationDTO();
		paginationDTO.setPagination(totalPage, page);
		List<TestDTO> testlist = new ArrayList<TestDTO>();
		for(Test test:tests) {
			TestDTO testDTO =new TestDTO();
			BeanUtils.copyProperties(test, testDTO);
			testlist.add(testDTO);
		}
		paginationDTO.setData(testlist);
		return paginationDTO;
	}
	
}
