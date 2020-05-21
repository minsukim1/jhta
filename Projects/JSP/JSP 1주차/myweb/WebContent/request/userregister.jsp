<%@page import="com.sample.dao.UserDao"%>
<%@page import="com.sample.vo.User"%>
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
		
		String userId = request.getParameter("userid");
		String userPassword = request.getParameter("userpassword");
		String userName = request.getParameter("username");
		String userEmail = request.getParameter("useremail");
		
		User user = new User();
		user.setId(userId);
		user.setPassword(userPassword);
		user.setName(userName);
		user.setEmail(userEmail);
		
		UserDao userDao = new UserDao();
		userDao.insertUser(user);
		
	%>
	<h1>유저 등록 완료</h1>
	<p>새로운 유저가 등록되었습니다.</p>
	
	<dl>
		<dt>아이디</dt>
		<dd><%=userId %></dd>
	</dl>
	<dl>
		<dt>비밀번호</dt>
		<dd><%=userPassword %></dd>
	</dl>
	<dl>
		<dt>이름</dt>
		<dd><%=userName %></dd>
	</dl>
	<dl>
		<dt>이메일</dt>
		<dd><%=userEmail %></dd>
	</dl>
</body>
</html>