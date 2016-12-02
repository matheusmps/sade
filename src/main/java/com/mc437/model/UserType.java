package com.mc437.model;

import java.io.Serializable;

public enum UserType implements Serializable{
	MEMBER("MEM"),
	DEVELOPER("DEV");
	
	String type;
	
	private UserType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public static UserType getUserType(User user){
		if(user instanceof Developer){
			return UserType.DEVELOPER;
		}else{
			return UserType.MEMBER;
		}
	}
	
	public static UserType findUserType(String type){
		if(type.equals(MEMBER.type))
			return MEMBER;
		else
			return DEVELOPER;
	}
	

}
