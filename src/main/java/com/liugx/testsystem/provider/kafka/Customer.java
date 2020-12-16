package com.liugx.testsystem.provider.kafka;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.liugx.testsystem.model.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Customer{	
	
	 public void processMessage(String content) {
		 System.out.println("接受数据！");
		 log.info("customer消费了一条消息" + ",Message:" + content);
		 System.out.println(content);
    }
	 
	 
}
