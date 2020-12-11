package com.liugx.testsystem.enums;

public enum ReceiverEnum {
	ALL_USER(1,"AllUser"),
	USER_OF_TEST(2,"SomeUser")
	;
	
	public int getType() {
		return recevierType;
	}
	public String getName() {
		return name;
	}
	
	private int recevierType;
	private String name;
	private ReceiverEnum(int receiverType,String name) {
		// TODO Auto-generated constructor stub
		this.recevierType=receiverType;
		this.name=name;
	}
	public static String nameOfType(int type) {
        for (ReceiverEnum receiverEnum : ReceiverEnum.values()) {
            if (receiverEnum.getType() == type) {
                return receiverEnum.getName();
            }
        }
        return "";
    }
}
