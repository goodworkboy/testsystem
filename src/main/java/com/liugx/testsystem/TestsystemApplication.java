package com.liugx.testsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.liugx.testsystem.mapper")
@EnableScheduling
public class TestsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsystemApplication.class, args);
	}
	
}
