package com.liugx.testsystem.util;

import org.springframework.stereotype.Component;

import com.liugx.testsystem.enums.ReceiverEnum;
import com.liugx.testsystem.model.Test;

@Component
public class TopicNameGeneratorUtil {
	public static String getName(Test test,ReceiverEnum recevierType) {
		if(recevierType==ReceiverEnum.ALL_USER) {
			return recevierType.getName();
		}
		return test.getId().toString()+recevierType.getName();
	}
}
