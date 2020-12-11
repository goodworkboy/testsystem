package com.liugx.testsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

import com.liugx.testsystem.config.RedisConfig;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.util.IdAutoGeneratorUtil;

@SpringBootTest
@Import(value = { RedisConfig.class })
class TestsystemApplicationTests {

	
	@Resource(name="template")
	private RedisTemplate<String, User> template;
	
	
	@Test
	void contextLoads() {
		Set<String> lists = new HashSet<String>(100);
		System.out.println("开始！");
		CountDownLatch countDownLatch = new CountDownLatch(10);
		for(int i =0;i<1000;i++) {
			new Thread(
					()->{
						for(int j=0;j<100;j++) {
							lists.add(IdAutoGeneratorUtil.generatorId("user").toString());
						}
						countDownLatch.countDown();
					}
					).start();;
		}
		try {
			countDownLatch.await();
			System.out.println("结束！");
			lists.forEach(str ->{
				System.out.println(str);
			});
			System.out.println(lists.size());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
