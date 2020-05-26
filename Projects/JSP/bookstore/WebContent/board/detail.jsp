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
			String position = "board";
		%>
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>게시글 정보</h1>
	</div>
	<div class="body">
		<div>
			<p>게시글의 내용을 확인하세요.</p>
			<table class="table bordered">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3">자유게시판에 욕설을 올리지 마세요</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>홍길동</td>
						<th>등록일</th>
						<td>2020-05-25</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>100</td>
						<th>댓글개수</th>
						<td>5개</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							자유게시판에 욕설을 올리지 마세요
							자유게시판에 욕설을 올리지 마세요
							자유게시판에 욕설을 올리지 마세요
							자유게시판에 욕설을 올리지 마세요
						</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<div class="text-right">
				<a href="modifyform.jsp?boardno=12"><strong>[수정]</strong></a>
				<a href="delete.jsp?boardno=12"><strong>[삭제]</strong></a>
				<a href="list.jsp"><strong>[목록으로 가기]</strong></a>
			</div>
		</div>
		<div>
			<div>
				<p>댓글을 확인하세요</p>
				<table class="table">
					<colgroup>
						<col width="10%">
						<col width="40%">
						<col width="10%">
						<col width="40%">
					</colgroup>
					<tr>
						<th>작성자</th>
						<td>홍길동</td>
						<th>등록일</th>
						<td>2020-05-25</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							댓글입니다.댓글입니다.댓글입니다. 댓글입니다.
						</td>
					</tr>
				</table>
			</div>
			<div class="well">
				<form method="post" action="registerreply.jsp">
					<div class="form-group">
						<label>작성자</label>
						<div><input type="text" name="writer" /></div>
					</div>
					<div class="form-group">
						<label>내용</label>
						<div><textarea rows="4" name="content"></textarea> </div>
					</div>
					<div class="text-right">
						<button type="submit">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>