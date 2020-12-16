package com.liugx.testsystem.schedule;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import com.liugx.testsystem.enums.MessageTypeEnum;
import com.liugx.testsystem.enums.ReceiverEnum;
import com.liugx.testsystem.model.Test;
import com.liugx.testsystem.service.manage.NotifyService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DelayQueueManage implements CommandLineRunner{
	@Autowired
	private NotifyService notifyService;
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	private DelayQueue<Delayed> delayQueue=new DelayQueue<Delayed>();
	
	
	public void put(Delayed delayed) {
		delayQueue.add(delayed);
	}
	
	public void remove(Delayed delayed) {
		delayQueue.remove(delayed);
	}
	
	private void excuteThread() {
        while (true) {
            try {
                DelayTask task = (DelayTask) delayQueue.take();
                processTask(task);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
	
	private void processTask(DelayTask task) {
		log.info("定时任务以启动！"+((Test)task.getData()).getName()+"考试开始了");
		notifyService.createNotify((Test)task.getData(),ReceiverEnum.USER_OF_TEST, MessageTypeEnum.TEST_STARTING);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		taskExecutor.execute(new Thread(this::excuteThread));
	}
}
