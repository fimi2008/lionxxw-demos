package com.lionxxw.sm.listener;

import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.lionxxw.sm.beans.User;
import com.lionxxw.sm.utils.SessionUtil;

public class MyHttpSessionListener implements HttpSessionListener {
	
	private int userNum;

	public void sessionCreated(HttpSessionEvent se) {
		userNum++;
		System.out.println("sessionCreated在线用户人数:"+ userNum);
		se.getSession().setAttribute("userNum", userNum);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		userNum--;
		System.out.println("sessionDestroyed在线用户人数:"+ userNum);
		se.getSession().setAttribute("userNum", userNum);
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>)se.getSession().getServletContext().getAttribute("users");
		SessionUtil.removeUsersBySessionId(users, se.getSession().getId());
		se.getSession().setAttribute("users", users);
	}
}