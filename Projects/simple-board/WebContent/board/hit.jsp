<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao boardDao = new BoardDao();
	boardDao.updateHitByNo(no);
	response.sendRedirect("detail.jsp?no=" + no);
%>