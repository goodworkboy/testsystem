package com.liugx.testsystem.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}
	
	public static Object getBean(String id) {
		return applicationContext.getBean(id);
	}
	
	public static Object getBean(Class clazz) {
		return applicationContext.getBean(clazz);
	}
	
	public static Object getBean(String id,Class clazz) {
		return applicationContext.getBean(id,clazz);
	}
}	
