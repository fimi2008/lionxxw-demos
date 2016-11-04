package com.lionxxw.sm.beans;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class User implements Serializable{
	private static final long serialVersionUID = 2174665947341266884L;

	@Getter
	@Setter
	private String sessionId;
	
	@Getter
	@Setter
	private String ipAddr;
	
	@Getter
	@Setter
	private String firsetTime;
}
