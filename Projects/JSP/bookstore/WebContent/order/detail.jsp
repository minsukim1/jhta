<%@page import="com.bookstore.vo.User"%>
<%@page import="com.bookstore.dao.UserDao"%>
<%@page import="com.bookstore.util.NumberUtil"%>
<%@page import="com.bookstore.dto.OrderDto"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link rel="stylesheet" href="../css/bookstore.css" type="text/css" />
</head>
<body>
<body>
	<div class="wrapper">
		<div class="navi">
			<%
				String position = "order";
			%>
			<%@ include file="../common/navibar.jsp"%>
		</div>
		<div class="header">
			<h1>주문 정보</h1>
			<%
				String userId = request.getParameter("userid");
				
				UserDao userDao = new UserDao();
				User user= userDao.getUserById(userId);
				OrderDao orderDao = new OrderDao();
				List<OrderDto> orders = orderDao.getOrdersByUserId(userId);
			%>
		</div>
		<div class="body">
			<h3><%=user.getName()%>님의 주문내역입니다.</h3>
			<p><strong>잔여포인트 : <%=user.getPoint() %></strong></p>	
			
			<table class="table">
				<thead>
					<tr>
						<th>주문번호</th>
						<th>책이름</th>
						<th>가격</th>
						<th>수량</th>
						<th>결제금액</th>
						<th colspan="2">주문날짜</th>
					</tr>
				</thead>
				<tbody>
				<%
					if(orders.isEmpty()){
				%>
					<td class="text-center" colspan="7">주문내역이 존재하지 않습니다.</td>
				<%
					}else {
					for(OrderDto order : orders) {
						
					
				%>
					<tr>
						<td><%=order.getNo() %></td>
						<td><%=order.getBookTitle() %></td>
						<td><%=NumberUtil.numberWithComma(order.getPrice()) %></td>
						<td><%=order.getAmount() %></td>
						<td><%=NumberUtil.numberWithComma(order.getPrice()*order.getAmount()) %></td>
						<td><%=order.getRegisteredDate() %></td>
						<td><a href="../review/form.jsp?userid=<%=userId %>&bookno=<%=order.getBookNo()%>">리뷰작성</a></td>
					</tr>
				<%
						}
					}
				%>
				</tbody>
			</table>
			<div class="text-right">
				<a href="../user/list.jsp">사용자 목록</a>
			</div>
		</div>
	</div>
</body>
</html>