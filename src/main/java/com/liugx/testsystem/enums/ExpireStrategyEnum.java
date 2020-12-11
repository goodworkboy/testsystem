package com.liugx.testsystem.enums;

import java.util.concurrent.TimeUnit;

public enum ExpireStrategyEnum implements ExpireStrategy{
	QUESTION_MAP_EXPIRE(20,TimeUnit.HOURS,10),
	DEFAULT_EXPIRE(5,TimeUnit.HOURS,10)
	;
	private Integer time;
	private TimeUnit timeUnit;
	private Integer gap;
	private ExpireStrategyEnum(Integer time, TimeUnit timeUnit,Integer gap) {
		// TODO Auto-generated constructor stub
		this.time=time;
		this.timeUnit=timeUnit;
		this.gap=gap;
	}
	
	@Override
	public Integer getTime() {
		// TODO Auto-generated method stub
		return time;
	}

	@Override
	public TimeUnit getTimeUnit() {
		// TODO Auto-generated method stub
		return timeUnit;
	}

	@Override
	public Integer getGap() {
		// TODO Auto-generated method stub
		return this.gap;
	}
	
	
}
