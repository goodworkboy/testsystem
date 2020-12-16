package com.liugx.testsystem.service.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.jaxrs.FastJsonAutoDiscoverable;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.liugx.testsystem.Bean.NotifiedUser;
import com.liugx.testsystem.enums.GeneratorIdEnum;
import com.liugx.testsystem.enums.MessageTypeEnum;
import com.liugx.testsystem.enums.NotificationStatusEnum;
import com.liugx.testsystem.enums.ReceiverEnum;
import com.liugx.testsystem.mapper.MessageMapper;
import com.liugx.testsystem.mapper.NoticeMapper;
import com.liugx.testsystem.model.Message;
import com.liugx.testsystem.model.Notice;
import com.liugx.testsystem.model.Test;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.provider.kafka.Producer;
import com.liugx.testsystem.provider.kafka.TopicManage;
import com.liugx.testsystem.util.IdAutoGeneratorUtil;
import com.liugx.testsystem.util.NotifyUserStrategyUtil;
import com.liugx.testsystem.util.TopicNameGeneratorUtil;

@Service
public class NotifyService {
	
	@Autowired 
	private NoticeMapper noticeMapper;
	
	@Autowired
	private MessageMapper messageMapper;
	
	@Autowired
	private Producer producer;
	
	@Autowired
	private TopicManage topicManage;
	
	/*public void createNotify(Test test,ReceiverEnum recevierType,MessageTypeEnum messageType) {
		Notice notice = new Notice();
		notice.setTestId(test.getId());
		notice.setReciverType(recevierType.getType());
		notice.setMessageType(messageType.getType());
		notice.setStatus(NotificationStatusEnum.UNREADED.getStatus());
		notice.setCreateTime(System.currentTimeMillis());
		notice.setTestName(test.getName());
		notice.setId(IdAutoGeneratorUtil.generatorId(GeneratorIdEnum.NOTICE));
		noticeMapper.insert(notice);//将发布消息插入到数据库中保存，现已将消息转存到kafka中了
		notifyUser(notice);
	}*/
	
	
	public void createNotify(Test test,ReceiverEnum recevierType,MessageTypeEnum messageType) {
		Notice notice = new Notice();
		notice.setTestId(test.getId());
		notice.setReciverType(recevierType.getType());
		notice.setMessageType(messageType.getType());
		notice.setStatus(NotificationStatusEnum.UNREADED.getStatus());
		notice.setCreateTime(System.currentTimeMillis());
		notice.setTestName(test.getName());
		notice.setId(IdAutoGeneratorUtil.generatorId(GeneratorIdEnum.NOTICE));
		String topic=TopicNameGeneratorUtil.getName(test, recevierType);
		topicManage.createTopic(topic);
		String message = JSON.toJSONString(notice);
		producer.send(topic, message);
	}
	
	public void notifyUser(Notice notice) {
		NotifiedUser notifiedUser = NotifyUserStrategyUtil.getNotifiedUserStrategy(notice.getReciverType());
		List<User> users = notifiedUser.getUsers(notice.getTestId());
		Message message = new Message();
		message.setTestId(notice.getTestId());
		message.setStatus(NotificationStatusEnum.UNREADED.getStatus());
		message.setCreateTime(notice.getCreateTime());
		message.setMessageType(notice.getMessageType());
		message.setMessage(MessageTypeEnum.nameOfType(message.getMessageType())+notice.getTestName());
		users.forEach(user -> {
			message.setUserId(user.getId());
			message.setId(IdAutoGeneratorUtil.generatorId(GeneratorIdEnum.MESSAGE));
			messageMapper.insert(message);
		});
	}
}
