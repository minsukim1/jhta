<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDao boardDao = new BoardDao();
	
	Board board = boardDao.getBoardByNo(no);
	board.setTitle(title);
	board.setContent(content);
	
	if(board.getWriter().equals(loginedUserId)){
		boardDao.modifyBoardByNo(board);
		response.sendRedirect("list.jsp");				
	} else {
%>
	<p>권한이 없습니다.</p>
	<p><a href="list.jsp">돌아가기</a></p>
<%
	}
%>			
	