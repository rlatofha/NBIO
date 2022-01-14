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
<title>상품 추천 페이지</title>
</head>
<body>
	<header>
		<%@ include file = "header.jsp" %>
	</header>  

	<div class="container">
	
	<h1 style="color: #32CD32">비타민 추천 리스트</h1>
	<ul class="nav nav-tabs">

	<li class="tab-link current" date-tab="tab-1"></li>

	</ul>	
	
	<br>	
	
	<br>	
	
	<br>	
	
	<div id="tab-1" class="tab-content currunt">
	
	<form action="recommand.do" method="post">
		연령 : <input type="radio" name="hT" value="여성">여성
		<input type="radio" name="gender" value="남성">남성
		<input type="radio" name="gender" value="노인">노인
		<input type="radio" name="gender" value="유아">유아<br><br><br><br>
		
		비타민 종류 : <input type="checkbox" name="nut" value="멀티비타민">멀티비타민
		<input type="checkbox" name="nut" value="오메가3">오메가3
		<input type="checkbox" name="nut" value="에너지">에너지
		<input type="checkbox" name="nut" value="비타민D">비타민D
		<input type="checkbox" name="nut" value="에너지">에너지<br><br><br><br>
		
		희망하는 건강 부위 종류 : <input type="checkbox" name="dis" value="멀티비타민">멀티비타민
		<input type="checkbox" name="dis" value="임신전">임신전
		<input type="checkbox" name="dis" value="임신중">임신중
		<input type="checkbox" name="dis" value="출산후">출산후
		<input type="checkbox" name="dis" value="관절">관절
		<input type="checkbox" name="dis" value="심혈관">심혈관
		<input type="checkbox" name="dis" value="장,소화">장,소화
		<input type="checkbox" name="dis" value="갱년기">갱년기
		<input type="checkbox" name="dis" value="뼈 건강">뼈 건강
		<input type="checkbox" name="dis" value="눈 건강">눈 건강<br><br><br>
		
		<input type="submit" value="추천 검색">
	</form>
	</div>	

	
	</div>
	
		<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
	
</body>
</html>