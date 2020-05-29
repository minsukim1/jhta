<%@page import="com.simple.dao.UserDao"%>
<%@page import="com.simple.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String userName = request.getParameter("name");
	String userEmail = request.getParameter("email");
	String userId = request.getParameter("id");
	String userPassword = request.getParameter("pwd");
	
	UserDao userDao = new UserDao();
	User user = userDao.getUserById(userId);
	if(user == null){
		user = new User();	
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		user.setUserId(userId);
		user.setUserPassword(userPassword);
		userDao.insertUser(user);
		response.sendRedirect("/simple-board/home.jsp");
	} else {
		response.sendRedirect("form.jsp?error=equal");
		
	}
	
%>