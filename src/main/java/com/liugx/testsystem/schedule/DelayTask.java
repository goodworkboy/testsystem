package com.liugx.testsystem.schedule;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import com.liugx.testsystem.model.Test;

import lombok.Data;

@Data
public class DelayTask implements Delayed{
	
	private Object data;
	private Long expire;

	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		return (int) (this.expire-o.getDelay(TimeUnit.NANOSECONDS));
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return unit.convert(this.expire-System.currentTimeMillis(), unit);
	}

	public DelayTask(Object data, Long expire) {
		super();
		this.data = data;
		this.expire = expire;
	}

	
	
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof DelayTask) {
            return ((Test)this.data).getId().equals(((Test)((DelayTask) obj).getData()).getId());
        }
        return false;
    }

	public DelayTask(Object data) {
		super();
		this.data = data;
		this.expire=((Test)data).getStartTime()-System.currentTimeMillis();
	}
	
	
}
