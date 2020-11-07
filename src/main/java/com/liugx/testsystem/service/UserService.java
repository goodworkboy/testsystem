package com.liugx.testsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liugx.testsystem.dto.RegisterDTO;
import com.liugx.testsystem.dto.UserDTO;
import com.liugx.testsystem.mapper.UserMapper;
import com.liugx.testsystem.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User selectUser(UserDTO userdto) {
		// TODO Auto-generated method stub
		List<User> users=userMapper.selectUserByNumAndPasswd(userdto);
		if(users.size()!=0)
			return users.get(0);
		return null;
	}
	
	public User selectUserByStudentNum(String studentNum) {
		List<User> users=userMapper.selectUserByStudentNum(studentNum);
		if(users.size()!=0)
			return users.get(0);
		return null;
	}
	
	public boolean createUser(RegisterDTO registerDTO) {
		// TODO Auto-generated method stub
		if(userMapper.insertUser(registerDTO)==0) {
			return false;
		}else {
			return true;
		}
	}

}
