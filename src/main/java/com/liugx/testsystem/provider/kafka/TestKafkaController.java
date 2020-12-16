package com.liugx.testsystem.provider.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestKafkaController {
	
	@Autowired
	private Producer producer;
	
	
	
	@GetMapping("/user/test/send")
	public void send() {
		producer.send("testTopic","ni好");
		
	}
}
