package com.liugx.testsystem.Bean;

import java.util.List;

import com.liugx.testsystem.model.User;

public interface NotifiedUser {
	List<User> getUsers(Long testId);
}
