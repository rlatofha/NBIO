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
<title>고객 주문목록 조회</title>
</head>
<body>
<header>
<%@ include file = "header.jsp" %>
</header>  

<div class="container">
<h1 style="color: #32CD32">마이 페이지</h1>
<ul class="nav nav-tabs">

	<li class="tab-link current" date-tab="tab-1"><a href = "editinfo.do">회원정보수정</a></li>

	<li class="tab-link" date-tab="tab-2"><a href = "Questionlist.do">고객문의사항</a></li>

	<li class="tab-link" date-tab="tab-3"><a href = "addressSearch.jsp">배송지주소검색</a></li>

	<li class="tab-link" date-tab="tab-4"><a href = "CPurchase.do">구매목록조회</a></li>

	</ul>	
	
	<br>	
	
		
	
	<div id="tab-1" class="tab-content currunt"><h3>고객 주문목록 조회</h3>
		
		
		<table border="1" style="width: 1100px;">
		<tr>
			<th>제품코드</th><th>가격</th><th>수량</th><th>구매날짜</th>
		</tr>
		<c:forEach items="${CPlist}" var ="dto"> <!--forEach는 반복문  -->
			<tr>
				
				<td>${dto.pucode}</td>
				<td>${dto.purchaseprice}</td>
				<td>${dto.purchasequantity}</td>
				<td>${dto.purchasedate}</td>
			</tr>
		</c:forEach>
		</table>
		</div>	

</div>



		<!-- <h3>고객 주문목록 조회</h3> -->
		
		
		<%-- <table border="1">
		<tr>
			<th>제품코드</th><th>가격</th><th>수량</th><th>구매날짜</th>
		</tr>
		<c:forEach items="${CPlist}" var ="dto"> <!--forEach는 반복문  -->
			<tr>
				
				<td>${dto.pucode}</td>
				<td>${dto.purchaseprice}</td>
				<td>${dto.purchasequantity}</td>
				<td>${dto.purchasedate}</td>
			</tr>
		</c:forEach>
		</table> --%>
			
<footer>
		<%@ include file = "footer.jsp" %>
</footer>
</body>
</html>