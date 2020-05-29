<%@page import="com.simple.vo.Reply"%>
<%@page import="java.util.List"%>
<%@page import="com.simple.dao.ReplyDao"%>
<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
<style>
	.bold-bordered {
		border-bottom: 1px double black;
	}
</style>
</head>
<body>
<%
	int no = Integer.parseInt(request.getParameter("no"));
%>
<div class="wrapper">
	<div class="navi">
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>게시글 상세정보</h1>
	</div>
	<div class="body">
		<p>게시글의 내용을 확인하고, 댓글도 달아보세요.</p>
		<div>
			<table class="table bordered">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
				<%
					BoardDao boardDao = new BoardDao();
					Board board = boardDao.getBoardByNo(no);
				%>
					<tr>
						<th>제목</th>
						<td colspan="3"><%=board.getTitle() %></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><a href="writer.jsp?userid=<%=board.getWriter()%>"><%=board.getWriter() %></a></td>
						<th>등록일</th>
						<td><%=board.getBoardCreateDate() %></td>
					</tr>
					<tr>
						<th>조회수</th>
						<td><%=board.getHit() %></td>
						<th>댓글갯수</th>
						<td><%=board.getReplyCnt() %></td>
					</tr>
					<tr>
						<th style="vertical-align: top;">내용</th>
						<td colspan="3" style="vertical-align:top; height:150px; min-height: 150px;"><%=board.getContent() %></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="text-right">
			[<a href="modifyform.jsp?no=<%=board.getNo()%>">수정하기</a>]
			[<a href="delete.jsp?no=<%=board.getNo()%>">삭제하기</a>]
			[<a href="list.jsp">목록가기</a>]
		</div>
		
		<div>
			<p>댓글을 확인하세요.</p>
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
				<%
					ReplyDao replyDao = new ReplyDao();
					List<Reply> replys = replyDao.getAllReplyByBoardNo(board.getNo());
					
					for(Reply reply : replys){
						
				%>
					<tr>
						<th>작성자</th>
						<td><%=reply.getWriter() %></td>
						<th>등록일</th>
						<td><%=reply.getReplyCreateDate() %></td>
					</tr>
					<tr class="bold-bordered">
						<th>내용</th>
						<td colspan="3"><%=reply.getContent() %></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<br/>
			<div class="well">
				<form method="post" action="../reply/register.jsp">
					<input type="hidden" name="boardno" value="<%=board.getNo()%>"/>
					<div class="form-group">
						<textarea rows="3" name="content"></textarea>
					</div>
					<div class="text-right">
						<button type="submit">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</div>
</body>
</html>