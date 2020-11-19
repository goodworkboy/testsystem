package com.liugx.testsystem.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private SessionInterceptor sessionInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LocaleChangeInterceptor());
		List<String> excludePath=new ArrayList<String>();
		excludePath.add("/manage/**");
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/user/**").excludePathPatterns(excludePath);
    }
}
