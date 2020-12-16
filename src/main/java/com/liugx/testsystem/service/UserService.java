package com.liugx.testsystem.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liugx.testsystem.dto.RegisterDTO;
import com.liugx.testsystem.dto.UserDTO;
import com.liugx.testsystem.enums.GeneratorIdEnum;
import com.liugx.testsystem.mapper.UserMapper;
import com.liugx.testsystem.mapper.UserTopicMapper;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.model.UserExample;
import com.liugx.testsystem.model.UserTopic;
import com.liugx.testsystem.util.IdAutoGeneratorUtil;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserTopicService userTopicService;
	
	public User selectUser(UserDTO userdto) {
		
		UserExample example=new UserExample();
		example.createCriteria()
			.andStudentNumEqualTo(userdto.getStudentNum())
			.andPasswordEqualTo(userdto.getPassword());
		List<User> users=userMapper.selectByExample(example);
		if(users.size()!=0)
			return users.get(0);
		return null;
	}
	
	public User selectUserByStudentNum(String studentNum) {
		UserExample example=new UserExample();
		example.createCriteria()
			.andStudentNumEqualTo(studentNum);
		List<User> users=userMapper.selectByExample(example);
		if(users.size()!=0)
			return users.get(0);
		return null;
	}
	
	public boolean createUser(RegisterDTO registerDTO) {
		// TODO Auto-generated method stub
		User insertUser =new User();
		BeanUtils.copyProperties(registerDTO,insertUser);
		insertUser.setId(IdAutoGeneratorUtil.generatorId(GeneratorIdEnum.USER.getKey()));
		if(userMapper.insertSelective(insertUser)==0) {
			return false;
		}else {
			String topic = "AllUser";
			userTopicService.insertUserTopic(insertUser, topic);;
			return true;
		}
	}

}
