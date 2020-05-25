<%@page import="com.bookstore.vo.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bookstore.css" type="text/css" />
</head>
<body>
	<div class="wrapper">
		<div class="navi">
			<%
				String position = "order";
			%>
			<%@ include file="../common/navibar.jsp"%>
		</div>
		<div class="header">
			<h1>주문 리스트</h1>
		</div>
		<div class="body">
			<div>
				<h3>모든 주문 리스트</h3>
				<table class="table">
					<thead>
						<tr>
							<th>주문번호</th>
							<th>주문자아이디</th>
							<th>책번호</th>
							<th>주문가격</th>
							<th>주문수량</th>
							<th colspan="2">주문날짜</th>
						</tr>
					</thead>
					<tbody>
					<%
						OrderDao orderDao = new OrderDao();
						List<Order> orders = orderDao.getAllOrders();
						for (Order order : orders) {
							
					%>
						<tr>
							<td><%=order.getNo() %></td>
							<td><a href="/bookstore/order/detail.jsp?userid=<%=order.getUserId()%>"><%=order.getUserId() %></a></td>
							<td><%=order.getBookNo() %></td>
							<td><%=order.getPrice() %></td>
							<td><%=order.getAmount() %></td>
							<td><%=order.getRegisteredDate() %></td>
							<td><a href="">리뷰작성</a></td>
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>