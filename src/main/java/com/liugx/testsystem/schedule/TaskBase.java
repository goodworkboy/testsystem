package com.liugx.testsystem.schedule;

import com.alibaba.fastjson.JSON;

public class TaskBase {
	private String identity;

	public TaskBase(String identity) {
		super();
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSON.toJSONString(this);
	}
	
	
}
