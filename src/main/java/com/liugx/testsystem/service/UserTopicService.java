package com.liugx.testsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liugx.testsystem.mapper.UserTopicMapper;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.model.UserTopic;
import com.liugx.testsystem.model.UserTopicExample;
import com.liugx.testsystem.util.IdAutoGeneratorUtil;

@Service
public class UserTopicService {

	@Autowired
	private UserTopicMapper userTopicMapper;
	

	public List<String> list(User user) {
		UserTopicExample example = new UserTopicExample();
		example.createCriteria().andUserIdEqualTo(user.getId());
		List<UserTopic> userTopics =userTopicMapper.selectByExample(example);
		List<String> topics = new ArrayList<String>();
		userTopics.forEach(userTopic ->{
			topics.add(userTopic.getTopicName());
		});
		return topics;
	}


	public void insertUserTopic(User user, String topic) {
		// TODO Auto-generated method stub
		
		UserTopicExample example  = new UserTopicExample();
		example.createCriteria().andUserIdEqualTo(user.getId()).andTopicNameEqualTo(topic);
		List<UserTopic> userTopics=userTopicMapper.selectByExample(example);
		if(userTopics.size()>0) return;
		UserTopic userTopic = new UserTopic();
		userTopic.setUserId(user.getId());
		userTopic.setTopicName(topic);
		userTopic.setId(IdAutoGeneratorUtil.generatorId("usertopic"));
		userTopic.setCreateTime(System.currentTimeMillis());
		userTopicMapper.insert(userTopic);
	}


	public void removeUserTopic(User user, String topic) {
		// TODO Auto-generated method stub
		UserTopic userTopic = new UserTopic();
		userTopic.setUserId(user.getId());
		userTopic.setTopicName(topic);
		UserTopicExample example = new UserTopicExample();
		example.createCriteria().andUserIdEqualTo(user.getId()).andTopicNameEqualTo(topic);
		userTopicMapper.deleteByExample(example);
	}
}
