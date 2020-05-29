<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.dao.UserDao"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao boardDao = new BoardDao();
	
	Board board = boardDao.getBoardByNo(no);
	if(board.getWriter().equals(loginedUserId)){
		boardDao.deleteBoardByNo(no);
		response.sendRedirect("list.jsp");				
	} else {
%>
	<p>권한이 없습니다.</p>
	<p><a href="list.jsp">돌아가기</a></p>
<%
	}
%>			
	
	
	