package com.liugx.testsystem.config;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.SessionScope;

import com.liugx.testsystem.model.User;
import com.liugx.testsystem.provider.kafka.Customer;

@Configuration
public class KafkaConfig {
	
	private String servers="localhost:9092";
    private String sessionOut="3000";
    private int retry=3;
    private int batchSize=232840;
    private String bufferMemory="33554432";
    private String kafkaPassword="";
    private String kafkaUserName="";
    private String enableAutoCommit="true";

    //    --------------consumer-----------------
    private String autoCommitInterval="1000";
	
	@Bean(destroyMethod = "close")
	@SessionScope
	@Autowired
	public KafkaConsumer kafkaConsumer(HttpServletRequest request) {
		
		User user=(User) request.getSession().getAttribute("user");
		System.out.println("创建了新的kafkaConsumer消费者！"+user.getName());
        Properties props = new Properties();
        props.put("bootstrap.servers", servers);
        props.put("group.id", user.getStudentNum()+user.getName());
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return new KafkaConsumer(props);
    }
	
}
