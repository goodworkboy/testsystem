package com.liugx.testsystem;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

import com.liugx.testsystem.config.RedisConfig;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.provider.kafka.Producer;

@SpringBootTest
@Import(value = { RedisConfig.class })
class TestsystemApplicationTests {

	
	@Resource(name="template")
	private RedisTemplate<String, User> template;

	
	@Autowired
	private Producer producer;
	
	@Test
	void contextLoads() {
		System.out.println("你好");
	}
	
}
