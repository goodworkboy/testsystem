package com.liugx.testsystem.provider.kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TopicManage {
	private String key="bootstrap.servers";
	private String value="localhost:9092";
	private static final Integer partition = 1;
	private static final Short replica = 1;
	public void createTopic(String topic) {
		List<String> strs= new ArrayList<String>();
		strs.add(topic);
		createTopic(strs);
	}
	
	public void createTopic(List<String> topics) {
		Properties properties = new Properties();
		properties.put(key, value);
		List<NewTopic> topicsList = new ArrayList<NewTopic>();
		for(String str:topics) {
			topicsList.add(new NewTopic(str,partition,replica));
		}
		log.info("创建了一个topic："+ topics.toString());
		AdminClient adminClient=AdminClient.create(properties);
		adminClient.createTopics(topicsList);
		adminClient.close();
	}
	
	public void removeTopic(String topic) {
		List<String> strs= new ArrayList<String>();
		strs.add(topic);
		removeTopic(strs);
	}
	
	public void removeTopic(List<String> topics) {
		Properties properties = new Properties();
		properties.put(key, value);
		AdminClient adminClient=AdminClient.create(properties);
		adminClient.deleteTopics(topics);
		adminClient.close();
	}
	
	public boolean containsTopic(String topic) {
		Properties properties = new Properties();
		properties.put(key, value);
		AdminClient adminClient=AdminClient.create(properties);
		ListTopicsResult topicListResult=adminClient.listTopics();
		KafkaFuture<Set<String>> nameKafkaFuture=topicListResult.names();
		boolean res=false;
		try {
			Set<String> names=nameKafkaFuture.get();
			if(names.contains(topic)) res= true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.debug("contiansTopic 执行时被中断！");
			log.debug(e.getMessage());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			log.debug("contiansTopic 执行时出现未知错误！");
			log.debug(e.getMessage());
		}finally {
			adminClient.close();
			return res;
		}
	}
	public void removeDeletedTopics(List<String> topics) {
		Properties properties = new Properties();
		properties.put(key, value);
		AdminClient adminClient=AdminClient.create(properties);
		ListTopicsResult topicListResult=adminClient.listTopics();
		KafkaFuture<Set<String>> nameKafkaFuture=topicListResult.names();
		try {
			Set<String> names=nameKafkaFuture.get();
			for(int i=0;i<topics.size();i++) {
				if(!names.contains(topics.get(i))) {
					topics.remove(i);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.debug("removeDeletedTopics 执行时被中断！");
			log.debug(e.getMessage());
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			log.debug("removeDeletedTopics 执行时出现未知错误！");
			log.debug(e.getMessage());
		}finally {
			adminClient.close();
		}	
	}
}
