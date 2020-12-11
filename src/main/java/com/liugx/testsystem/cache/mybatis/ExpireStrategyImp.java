package com.liugx.testsystem.cache.mybatis;

import java.util.concurrent.TimeUnit;

import com.liugx.testsystem.enums.ExpireStrategy;


public class ExpireStrategyImp implements ExpireStrategy{
	private Integer time;
	private TimeUnit timeUnit;
	public void setTime(Integer time) {
		this.time = time;
	}

	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}

	@Override
	public Integer getTime() {
		// TODO Auto-generated method stub
		return this.time;
	}

	@Override
	public TimeUnit getTimeUnit() {
		// TODO Auto-generated method stub
		return this.timeUnit;
	}

	@Override
	public Integer getGap() {
		// TODO Auto-generated method stub
		return null;
	}

}
