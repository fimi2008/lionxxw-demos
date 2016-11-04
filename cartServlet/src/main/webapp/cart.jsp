<%@ page language="java" import="java.util.*,com.lionxxw.cart.entity.*,com.lionxxw.cart.dao.*" pageEncoding="utf-8" isELIgnored="false"%>
<html>
<head>
	<title>快乐购</title>
	<style type="text/css">
	table tr td,th{border:1px solid #000}
	</style>
</head>
<body>
<h2>购物车列表</h2>
<table>
	<tr>
		<th>商品编号</th>
		<th>商品名称</th>
		<th>单价</th>
		<th>数量</th>
		<th>操作</th>
	</tr>
	<%
	
	if (null != request.getSession().getAttribute("cart")){
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		HashMap<Items, Integer> goods = cart.getGoods();
		Set<Items> set = goods.keySet();
		for (Items item : set){
		%>
			<tr>
				<td><%=item.getId() %></td>
				<td><%=item.getName() %></td>
				<td><%=item.getPrice() %></td>
				<td><%=goods.get(item) %></td>
				<td><a href="/cart/CartServlet?id=<%=item.getId() %>&action=remove" onclick="delcfm(event);">删除</a></td>
			</tr>
		<%}
	}
	%>
</table>
<a href="/cart/index.jsp">返回商品列表</a>
<script type="text/javascript">
function delcfm(e){
	if (!confirm("确认要删除?")){
		 if(window.event){
			 window.event.returnValue = false;
		 }else{
			 e.preventDefault(); //for firefox
		 }
	}
}
</script>
</body>
</html>
