<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.dao.ReplyDao"%>
<%@page import="com.simple.vo.Reply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	request.setCharacterEncoding("utf-8");

	String content = request.getParameter("content");
	int boardNo = Integer.parseInt(request.getParameter("boardno"));

	Reply reply = new Reply();
	reply.setWriter(loginedUserId);
	reply.setBoardNo(boardNo);
	reply.setContent(content);
	ReplyDao replyDao = new ReplyDao();
	replyDao.insertReply(reply);
	
	response.sendRedirect("../board/detail.jsp?no="+boardNo);
%>