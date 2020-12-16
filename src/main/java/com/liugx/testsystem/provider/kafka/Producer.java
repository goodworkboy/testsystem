package com.liugx.testsystem.provider.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Producer {
	private final KafkaTemplate kafkaTemplate;

	public static final String TOPIC= "testTopic";
	
	public static final String GROUP="testGroup";
	
    @Autowired
    public Producer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

	public void send(String topic,Object message) {
		// TODO Auto-generated method stub
		log.info(topic+" 生产了一条消息     "+message.toString());
		kafkaTemplate.send(topic, message);
	}
}
