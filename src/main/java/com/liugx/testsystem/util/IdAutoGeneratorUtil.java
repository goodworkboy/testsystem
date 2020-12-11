package com.liugx.testsystem.util;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.liugx.testsystem.enums.GeneratorIdEnum;

@Component
public class IdAutoGeneratorUtil {
	
	@Autowired
	private static RedisTemplate redisTemplate;
	
	private static int size=10;
	
	private static Long startKey = 1000000L;
	@Transactional
	public static Long generatorId(String key) {
		if(redisTemplate ==null) {
			redisTemplate=(RedisTemplate) ApplicationContextUtil.getBean("template");
		}
		if(!redisTemplate.hasKey(key)||redisTemplate.opsForList().size(key+"List")==0) {
			doGeneratorId(key);
		}
		Integer value = (Integer) redisTemplate.opsForList().leftPop(key+"List");
		RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory()); 
		return Long.valueOf(value);
	}
	
	@Transactional
	private static void doGeneratorId(String key) {
		String okey=key;
		key=key+"Gen";
		redisTemplate.opsForValue().setIfAbsent(key, startKey);
		List<Long> klist= new ArrayList<Long>(size);
		for(int i=0;i<10;i++) {
			klist.add(redisTemplate.opsForValue().increment(key));
		}
		redisTemplate.opsForList().rightPushAll(okey+"List",klist);
		RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory()); 
	}

	public static Long generatorId(GeneratorIdEnum notice) {
		// TODO Auto-generated method stub
		return generatorId(notice.getKey());
	}
}
