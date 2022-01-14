<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"

href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>당신이 원하는 상품</title>
</head>
<body>
	<header>
		<%@ include file = "header.jsp" %>
	</header> 
	<div class="container">

	<h1 style="color: #32CD32">추천 상품</h1>
	
	<ul class="nav nav-tabs">

	<li class="tab-link current" date-tab="tab-1"></li>

	</ul>	
	
	<br>	
	
	<br>	
	
	<br>	
	
	<div id="tab-1" class="tab-content currunt">
	
	<table border="1" style="width: 1100px">
	<tr>
	<th>상품사진</th><th>상품명</th><th>브랜드</th><th>가격</th><th>비타민 종류</th><th>연령</th><th>예방질병</th>
	</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td><img alt = "${dto.pImg }" src = "${dto.pImg }" height=100  width=100></td>
			<td>${dto.pName }</td>
			<td>${dto.brand}</td>
			<td>${dto.pPrice }</td>
			<td>${dto.nut }</td>
			<td>${dto.hT }</td>
			<td>${dto.dis }</td>
			

		</tr>
		</c:forEach> 
	</table>
	<br><br>
	해당 검색결과 위의 추천리스트가 결정되었습니다<br> 
	해당 추천 사유는 제조사의 근거 바탕으로 결정 되었으며 관련 근거는 <a href=https://www.vitabiotics.com/pages/contact-us>여기</a>를 클릭해주시기 바랍니다.<br>
	제품에 대한 문의 사항은 02-3333-4444로 연락 바라며 기타 문의 사항은 고객문의 게시판에 문의 바랍니다.<br> 
    Nbio는 고객님의 건강을 위해 항상 노력하는 회사가 되겠으며 많은 관심 감사합니다. 
	
	</div>	

</div>
	
	<footer>
		<%@ include file = "footer.jsp" %>
	</footer>

</body>
</html>