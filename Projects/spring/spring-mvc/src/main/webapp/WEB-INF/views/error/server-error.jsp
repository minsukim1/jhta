<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판 :: 에러 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-3 mb-5">
	<div class="row">
		<div class="col-12">
			<div class="jumbtron">
				<h1>서버 에러</h1>
				<p>요청 처리중 에러가 발생하였습니다.</p>
				<p>내용 : <strong class="text-danger">${pageContext.exception.message }</strong></p>
				<p><a href="/home.do" class="btn btn-primary">홈</a>으로 되돌아가기 버튼을 클릭합니다.</p>
			</div>
		</div>
	</div>
</div>
</body>
</html>