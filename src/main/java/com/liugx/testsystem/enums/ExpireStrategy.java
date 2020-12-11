package com.liugx.testsystem.enums;

import java.util.concurrent.TimeUnit;

public interface ExpireStrategy {
	public Integer getTime();
	public TimeUnit getTimeUnit();
	public Integer getGap();
}
