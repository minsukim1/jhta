<%@page import="com.sample.vo.Employee"%>
<%@page import="com.sample.dao.EmployeeDao"%>
<%@page import="com.sample.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보</title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
 <div class="wrapper">
 	<div class="header">
 		<h1>사원 정보</h1>
 	</div>
 	<div class="body">
 		<div>
 		<%
 			int employeeId = NumberUtil.stringToInt(request.getParameter("empid"));
 			int pageNo = NumberUtil.stringToInt(request.getParameter("page"),1);
 			EmployeeDao employeeDao = new EmployeeDao();
 			Employee employee = employeeDao.getEmployeeById(employeeId);
 		%>
 			<p>사원정보를 확인하세요</p>
 			<table class="table bordered">
 				<tbody>
 					<tr>
 						<td>아이디</td>
 						<td><%=employee.getId() %></td>
 						<td>이름</td>
 						<td><%=employee.getFirstName() %> <%=employee.getLastName() %></td>
 					</tr>
 					<tr>
 						<td>이메일</td>
 						<td><%=employee.getEmail() %></td>
 						<td>전화번호</td>
 						<td><%=employee.getPhoneNumber() %></td>
 					</tr>
 					<tr>
 						<td>입사일</td>
 						<td><%=employee.getHireDate() %></td>
 						<td>직종</td>
 						<td><%=employee.getJobId() %></td>
 					</tr>
 					<tr>
 						<td>급여</td>
 						<td><%=NumberUtil.numberWithComma((int)employee.getSalary()) %></td>
 						<td>커미션</td>
 						<td><%=employee.getCommission_pct() %></td>
 					</tr>
 					<tr>
 						<td>매니저</td>
 						<td><%=employee.getManagerFirstName() %> <%=employee.getManagerLastName() %></td>
 						<td>소속부서</td>
 						<td><%=employee.getDepartmentName() %></td>
 					</tr>
 				</tbody>
 			</table>
 		</div>
 		<div class="text-right">
 			<a href="modifyform.jsp">수정</a>
 			<a href="list.jsp?page=<%=pageNo%>">목록</a>
 		</div>
 	</div>
 
 </div>
</body>
</html>