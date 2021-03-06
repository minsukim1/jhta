<%@page import="com.sample.hr.vo.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.hr.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HR</title>
<link rel="stylesheet" href="../resources/css/style.css" type="text/css" />
</head>
<body>
	<div class="wrapper">
		<div class="navi">		
			<div id="navibar">
				<ul>
					<li><a href="/ajax/home.jsp">홈</a></li>
					<li><a href="/ajax/hr/list1.jsp">직원조회</a></li>
					<li class="active"><a href="/ajax/hr/list2.jsp">직원조회(Ajax)</a></li>
				</ul>
			</div>
		</div>
		<div class="header">
			<h1>부서별 직원조회</h1>
		</div>
		<div class="body">
		<%
			EmployeeDao dao = new EmployeeDao();
			List<Department> departments = dao.getAllDepartments();
		%>
			<p>부서별 직원을 조회해보세요</p>
			<div>
				<form action="">
					<label>부서명</label>
					<select name="deptid" style="height: 30px;">
						<option value="" selected disabled>-- 부서명을 선택하세요 --</option>
					<%
						for (Department dept : departments) {
					%>
						<option value="<%=dept.getId() %>"><%=dept.getName() %></option>
					<%
						}
					%>
					</select>
					<button type="button" onclick="getEmployees()">조회</button>
				</form>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>직종</th>
						<th>급여</th>
						<th>입사일</th>
					</tr>
				</thead>
				<tbody id="employee-body">
				</tbody>
			</table>
		</div>
		<div class="footer">
			<p>짱좋은 주식회사</p>
		</div>
	</div>
	<script type="text/javascript">
		function getEmployees() {
			var departmentId = document.querySelector("select[name=deptid]").value;
			
			// XHR객체 생성
			var xhr = new XMLHttpRequest();
			
			// XHR 객체에서 응답데이터 가져오기
			// * XHR객체의 readyState는 요청처리의 각 과정에 따라서 0 ~ 4로 값이 변해간다.
			// * XHR객체는 readyState 값이 변할 때마다 onreadystatechange 이벤트를 발생시킨다.
			// * XHR객체의 onreadystatechange 이벤트에, 이벤트 발생시 실행될 함수를 등록한다.
			// * XHR객체의 readyState값이 4면 응답을 받은 것이다.
			// * XHR객체의 status값이 200이면 성공적인 응답을 받은 것이다.
			// * 서버가 보낸 응답데이터는 XHR객체의 responseText에 보관되어 있다.
			// * 서버가 보낸 응답데이터가 JSON 형식의 데이터라면 JSON.parse() 함수를 사용해서
			//   javascript의 배열이나 객체로 변환할 수 있다.
			// * 배열이나 객체로 변환되었다면 자바스크립트 문법을 사용해서 값을 조회하고,
			//   조회된 값을 이용해서 HTML 컨텐츠를 만든 다음, 특정 태그에 부착시켜서 화면에
			//   표시되게 한다.
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200){
					var text = xhr.responseText;
					var employees = JSON.parse(text);
					
					var rows = "";
					for (var i=0; i<employees.length; i++){
						var emp = employees[i];
						
						rows += "<tr>";
						rows += "<td>"+emp.id+"</td>";
						rows += "<td>"+emp.firstName+"</td>";
						rows += "<td>"+emp.phoneNumber+"</td>";
						rows += "<td>"+emp.jobId+"</td>";
						rows += "<td>"+emp.salary+"</td>";
						rows += "<td>"+emp.hireDate+"</td>";
						rows += "</tr>";
					}
					document.getElementById("employee-body").innerHTML = rows;
				}
			}
			// XHR 초기화
			xhr.open("GET", "data.jsp?deptid=" + departmentId);
			// 서버로 요청보내기
			xhr.send();
		}
	</script>
</body>
</html>