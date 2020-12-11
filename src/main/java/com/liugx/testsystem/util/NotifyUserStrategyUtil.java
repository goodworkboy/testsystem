package com.liugx.testsystem.util;

import com.liugx.testsystem.Bean.NotifiedUser;
import com.liugx.testsystem.enums.ReceiverEnum;

public class NotifyUserStrategyUtil {
	public static NotifiedUser getNotifiedUserStrategy(int type) {
		String name="notify";
		name+=ReceiverEnum.nameOfType(type);
		return (NotifiedUser) ApplicationContextUtil.getBean(name);
	}
}
