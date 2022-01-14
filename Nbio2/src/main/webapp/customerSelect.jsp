<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int cnt = 0;
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name = "viewport" content = "width=device-width", initial-scale="1"> 
	<title>고객 현황 page</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<style>
	#head{text-align: center; }
	#search{text-align: center; }
	#bottom{text-align: center; }
	</style>
	</head>
	<body>

		<div id="head">
		<h3>고객 현황 page</h3>
		</div>
		<!-- 검색 라인  -->
		<div id="search">
		<form action="CSelect.do" method="get"> 
			시작일 :<input type="date" name="startdate" value="2020-01-01">
			종료일 :<input type="date" name="enddate" value= "2021-12-31">&nbsp;&nbsp;&nbsp;
			<select name="query">
			<option value="name">이름</option>
			<option value="id">아이디</option>
			</select >&nbsp;&nbsp;&nbsp;
			<input type="text" name="content" size="30">
			<input type="submit" value="검색"><br>
		</form>
		</div>
		<!-- 회원 출력 부분  -->
		
	<table class = "table table-hover" border=1 style = "margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom:auto;">
	<thead>
	<tr>
	<th>회원ID</th><th>비밀번호</th><th>이름</th><th>전화번호</th><th>이메일</th><th>주소</th><th>생년월일</th><th>성별</th><th>회원가입일</th>
	</tr>
	</thead>
		<tbody>
			<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.id }</td>
				<td>${dto.pwd }</td>
				<td>${dto.name}</td>
				<td>${dto.tel }</td>
				<td>${dto.mail }</td>
				<td>${dto.address }</td>
				<td>${dto.birth }</td>
				<td>${dto.gender }</td>
				<td>${dto.uDate }</td>
				
				<% cnt++; %>
			</tr>
			</c:forEach>
		</tbody>
</table>
	<div id= "bottom">
----------------------------------------------------------------------------------------<br>
총 인원은 <%=cnt %>명 입니다. 
	<a href='admin.jsp'>메인화면</a>
	</div>
	<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
	</body>
</html>