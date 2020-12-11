package com.liugx.testsystem.enums;

public enum MessageTypeEnum{
	PUBLISH_NEW_TEST(101,"发布了新考试，考试名称为："), 
	MODIFY_TEST(102,"考试信息更新，更新的考试是：")
	;
	private int type;
	private String name;
	private MessageTypeEnum(int type,String name) {
		// TODO Auto-generated constructor stub
		this.type=type;
		this.name=name;
	}
	public int getType() {
		// TODO Auto-generated method stub
		return this.type;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	public static String nameOfType(int type) {
        for (MessageTypeEnum messageAllUserEnum : MessageTypeEnum.values()) {
            if (messageAllUserEnum.getType() == type) {
                return messageAllUserEnum.getName();
            }
        }
        return "";
    }
	
	public static boolean isAllUser(int status) {
		if(status/100==1) return true;
		else return false;
	}
}
