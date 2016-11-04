package com.lionxxw.sm.listener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import com.lionxxw.sm.beans.User;
import com.lionxxw.sm.utils.SessionUtil;

public class MyServletRequestListener implements ServletRequestListener {
	private static List<User> users = new ArrayList<User>();	// 在线用户集合

	public void requestDestroyed(ServletRequestEvent sre) {

	}

	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
		String sessionId = request.getSession().getId();
		if (null == SessionUtil.getUserBySessionId(users, sessionId)){
			User user = new User();
			user.setSessionId(sessionId);
			user.setFirsetTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			user.setIpAddr(request.getRemoteAddr());
			users.add(user);
			
			request.getServletContext().setAttribute("users", users);
		}
	}
}