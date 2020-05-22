<%@page import="com.bookstore.util.NumberUtil"%>
<%@page import="com.bookstore.dao.BookDao"%>
<%@page import="com.bookstore.dto.BookDetailDto"%>
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
	<div class="wrapper">
		<div class="navi">
			<%
				String position = "order";
			%>
			<%@ include file="../common/navibar.jsp"%>
		</div>
		<div class="header">
			<h1>주문하기</h1>
		</div>
		<div class="body">
			<%
				int bookNo = Integer.parseInt(request.getParameter("bookno"));
				int amount = Integer.parseInt(request.getParameter("amount"));
				
				// 책정보 조회하기
				BookDao bookDao = new BookDao();
				BookDetailDto bookDetailDto = bookDao.getBookByNo(bookNo);
			%>
			<p>주문정보를 확인하세요.</p>
			<div>
				<table class="table bordered">
					<tbody>
						<tr>
							<th>제목</th>
							<td colspan="3"><%=bookDetailDto.getTitle() %></td>
						</tr>
						<tr>
							<th>저자</th>
							<th><%=bookDetailDto.getWriter() %></th>
							<th>출판사</th>
							<th><%=bookDetailDto.getPublisher() %></th>
						</tr>
						<tr>
							<th>가격</th>
							<th><%=NumberUtil.numberWithComma(bookDetailDto.getPrice()) %> 원</th>
							<th>할인가격</th>
							<th><%=NumberUtil.numberWithComma(bookDetailDto.getDiscountPrice()) %> 원</th>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="well">
				<form action="order.jsp" method="post">
				<input type="hidden" name="price" value="<%=bookDetailDto.getDiscountPrice() %>" />
				<input type="hidden" name="amount" value="<%=amount %>" />
				<input type="hidden" name="bookno" value="<%=bookNo %>" />
					<div class="form-group">
						<label>구매자</label>
						<div><input type="text" name="userid"/></div>
					</div>
					<div class="form-group">
						<label>구매가격</label>
						<div><input type="text" name="price" value="<%=NumberUtil.numberWithComma(bookDetailDto.getDiscountPrice()) %> 원" disabled/></div>
					</div>
					<div class="form-group">
						<label>구매수량</label>
						<div><input type="number" name="amount" value="<%=amount%>" disabled="disabled"/></div>
					</div>
					<div class="text-right">
						<button type="submit">주문하기</button>
					</div>
				
				</form>
			</div>
		</div>
		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>