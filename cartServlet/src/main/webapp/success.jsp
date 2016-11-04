<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  isELIgnored="false"%>
<html>
<body>
<h2>添加购物车成功</h2>
<hr/>
<%
	String id = request.getParameter("id");
	String num = request.getParameter("num");
%>
>>>>>>>>>>>>>>>>>>>>>您成功添加了<%=num %>件商品编号为<%=id %>的商品>>>>>>>>>>>>><br/>
<a href="/cart/index.jsp">返回商品列表</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/cart/cart.jsp">查看购物车</a>
</body>
</html>
