<%@page import="com.bookstore.util.StringUtil"%>
<%@page import="com.bookstore.dto.ReviewDto"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dao.ReviewDao"%>
<%@page import="com.bookstore.util.NumberUtil"%>
<%@page import="com.bookstore.dto.BookDetailDto"%>
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
			<h1>책 정보</h1>
		</div>
		<div class="body">
			<div>
			<%
				int bookNo = Integer.parseInt(request.getParameter("bookno"));
			
				// 책 정보 조회
				BookDao bookDao = new BookDao();
				BookDetailDto bookDetailDto = bookDao.getBookByNo(bookNo);
			%>			
				<h3>책의 상세정보</h3>
				<table class="table bordered">
					<colgroup>
						<col width="10%">
						<col width="40%">
						<col width="10%">
						<col width="40%">
					</colgroup>
					<tr>
						<th>제목</th>
						<td colspan="3"><%=bookDetailDto.getTitle() %></td>
					</tr>
					<tr>
						<th>저자</th>
						<td><%=bookDetailDto.getWriter() %></td>
						<th>출판사</th>
						<td><%=bookDetailDto.getPublisher() %></td>
					</tr>
					<tr>
						<th>평점</th>
						<td><%=bookDetailDto.getPoint() %></td>
						<th>리뷰개수</th>
						<td><%=bookDetailDto.getReviewCnt() %> 개</td>
					</tr>
					<tr>
						<th>가격</th>
						<td><%=NumberUtil.numberWithComma(bookDetailDto.getPrice()) %> 원</td>
						<th>할인가격</th>
						<td><%=NumberUtil.numberWithComma(bookDetailDto.getDiscountPrice()) %> 원</td>
					</tr>
					<tr>
						<th>추천수</th>
						<td><%=NumberUtil.numberWithComma(bookDetailDto.getLikes()) %> 개</td>
						<th>재고</th>
						<td><%=NumberUtil.numberWithComma(bookDetailDto.getStock()) %> 권</td>
					</tr>
				</table>
				<hr>
				<div class="text-right">
					<a href="list.jsp"><strong>목록으로 가기</strong></a>
				</div>
			</div>
			
			<div>
				<%
					ReviewDao reviewDao = new ReviewDao();
					List<ReviewDto> reviews = reviewDao.getReviewsByBookNo(bookNo);
				%>
				<h3>이 책의 리뷰</h3>
				<table class="table">
					<colgroup>
						<col width="10%">
						<col width="23%">
						<col width="10%">
						<col width="23%">
						<col width="10%">
						<col width="23%">
					</colgroup>
					<tbody>
					<%
						if (reviews.isEmpty()) {
					%>
						<tr>
							<td>등록된 리뷰가 존재하지 않습니다.</td>
						</tr>
					<%
						} else {
							for (ReviewDto reviewDto : reviews) {
					%>
						<tr>
							<th>작성자</th>
							<td><%=reviewDto.getUserName() %></td>
							<th>평점</th>
							<td><%=reviewDto.getPoint() %></td>
							<th>작성일</th>
							<td><%=reviewDto.getRegisteredDate() %></td>
						</tr>
						<tr>
							<td colspan="6"><%=StringUtil.strWithBr(reviewDto.getContent()) %></td>
						</tr>
					<%
							}
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>




