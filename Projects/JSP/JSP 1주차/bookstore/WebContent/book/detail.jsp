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
			<%@ include file="../common/navibar.jsp"%>
		</div>
		<div class="header">
			<h1>책 정보</h1>
		</div>
		<div class="body">
			<%
				int bookNo = Integer.parseInt(request.getParameter("bookno"));
			%>
			<div>
				<h3>책의 상세정보</h3>
				<table class="table">
					<tr>
						<th>제목</th>
						<td colspan="3"></td>
					</tr>
					<tr>
						<th>저자</th>
						<td>1</td>
						<th>츨판사</th>
						<td>1</td>
					</tr>
					<tr>
						<th>평점</th>
						<td>1</td>
						<th>리뷰개수</th>
						<td>1</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>1</td>
						<th>할인가격</th>
						<td>1</td>
					</tr>
					<tr>
						<th>추천수</th>
						<td>1</td>
						<th>재고</th>
						<td>1</td>
					</tr>
				</table>
			</div>
			<div>
				<h3>이 책의 리뷰</h3>
				<table class="table">
					<tbody>
						<tr>
							<th>작성자</th>
							<td>1</td>
							<th>평점</th>
							<td>1</td>
							<th>작성일</th>
							<td>1</td>
						</tr>
						<tr>
							<td colspan="6">내용은 내용이다.</td>
						</tr>
					</tbody>		
				</table>
			</div>
		</div>
		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>