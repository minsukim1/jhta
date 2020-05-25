<%@page import="com.bookstore.dto.BookDetailDto"%>
<%@page import="com.bookstore.dao.BookDao"%>
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
				String position = "book";
				BookDao bookDao = new BookDao();
				int bookNo = Integer.parseInt(request.getParameter("bookno"));
				BookDetailDto bookDetailDto = bookDao.getBookByNo(bookNo);
			%>
			<%@ include file="../common/navibar.jsp"%>
		</div>
		<div class="header">
			<h1>리뷰 작성하기</h1>
		</div>
		<div class="body">
			<p>아래의 책에 대한 리뷰를 작성해 주세요.</p>
			<div class="well">
				<form action="register.jsp" method="post">
					<input type="hidden" name="userid" value="유저아이디" /> <input
						type="hidden" name="bookno" value="책번호" />
					<div class="form-group">
						<label>제목</label>
						<div>
							<input type="text" name="title" value="<%=bookDetailDto.getTitle() %>" disabled="disabled" />
						</div>
					</div>
					<div class="form-group">
						<label>평점</label>
						<div>
							<label><input type="radio" name="point" value="0"/>0점</label>
							<label><input type="radio" name="point" value="1"/>1점</label>
							<label><input type="radio" name="point" value="2"/>2점</label>
							<label><input type="radio" name="point" value="3"/>3점</label>
							<label><input type="radio" name="point" value="4"/>4점</label>
							<label><input type="radio" name="point" value="5" checked="checked"/>5점</label>
						</div>
					</div>
					<div class="form-group">
						<label>내용</label>
						<div>
							<textarea name="content" rows="6"></textarea>
						</div>
					</div>
					<div class="text-right">
						<button type="submit">리뷰등록</button>
					</div>
				</form>
			</div>
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>