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
	
		<h3>주문 현황 page</h3>
		<!-- 검색 라인  -->
		</div>
		<div id="search">
		<form action="PrSelect.do" method="get"> 
			시작일 :<input type="date" name="startdate" value="2020-01-01">
			종료일 :<input type="date" name="enddate" value= "2021-12-31">&nbsp;&nbsp;&nbsp;
			<select name="query">
			<option value="pName">상품명</option>
			<option value="brand">브랜드</option>
			</select >&nbsp;&nbsp;&nbsp;
			<input type="text" name="content" size="30">
			<input type="submit" value="검색"><br>
		</form>
			</div>
		<!-- 회원 출력 부분  -->
		
	<table class = "table table-hover" border=1 style = "margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom:auto;">
	<thead>
	<tr>
	<th>상품이미지</th><th>상품코드</th><th>상품명</th><th>브랜드</th><th>잔여수량</th><th>가격</th><th>입고일자</th><th>영양소</th><th>연령</th><th>예방질병</th>
	</tr>
		</thead>
			<tbody>
		<c:forEach items="${plist }" var="dto">
		<tr>
			<td><img alt="${dto.pImg  }" src="${dto.pImg  }" height="100" width="100"></td>
			<td>${dto.pCode }</td>
			<td>${dto.pName }</td>
			<td>${dto.brand}</td>
			<td>${dto.pQuan }</td>
			<td>${dto.pPrice }</td>
			<td>${dto.pDate }</td>
			<td>${dto.nut }</td>
			<td>${dto.hT }</td>
			<td>${dto.dis }</td>
		</tr>
		</c:forEach>
			</tbody>
</table>
	<div id= "bottom">
	<a href='admin.jsp'>메인화면</a>
	</div>
	
	</body>
</html>