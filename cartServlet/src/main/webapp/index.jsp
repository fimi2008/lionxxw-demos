<%@ page language="java" import="java.util.*,com.lionxxw.cart.entity.*,com.lionxxw.cart.dao.*" pageEncoding="utf-8" isELIgnored="false"%>
<html>
<body>
<h2>商品列表</h2>
<table>
	<tr>
		<th>商品编号</th>
		<th>商品名称</th>
		<th>单价</th>
		<th>库存</th>
		<th>操作</th>
	</tr>
	<%
	ItemsDao dao = new ItemsDao();
	List<Items> list = dao.query(null);
	if (null != list && list.size() > 0){
		for (Items item : list){
		%>
			<tr>
				<td><%=item.getId() %></td>
				<td><%=item.getName() %></td>
				<td><%=item.getPrice() %></td>
				<td><%=item.getInNum() %></td>
				<td><a href="/cart/CartServlet?id=<%=item.getId() %>&action=add&num=1">加入购物车</a></td>
			</tr>
		<%}
	}
	%>
</table>
<a href="/cart/cart.jsp">查看购物车</a>
</body>
</html>
