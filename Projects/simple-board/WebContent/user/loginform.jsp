<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple - Board</title>
<link rel="stylesheet" href="../resources/css/style.css" type="text/css" />
</head>
<body>
	<div class="wrapper">
		<div class="navi">
			<%@ include file="../common/navibar.jsp"%>
		</div>
		<div class="header">
			<h1>로그인</h1>
		</div>
		<div class="body">
			
			<%
				String error = request.getParameter("error");
			%>
			<%
				if ("fail".equals(error)) {
			%>
				<p style="color:red; font-style:italic;">아이디 혹은 비밀번호가 올바르지 않습니다.</p>
			<%
				}
			%>
			<%
				if ("deny".equals(error)) {
			%>
				<p style="color:red; font-style:italic;">로그인이 필요한 서비스입니다.</p>
			<%
				}
			%>
			<p>로그인 정보를 입력하세요.</p>
			<div class="well">
				<form action="login.jsp" method="post">
					<div class="form-group">
						<label>아이디</label>
						<div>
							<input type="text" name="userid" />
						</div>
					</div>
					<div class="form-group">
						<label>비밀번호</label>
						<div>
							<input type="password" name="userpassword"/>
						</div>
					</div>
					<div class="text-right">
						<button type="submit">로그인</button>
					</div>
				</form>
			</div>
		</div>
		<%@ include file="../common/footer.jsp"%>
	</div>
</body>
</html>