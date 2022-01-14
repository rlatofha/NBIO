<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"

href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>아이디 찾기</title>
</head>
<body>

<header>
<%@ include file = "header.jsp" %>
</header>  

<div class="container">
<h1 style="color: #32CD32">임시 로그인 페이지</h1>
<ul class="nav nav-tabs">

	<li class="tab-link current" date-tab="tab-1"></li>

	</ul>	
	
	<br>	
	
	<br>	
	
	
	<div id="tab-1" class="tab-content currunt">
	
	<form action="logincheck.do" method="get">
		아이디<input type="text" name="id"><br>
		
		<input type="submit" value="전송">&nbsp;&nbsp;&nbsp;&nbsp;
		
	</form></div>	

</div>

	<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
</body>
</html>