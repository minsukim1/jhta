<%@page import="com.sample.dao.BookDao"%>
<%@page import="com.sample.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("utf-8");
	
		String bookTitle = request.getParameter("booktitle");
		String writer = request.getParameter("writer");
		String genre = request.getParameter("genre");
		String publisher = request.getParameter("publisher");
		int bookPrice = Integer.parseInt(request.getParameter("bookprice"));
		int discountPrice = Integer.parseInt(request.getParameter("discountprice"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		
		Book book = new Book();
		book.setTitle(bookTitle);
		book.setWriter(writer);
		book.setPublisher(publisher);
		book.setGenre(genre);
		book.setPrice(bookPrice);
		book.setDiscountPrice(discountPrice);
		book.setStock(stock);
		
		BookDao bookDao = new BookDao();
		bookDao.insertBook(book);
	%>
	<h1>책 등록 완료</h1>
	
	<p>새로운 책이 등록되었습니다.</p>
	
	<h3>등록한 책 정보</h3>
	
	<dl>
		<dt>책제목</dt>
		<dd><%=bookTitle %></dd>
	</dl>
	<dl>
		<dt>저자</dt>
		<dd><%=writer %></dd>
	</dl>
	<dl>
		<dt>장르</dt>
		<dd><%=genre %></dd>
	</dl>
	<dl>
		<dt>출판사</dt>
		<dd><%=publisher %></dd>
	</dl>
	<dl>
		<dt>가격</dt>
		<dd><%=bookPrice %></dd>
	</dl>
	<dl>
		<dt>할인가격</dt>
		<dd><%=discountPrice %></dd>
	</dl>
	<dl>
		<dt>재고</dt>
		<dd><%=stock %></dd>
	</dl>
</body>
</html>