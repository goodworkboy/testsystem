package com.liugx.testsystem.provider.kafka;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.liugx.testsystem.enums.MessageTypeEnum;
import com.liugx.testsystem.enums.NotificationStatusEnum;
import com.liugx.testsystem.execption.CustomizeErrorCode;
import com.liugx.testsystem.execption.CustomizeException;
import com.liugx.testsystem.execption.ICustomizeErrorCode;
import com.liugx.testsystem.mapper.MessageMapper;
import com.liugx.testsystem.model.Message;
import com.liugx.testsystem.model.Notice;
import com.liugx.testsystem.model.User;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class MessageHandler {
	@Autowired
	private MessageMapper messageMapper; 
	public void onMessage(KafkaConsumer kafkaConsumer, List<String> topic,User user) {
        kafkaConsumer.subscribe(topic);
        log.info(user.getName()+"消费了主题"+topic.toString());
        try {
        	ConsumerRecords<String, String> records = kafkaConsumer.poll(2000);
        	for (ConsumerRecord<String, String> record : records) {
        		Notice notice =JSON.parseObject(record.value(), Notice.class);
        		Message message = new Message();
        		message.setTestId(notice.getTestId());
        		message.setStatus(NotificationStatusEnum.UNREADED.getStatus());
        		message.setCreateTime(notice.getCreateTime());
        		message.setMessageType(notice.getMessageType());
        		message.setMessage(MessageTypeEnum.nameOfType(message.getMessageType())+notice.getTestName());
        		message.setUserId(user.getId());
        		log.info(user.getName()+"获得一条新消息"+JSON.toJSONString(message));
        		messageMapper.insert(message);
        	}
        }catch (Exception e) {
			// TODO: handle exception
        	log.error(CustomizeErrorCode.UNKNOW_ERROR.getMessage());
        	log.error(e.getMessage());
        	throw new CustomizeException(CustomizeErrorCode.UNKNOW_ERROR);
		}
        finally {
        	
        }
	}
}
