<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 쓰기</h1>
	
	<form action="add.jsp" method="post">
		<div>
			<label>제목</label>
			<div><input type="text" name="title" /></div>
		</div>
		<div>
			<label>내용</label>
			<div><textarea name="contents"cols="50" rows="6"></textarea></div>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>