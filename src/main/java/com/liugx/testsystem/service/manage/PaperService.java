package com.liugx.testsystem.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.aspectj.bridge.AbortException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.dto.PaperDTO;
import com.liugx.testsystem.dto.QuestionDTO;
import com.liugx.testsystem.dto.QuestionQueryDTO;
import com.liugx.testsystem.dto.ResultDTO;
import com.liugx.testsystem.dto.paper.PaperDeleteDTO;
import com.liugx.testsystem.dto.paper.PaperPageDTO;
import com.liugx.testsystem.dto.paper.QuestionDeleteDTO;
import com.liugx.testsystem.execption.CustomizeErrorCode;
import com.liugx.testsystem.execption.CustomizeException;
import com.liugx.testsystem.mapper.PaperAndQuestionMapper;
import com.liugx.testsystem.mapper.PaperExtMapper;
import com.liugx.testsystem.mapper.PaperMapper;
import com.liugx.testsystem.mapper.QuestionMapper;
import com.liugx.testsystem.model.Paper;
import com.liugx.testsystem.model.PaperAndQuestion;
import com.liugx.testsystem.model.PaperAndQuestionExample;
import com.liugx.testsystem.model.PaperExample;
import com.liugx.testsystem.model.Question;
import com.liugx.testsystem.model.QuestionExample;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class PaperService {
	
	@Autowired
	private PaperMapper paperMapper;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private PaperExtMapper paperExtMapper;
	
	@Autowired
	private PaperAndQuestionMapper  paperAndQuestionMapper;
	
	
	public void insertPaper(PaperDTO paperDTO, List<Long> questionIds) {
		// TODO Auto-generated method stub
		Paper paper =new Paper();
		BeanUtils.copyProperties(paperDTO, paper);
		paper.setCreateTime(System.currentTimeMillis());
		paper.setModifyTime(paper.getCreateTime());
		paper.setQuestionNum(questionIds.size());
		paperMapper.insertSelective(paper);
		for(Long id:questionIds) {
			Question question =questionMapper.selectByPrimaryKey(id);
			if(question == null) {
				throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
			}
			question.setStatus(true);
			if(questionMapper.updateByPrimaryKey(question)==0) {
				throw new CustomizeException(CustomizeErrorCode.QUESTION_STATUS_UPDATE_FAILURE);
			}
			
			PaperAndQuestion paperAndQuestion = new PaperAndQuestion();
			paperAndQuestion.setPaperId(paper.getId());
			paperAndQuestion.setQuestionId(question.getId());
			paperAndQuestionMapper.insert(paperAndQuestion);
		}
	}


	public PaperDTO getById(Long id) {
		// TODO Auto-generated method stub
		PaperDTO paperDTO =new PaperDTO();
		Paper paper = paperMapper.selectByPrimaryKey(id);
		if(paper == null) {
			throw new CustomizeException(CustomizeErrorCode.PAPER_NOT_FOUND);
		}
		BeanUtils.copyProperties(paper, paperDTO);
		PaperAndQuestionExample paperAndQuestionExample = new PaperAndQuestionExample();
		paperAndQuestionExample.createCriteria().andPaperIdEqualTo(id);
		paperAndQuestionExample.setOrderByClause("question_id asc");
		List<PaperAndQuestion> paperAndQuss = paperAndQuestionMapper.selectByExample(paperAndQuestionExample);
		if(paperAndQuss== null || paperAndQuss.size() != paper.getQuestionNum()) {
			throw new CustomizeException(CustomizeErrorCode.SOME_QUESTIONS_OF_PAPER_DELETED);
		}
		List<Question> questionList = new ArrayList<Question>();
		for(PaperAndQuestion paq : paperAndQuss) {
			Question question =questionMapper.selectByPrimaryKey(paq.getQuestionId());
			if(question == null) {
				throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
			}
			question.setStatus(true);
			if(questionMapper.updateByPrimaryKey(question)==0) {
				throw new CustomizeException(CustomizeErrorCode.QUESTION_STATUS_UPDATE_FAILURE);
			}
			questionList.add(question);
		}
		paperDTO.setLists(questionList);
		return paperDTO;
	}


	public PaginationDTO<PaperDTO> list(Integer page,Integer size) {
		// TODO Auto-generated method stub
		PaginationDTO paginationDTO=new PaginationDTO();
		Integer totalPage;
		Integer totalCount = (int)paperMapper.countByExample(new PaperExample());
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
        PaperExample paperExample =new PaperExample();
        List<Paper> papers = paperMapper.selectByExampleWithRowbounds(paperExample, new RowBounds(offset,size));
        List<PaperDTO> paperDTOs = new ArrayList<>();
        for (Paper paper : papers) {
            PaperDTO paperDTO = new PaperDTO();
            BeanUtils.copyProperties(paper, paperDTO);
            paperDTOs.add(paperDTO);
        }
        paginationDTO.setData(paperDTOs);
		return paginationDTO;
	}


	public PaginationDTO<QuestionDTO> list(Integer page, Integer size, PaperDTO paper) {
		// TODO Auto-generated method stub
		PaginationDTO paginationDTO=new PaginationDTO();
		Integer totalPage;
		Integer totalCount = paper.getLists().size();
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
        int limit = offset+size < paper.getLists().size() ? offset+size : paper.getLists().size();
        for (int i = offset ;i<limit;i++) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(paper.getLists().get(i), questionDTO);
            questionDTOs.add(questionDTO);
        }
        paginationDTO.setData(questionDTOs);
		return paginationDTO;
	}


	public boolean deleteQuestion(QuestionDeleteDTO questionDeleteDTO) {
		// TODO Auto-generated method stub
		if(questionDeleteDTO.getStatus()) {
			throw new CustomizeException(CustomizeErrorCode.PAPER_IS_USING);
		}
		if(questionDeleteDTO.getQuestionNum()<=5) {
			throw new CustomizeException(CustomizeErrorCode.QUESTION_NUMBER_OF_PAPER_SHOULD_MORE_THAN_FIVE);
		}
		Paper paper = new Paper();
		paper.setId(questionDeleteDTO.getPaperId());
		paper.setQuestionNum(1);
		paperExtMapper.delQuestion(paper);
		PaperAndQuestionExample paperAndQuestionExample = new PaperAndQuestionExample();
		paperAndQuestionExample.createCriteria()
			.andPaperIdEqualTo(questionDeleteDTO.getPaperId())
			.andQuestionIdEqualTo(questionDeleteDTO.getQuestionId());
		paperAndQuestionMapper.deleteByExample(paperAndQuestionExample);
		return true;
	}


	public void updatePaper(PaperDTO paperDTO) {
		// TODO Auto-generated method stub
		if(paperDTO.isStatus()) {
			throw new CustomizeException(CustomizeErrorCode.PAPER_IS_USING);
		}
		Paper paper = new Paper();
		BeanUtils.copyProperties(paperDTO, paper);
		paperMapper.updateByPrimaryKeySelective(paper);
	}


	public void deletePaper(PaperDeleteDTO paperDeleteDTO) {
		// TODO Auto-generated method stub
		PaperAndQuestionExample paperAndQuestionExample = new PaperAndQuestionExample();
		paperAndQuestionExample.createCriteria().andPaperIdEqualTo(paperDeleteDTO.getPaperId());
		paperAndQuestionMapper.deleteByExample(paperAndQuestionExample);
		paperMapper.deleteByPrimaryKey(paperDeleteDTO.getPaperId());
	}


	public Object addQuestion(PaperPageDTO paperPageDTO) {
		// TODO Auto-generated method stub
		PaperExample paperExample = new PaperExample();
		Paper paper = paperMapper.selectByPrimaryKey(paperPageDTO.getId());
		if(paper.getStatus()) {
			return ResultDTO.errorOf(new CustomizeException(CustomizeErrorCode.PAPER_IS_USING));
		}
		PaperAndQuestionExample paperAndQuestionExample = new PaperAndQuestionExample();
		paperAndQuestionExample.createCriteria().andPaperIdEqualTo(paperPageDTO.getId())
			.andQuestionIdEqualTo(paperPageDTO.getQuestionId());
		if(paperAndQuestionMapper.selectByExample(paperAndQuestionExample).size()!=0) {
			return ResultDTO.errorOf(CustomizeErrorCode.QUESTION_HAD_ADDED);
		}
		PaperAndQuestion paperAndQuestion = new PaperAndQuestion();
		paperAndQuestion.setPaperId(paperPageDTO.getId());
		paperAndQuestion.setQuestionId(paperPageDTO.getQuestionId());
		paperAndQuestionMapper.insert(paperAndQuestion);
		paper.setQuestionNum(1);
		paperExtMapper.incQuestion(paper);
		return ResultDTO.okOf("/manage/modifypaper/"+paperPageDTO.getId());
	}


	public List<PaperDTO> list() {
		// TODO Auto-generated method stub
		List<Paper> papers = paperMapper.selectByExample(new PaperExample());
		List<PaperDTO> lists=new ArrayList<PaperDTO>();
		for(Paper paper:papers) {
			PaperDTO paperDTO = new PaperDTO();
			BeanUtils.copyProperties(paper, paperDTO);
			lists.add(paperDTO);
		}
		return lists;
	}



	
}
