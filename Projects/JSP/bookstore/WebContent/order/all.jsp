<%@page import="com.bookstore.util.NumberUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bookstore.dao.OrderDao"%>
<%@page import="java.util.Collections"%>
<%@page import="com.bookstore.dto.OrderDto"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
<style type="text/css">
label {
	font-weight: bold;
}

select {
	display: inline-block;
	width: 200px;
	height: 37px;
}

button {
	height: 37px;
}
</style>
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
			<h1>주문내역</h1>
		</div>
		<div class="body">
			<%
			
				if(!"Yes".equals(isLogined)) {
					response.sendRedirect("/bookstore/user/loginform.jsp?error=deny");
					return;
				}
				String username = (String) session.getAttribute("이름");
				String userId = (String) session.getAttribute("아이디");
				
				OrderDao orderDao = new OrderDao();
				List<OrderDto> orders = orderDao.getOrdersByUserId(userId);
			%>
			<div>
				<p><strong><%=username %></strong>님, 주문내역을 확인하세요.</p>

				<table class="table">
					<colgroup>
						<col width="10%">
						<col width="10%">
						<col width="*">
						<col width="12%">
						<col width="8%">
						<col width="12%">
						<col width="13%">
					</colgroup>
					<thead>
						<tr>
							<th class="text-center">주문번호</th>
							<th>구매자명</th>
							<th>제목</th>
							<th class="text-right">구매가격</th>
							<th class="text-center">수량</th>
							<th class="text-right">결재금액</th>
							<th class="text-center">주문날짜</th>
						</tr>
					</thead>
					<tbody>
						<%
							if (orders.isEmpty()) {
						%>
						<tr>
							<td class="text-center" colspan="5">주문내역이 존재하지 않습니다.</td>
						</tr>
						<%
							} else {
								for (OrderDto order : orders) {
						%>
						<tr>
							<td class="text-center"><%=order.getNo()%></td>
							<td><%=order.getUserName()%></td>
							<td><%=order.getBookTitle()%></td>
							<td class="text-right"><%=NumberUtil.numberWithComma(order.getPrice())%>
								원</td>
							<td class="text-center"><%=order.getAmount()%></td>
							<td class="text-right"><%=NumberUtil.numberWithComma(order.getPrice() * order.getAmount())%></td>
							<td class="text-center"><%=order.getRegisteredDate()%></td>
						</tr>
						<%
							}
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>