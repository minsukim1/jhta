<%@page import="com.bookstore.util.NumberUtil"%>
<%@page import="com.bookstore.vo.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
</head>
<body>
	<div class="wrapper">
		<div class="navi">
			<%
				String position = "book";
			%>
			<%@ include file="../common/navibar.jsp" %>
		</div>
		<div class="header">
			<h1>책</h1>
		</div>
		<div class="body">
			<div>
			<%
				BookDao bookDao = new BookDao();
				List<Book> books = bookDao.getAllBooks();
			%>
				<h3>도서 리스트</h3>
				<table class="table">
					<thead>
						<tr>
							<th class="text-center">번호</th>
							<th>제목</th>
							<th>저자</th>
							<th class="text-right">가격</th>
							<th class="text-center">평점</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<%
						for (Book book : books) {
					%>
						<tr>
							<td class="text-center"><%=book.getNo() %></td>
							<td><a href="detail.jsp?bookno=<%=book.getNo() %>" ><%=book.getTitle() %></a></td>
							<td><%=book.getWriter() %></td>
							<td class="text-right"><%=NumberUtil.numberWithComma(book.getPrice()) %> 원</td>
							<td class="text-center"><%=book.getPoint() %></td>
							<td><a href="../order/form.jsp?bookno=<%=book.getNo() %>&amount=1">바로구매</a></td>
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
				<hr/>
				<div class="text-right">
					<a href="form.jsp"><strong>[책 등록]</strong></a>
				</div>
			</div>
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>