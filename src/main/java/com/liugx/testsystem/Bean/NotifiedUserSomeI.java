package com.liugx.testsystem.Bean;

import java.util.List;

import com.liugx.testsystem.mapper.UserTestMapper;
import com.liugx.testsystem.model.User;

public class NotifiedUserSomeI implements NotifiedUser{

	private UserTestMapper userTestMapper;
	
	
	public NotifiedUserSomeI(UserTestMapper userTestMapper) {
		super();
		// TODO Auto-generated constructor stub
		this.userTestMapper=userTestMapper;
	}


	@Override
	public List<User> getUsers(Long testId) {
		// TODO Auto-generated method stub
		return userTestMapper.selectUserByTestId(testId);
	}

}
