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
<title>비밀번호 찾기</title>
</head>
<body>
<header>
<%@ include file = "header.jsp" %>
</header> 

<div class="container">
<h1 style="color: #32CD32">비밀번호 찾기</h1>
<ul class="nav nav-tabs">

	<li class="tab-link current" date-tab="tab-1"></li>

	</ul>	
	
	<br>	
	
	<br>	

	<div id="tab-1" class="tab-content currunt" style="text-align: center;">
	
	<form action="findpwd.do">
			<div>아이디</div>
			<br>
			<div><input type="text" name="id"></div>	
			<br>	
			<div class="join"></div>
			<br>
			<div class="join">비밀번호 찾기 질문</div>
			<br>
			<div class="join">
				<select name="pwInfo">		
					<option value="pwInfo1">자신이 나온 초등학교는?</option>
					<option value="pwInfo2">자신이 살고 있는 동네는?</option>			
				</select>
				<br>
			</div>
			<br>
			<br>
			<div class="join">비밀번호 찾기 답</div>
			<br>
			<div class="join">
				<input type="text" name="pwAns" size="40">
			</div>
			<br>
			<br>
			<input type="submit" value="찾기">
	 	</form>
	
	</div>	

</div>




 
	 	<!-- <form action="findpwd.do">
			<div>아이	디</div>
			<div><input type="text" name="id"></div>		
			<div class="join"></div>
			<div class="join">비밀번호 찾기 질문</div>
			<div class="join">
				<select name="pwInfo">
					<option value="pwInfo1">자신이 나온 초등학교는?</option>
					<option value="pwInfo2">자신이 살고 있는 동네는?</option>
				</select>
			</div>
			<div class="join">비밀번호 찾기 답</div>
			<div class="join">
				<input type="text" name="pwAns" size="40">
			</div>
			<input type="submit" value="찾기">
	 	</form> -->
<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
</body>
</html>