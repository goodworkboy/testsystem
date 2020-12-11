package com.liugx.testsystem.cache.mybatis;

import java.util.Set;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheKey;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.liugx.testsystem.enums.ExpireStrategy;
import com.liugx.testsystem.enums.ExpireStrategyEnum;
import com.liugx.testsystem.util.ApplicationContextUtil;
import com.liugx.testsystem.util.ExpireStrategyUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MybatisCache implements Cache{
	private String id;
	public  MybatisCache(String id) {
		// TODO Auto-generated constructor stub
		this.id=id;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void putObject(Object key, Object value) {
		// TODO Auto-generated method stub
		HashOperations<String, String, Object> hashOperations = (HashOperations<String, String, Object>) ApplicationContextUtil
				.getBean("hashOperations");
		RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) ApplicationContextUtil.getBean("template");
		hashOperations.put(id, key.toString(), value);
		ExpireStrategy expireStrategy = ExpireStrategyUtil.getExpireStrategy(ExpireStrategyEnum.DEFAULT_EXPIRE);
		redisTemplate.expire(id, expireStrategy.getTime(),expireStrategy.getTimeUnit());
		
	}

	@Override
	public Object getObject(Object key) {
		// TODO Auto-generated method stub
		HashOperations<String, String, Object> hashOperations = (HashOperations<String, String, Object>) ApplicationContextUtil
				.getBean("hashOperations");
		//Object object =hashOperations.get(id,id.toString());
		return hashOperations.get(id, key.toString());
	}

	
	@Override
	public Object removeObject(Object key) {
		// TODO Auto-generated method stub
		
		System.out.println("该方法未实现");
		log.debug("QuestionCache removeObject invoke error,{}", key);
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		HashOperations<String, String, Object> hashOperations = (HashOperations<String, String, Object>) ApplicationContextUtil
				.getBean("hashOperations");
		Set<String> keys=hashOperations.keys(id);
		keys.forEach(key->hashOperations.delete(id, key));
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		HashOperations<String, String, Object> hashOperations = (HashOperations<String, String, Object>) ApplicationContextUtil
				.getBean("hashOperations");
		return hashOperations.keys(id).size();
	}
}
