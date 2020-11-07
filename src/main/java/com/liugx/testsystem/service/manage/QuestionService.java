package com.liugx.testsystem.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.dto.QuestionCreateDTO;
import com.liugx.testsystem.dto.QuestionDTO;
import com.liugx.testsystem.dto.QuestionQueryDTO;
import com.liugx.testsystem.execption.CustomizeErrorCode;
import com.liugx.testsystem.execption.CustomizeException;
import com.liugx.testsystem.mapper.manage.QuestionMapper;
import com.liugx.testsystem.model.Question;

@Service
public class QuestionService {

	@Autowired
	private QuestionMapper questionMapper;
	
	public boolean insert(QuestionCreateDTO questionDTO) {
		// TODO Auto-generated method stub
		if(questionMapper.insertQuestion(questionDTO)==0) {
			return false;
		}
		return true;
	}

	public PaginationDTO list(Integer page, Integer size) {
		// TODO Auto-generated method stub
		PaginationDTO paginationDTO=new PaginationDTO();
		Integer totalPage;
		Integer totalCount = questionMapper.countQuestions();
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
        QuestionQueryDTO questionQueryDTO=new QuestionQueryDTO();
        questionQueryDTO.setSize(size);
        questionQueryDTO.setOffset(offset);
        List<Question> questions = questionMapper.selectQuestionsByPage(questionQueryDTO);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setData(questionDTOList);
		return paginationDTO;
	}

	public QuestionDTO getById(Long id) {
		// TODO Auto-generated method stub
		Question question = questionMapper.selectByPrimaryKey(id);
        if (question == null) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        questionDTO.setAnswer(question.getAnswer().toString());
		return questionDTO;
	}

	public boolean update(QuestionDTO questionDTO) {
		// TODO Auto-generated method stub
		Question question = questionMapper.selectByPrimaryKey(questionDTO.getId());
		if(question==null||question.getStatus()) {
			return false;
		}
		if(questionMapper.updateQuestion(questionDTO)==0) {
			return false;
		}
		return true;
	}

	public boolean delete(QuestionDTO questionDTO) {
		// TODO Auto-generated method stub
		Question question = questionMapper.selectByPrimaryKey(questionDTO.getId());
		if(question==null||question.getStatus()) {
			return false;
		}
		if(questionMapper.deleteQuestion(questionDTO)==0) {
			return false;
		}
		return true;
	}
	
}
