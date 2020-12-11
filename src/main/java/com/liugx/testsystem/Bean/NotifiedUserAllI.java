package com.liugx.testsystem.Bean;

import java.util.List;

import com.liugx.testsystem.mapper.UserMapper;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.model.UserExample;

import lombok.Data;

@Data
public class NotifiedUserAllI implements NotifiedUser{
	
	private UserMapper userMapper;
	
	public NotifiedUserAllI(UserMapper userMapper) {
		super();
		// TODO Auto-generated constructor stub
		this.userMapper=userMapper;
	}

	@Override
	public List<User> getUsers(Long testId) {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(new UserExample());
	}
	
}
