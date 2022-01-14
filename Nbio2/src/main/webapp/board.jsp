<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>고객 문의 사항</title>

<link rel="stylesheet" href="css/bootstrap.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="js/jquery-3.1.1.js"></script>
<script src="js/bootstrap.js"></script>
<style>
#head{text-align: center; }
#search{text-align: center; }
#bottom{text-align: center; }
</style>
</head>
<body>

		<div id="head">
		<h3>고객 문의 사항</h3>
		</div>
 <!-- 검색 구간  --> 
		<div id="search">
		<form action="CBselect.do" method="post">
			검색선택: <select name="query">
						<option value="ubid">회원ID</option>
						<option value="cTitle">제목</option>
						<option value="inquiryType">질문유형</option>
					</select>&nbsp;&nbsp;&nbsp;
			<input type="text" name="content" size="30">
			<input type="submit" value="검색"><br>
		</form>
		</div>

<table class = "table table-hover" border=1 style = "margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom:auto;">
	<thead>
	<tr>
		<th>회원id</th>
		<th>질문유형</th>
		<th>제목</th>
		<th>등록일</th>
	</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${CBlist }" var="dto">
		<tr>
			<td><a href ="board_view.do?ubid=${dto.ubid}">${dto.ubid }</a></td>
			<td>${dto.inquiryType }</td>
			<td><a href ="reviewboard_view.do?ubid=${dto.ubid}">${dto.cTitle}</a></td>
			<td>${dto.cbdDate }</td>
		</tr>
		</c:forEach> 
		</tbody>
</table>


<hr/>
	<div id= "bottom">
		<form action="boardwrite.jsp" method="post">
			<input type="submit" value="글작성"><br>
		</form> 
	</div>	
		

</body>
</html>