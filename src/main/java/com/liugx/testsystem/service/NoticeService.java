package com.liugx.testsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liugx.testsystem.dto.MessageDTO;
import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.dto.QuestionQueryDTO;
import com.liugx.testsystem.enums.NotificationStatusEnum;
import com.liugx.testsystem.execption.CustomizeErrorCode;
import com.liugx.testsystem.execption.CustomizeException;
import com.liugx.testsystem.mapper.MessageMapper;
import com.liugx.testsystem.mapper.NoticeMapper;
import com.liugx.testsystem.model.Message;
import com.liugx.testsystem.model.MessageExample;
import com.liugx.testsystem.model.User;

@Service
public class NoticeService {
	
	@Autowired
	private MessageMapper messageMapper;
	
	public PaginationDTO list(User user, Integer page, Integer size) {
		// TODO Auto-generated method stub
		PaginationDTO paginationDTO=new PaginationDTO();
		Integer totalPage;
		Integer totalCount = (int) messageMapper.countByExample(new MessageExample());
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
        MessageExample messageExample=new MessageExample();
        messageExample.createCriteria().andUserIdEqualTo(user.getId());
        messageExample.setOrderByClause("create_time desc");
        List<Message> messages = messageMapper.selectByExampleWithRowbounds(messageExample, new RowBounds(offset,size));
        List<MessageDTO> messageDTOs = new ArrayList<>();
        for (Message message : messages) {
            MessageDTO messageDTO = new MessageDTO();
            BeanUtils.copyProperties(message, messageDTO);
            messageDTOs.add(messageDTO);
        }
        paginationDTO.setData(messageDTOs);
		return paginationDTO;
	}

	public MessageDTO read(Long id, User user) {
		// TODO Auto-generated method stub
		Message message=messageMapper.selectByPrimaryKey(id);
		if (message == null) {
			throw new CustomizeException(CustomizeErrorCode.MESSAGE_NOT_FOUND);
		}
		if (!Objects.equals(message.getUserId(), user.getId())) {
			throw new CustomizeException(CustomizeErrorCode.READ_MESSAGE_FAIL);
		}
		message.setStatus(NotificationStatusEnum.READED.getStatus());
		messageMapper.updateByPrimaryKey(message);
		MessageDTO messageDTO= new MessageDTO();
		BeanUtils.copyProperties(message, messageDTO);
		return messageDTO;
	}

	public int unreadCount(User user) {
		MessageExample example= new MessageExample();
		example.createCriteria().andUserIdEqualTo(user.getId())
			.andStatusEqualTo(NotificationStatusEnum.UNREADED.getStatus());
		return (int) messageMapper.countByExample(example);
	}

	
}
