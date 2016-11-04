package com.lionxxw.beans;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class User implements Serializable{

	private static final long serialVersionUID = 6157682863678957734L;
	
	@Getter
	@Setter
	private String id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String sex;

	@Override
	public int hashCode() {
		return id.hashCode()+name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj instanceof User){
			User i = (User)obj;
			if (this.getId() == i.getId() && this.getName().equals(i.getName())){
				return true;
			}else{
				return false;
			}
		}else if(obj instanceof User2){
			User2 i = (User2)obj;
			if (this.getId() == i.getUserId()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public User(String id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
}