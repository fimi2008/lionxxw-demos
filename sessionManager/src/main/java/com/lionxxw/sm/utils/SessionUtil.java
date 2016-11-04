package com.lionxxw.sm.utils;

import java.util.Iterator;
import java.util.List;

import com.lionxxw.sm.beans.User;

public class SessionUtil {
	public static Object getUserBySessionId(List<User> users, String sessionId){
		if (null != users && users.size() > 0){
			for (User user : users){
				if (sessionId.equals(user.getSessionId())){
					return user;
				}
			}
		}
		return null;
	}
	
	public static void removeUsersBySessionId(List<User> users, String sessionId){
		if (null != users && users.size() > 0){
			Iterator<User> it = users.iterator();
			while(it.hasNext()){
				User user = it.next();
				if (sessionId.equals(user.getSessionId())){
					it.remove();
				}
			}
		}
	}
}
