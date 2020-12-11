package com.liugx.testsystem.util;

import com.liugx.testsystem.cache.mybatis.ExpireStrategyImp;
import com.liugx.testsystem.enums.ExpireStrategy;

public class ExpireStrategyUtil {
	
	public static ExpireStrategy getExpireStrategy(ExpireStrategy expireStrategy) {
		ExpireStrategyImp expireStrategyImp = new ExpireStrategyImp();
		expireStrategyImp.setTime((int) (expireStrategy.getTime()+expireStrategy.getGap()*Math.random()));
		expireStrategyImp.setTimeUnit(expireStrategy.getTimeUnit());
		return expireStrategyImp;
	}
}
