<%@ page language="java" import="java.util.*,com.lionxxw.sm.beans.*" pageEncoding="utf-8" isELIgnored="false"%>
<html>
<body>
<h2>在线用户人数:${userNum}</h2>
<%
	List<User> users = (List<User>)request.getServletContext().getAttribute("users");
	if (null != users && users.size() > 0){
		for (User user : users){
			%>
			IP:<%=user.getIpAddr() %>, 第一次登入时间:<%=user.getFirsetTime() %>, SESSIONID:<%=user.getSessionId() %><br/>
			<%
		}
	}
%>
</body>
</html>
