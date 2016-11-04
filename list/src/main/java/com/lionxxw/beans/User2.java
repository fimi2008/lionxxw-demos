package com.lionxxw.beans;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class User2 implements Serializable{
	
	private static final long serialVersionUID = -7731692346466310565L;

	@Setter
	@Getter
	private String id;
	
	@Setter
	@Getter
	private String userId;
	
	@Setter
	@Getter
	private String teamId;
	
	@Setter
	@Getter
	private String name;

	public User2(String id, String userId, String teamId, String name) {
		super();
		this.id = id;
		this.userId = userId;
		this.teamId = teamId;
		this.name = name;
	}
	
}