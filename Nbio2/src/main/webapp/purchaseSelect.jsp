<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name = "viewport" content = "width=device-width", initial-scale="1"> 
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<style>
	#head{text-align: center; }
	#search{text-align: center; }
	#bottom{text-align: center; }
	</style>
	</head>
	<body>

		<div id="head">
		<h3>제품 현황 page</h3>
		</div>
		<!-- 검색 라인  -->
		<div id="search">
		<form action="PuSelect.do" method="get"> 
			시작일 :<input type="date" name="startdate" value="2020-01-01">
			종료일 :<input type="date" name="enddate" value= "2021-12-31">&nbsp;&nbsp;&nbsp;
			<select name="query">
			<option value="pucode">상품코드</option>
			<option value="puid">회원ID</option>
			</select >&nbsp;&nbsp;&nbsp;
			<input type="text" name="content" size="30">
			<input type="submit" value="검색"><br>
		</form>
		</div>
		<!-- 회원 출력 부분  -->
		
	<table class = "table table-hover" border=1 style = "margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom:auto;">
		<thead>
	<tr>
	<th>회원ID</th><th>상품코드</th><th>상품가격</th><th>주문량</th><th>주문날짜</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${pulist }" var="dto" varStatus="i">
		<tr>
			<td>${dto.puid }</td>
			<td>${dto.pucode }</td>
			<td>${dto.purchaseprice }</td>
			<td>${dto.purchasequantity }</td>
			<td>${dto.purchasedate }</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<div id= "bottom">
	<a href='admin.jsp'>메인화면</a>
		<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
	</div>
	</body>
</html>