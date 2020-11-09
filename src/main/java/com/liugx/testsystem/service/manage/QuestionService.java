package com.liugx.testsystem.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.dto.QuestionCreateDTO;
import com.liugx.testsystem.dto.QuestionDTO;
import com.liugx.testsystem.dto.QuestionQueryDTO;
import com.liugx.testsystem.dto.paper.PaperPageDTO;
import com.liugx.testsystem.execption.CustomizeErrorCode;
import com.liugx.testsystem.execption.CustomizeException;
import com.liugx.testsystem.mapper.PaperMapper;
import com.liugx.testsystem.mapper.QuestionMapper;
import com.liugx.testsystem.model.Paper;
import com.liugx.testsystem.model.PaperExample;
import com.liugx.testsystem.model.Question;
import com.liugx.testsystem.model.QuestionExample;

@Service
public class QuestionService {

	@Autowired
	private QuestionMapper questionMapper;
	
	public boolean insert(QuestionCreateDTO questionDTO) {
		// TODO Auto-generated method stub
		Question question = new Question();
		BeanUtils.copyProperties(questionDTO, question);
		if(questionMapper.insertSelective(question)==0) {
			return false;
		}
		return true;
	}

	public PaginationDTO list(Integer page, Integer size) {
		// TODO Auto-generated method stub
		PaginationDTO paginationDTO=new PaginationDTO();
		Integer totalPage;
		Integer totalCount = (int) questionMapper.countByExample(new QuestionExample());
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
        QuestionExample questionExample =new QuestionExample();
        questionExample.setOrderByClause("id asc");
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(questionExample, new RowBounds(offset,size));
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
		BeanUtils.copyProperties(questionDTO, question);
		if(questionMapper.updateByPrimaryKey(question)==0) {
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
		if(questionMapper.updateByPrimaryKey(question)==0) {
			return false;
		}
		return true;
	}

	public List<QuestionDTO> list() {
		// TODO Auto-generated method stub
		List<Question> questions = questionMapper.selectByExample(new QuestionExample());
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTOList.add(questionDTO);
        }
		return questionDTOList;
	}

	public List<QuestionDTO> list(List<Long> questions) {
		// TODO Auto-generated method stub
		List lists=new ArrayList<QuestionDTO>();
		for(Long id:questions) {
			Question question = questionMapper.selectByPrimaryKey(id);
			if(question==null) {
				throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
			}
			QuestionDTO questionDTO = new QuestionDTO(question);
			
			lists.add(questionDTO);
		}
		return lists;
	}


	
}
