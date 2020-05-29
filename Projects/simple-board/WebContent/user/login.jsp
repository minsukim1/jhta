<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String userId = request.getParameter("userid");
	String userPassword = request.getParameter("userpassword");
	System.out.println(userId);
	
	UserDao userDao = new UserDao();
	User user = userDao.getUserById(userId);
	
	if(user == null){
		response.sendRedirect("loginform.jsp?error=fail");
		return;
	}
	
	if(!user.getUserPassword().equals(userPassword)){
		response.sendRedirect("loginform.jsp?error=fail");
		return;
	}
	
	
	session.setAttribute("LOGINED_USER_ID", user.getUserId());
	session.setAttribute("LOGINED_USER_NAME", user.getUserName());
	session.setAttribute("LOGINED_YN", "Yes");
	
	response.sendRedirect("/simple-board/home.jsp");
%>