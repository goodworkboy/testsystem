package com.liugx.testsystem.enums;

public enum NotificationStatusEnum {
	READED(true),
	UNREADED(false)
	;
	private boolean status;
	private NotificationStatusEnum(boolean status) {
		// TODO Auto-generated constructor stub
		this.status=status;
	}
	public boolean getStatus() {
		return this.status;
	}
}
