package com.liugx.testsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.liugx.testsystem.Bean.NotifiedUserAllI;
import com.liugx.testsystem.Bean.NotifiedUserSomeI;
import com.liugx.testsystem.mapper.UserMapper;
import com.liugx.testsystem.mapper.UserTestMapper;

@Configuration
public class NotifyStrategyConfig {
	@Bean
	@Autowired
	public NotifiedUserAllI notifyAllUser(UserMapper userMapper) {
		return new NotifiedUserAllI(userMapper);
	}
	
	@Bean
	@Autowired
	public NotifiedUserSomeI notifySomeUser(UserTestMapper userTestMapper) {
		return new NotifiedUserSomeI(userTestMapper);
	}
}
