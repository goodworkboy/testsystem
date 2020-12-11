package com.liugx.testsystem.enums;

public enum GeneratorIdEnum {
	USER_AND_TEST("userandtest"), 
	USER_TEST_INFO("userTestInfo"), 
	USER("user"), 
	NOTICE("notice"), 
	MESSAGE("message"), 
	PAPER("paper"), 
	QUESTION("question"), 
	TEST("test")

	;
	private String key;
	
	private GeneratorIdEnum(String key) {
		// TODO Auto-generated constructor stub
		this.key=key;
	}
	
	public String getKey() {
		return this.key;
	}
}
