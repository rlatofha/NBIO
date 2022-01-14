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
<title>고객 문의 사항</title>
</head>
<body>
<header>
<%@ include file = "header.jsp" %>
</header>

<div class="container">
<h1 style="color: #32CD32">고객문의사항</h1>
<ul class="nav nav-tabs">

	<li class="tab-link current" date-tab="tab-1"><a href = "editinfo.do">회원정보수정</a></li>

	<li class="tab-link" date-tab="tab-2"><a href = "Questionlist.do">고객문의사항</a></li>

	<li class="tab-link" date-tab="tab-3"><a href = "addressSearch.jsp">배송지주소검색</a></li>

	<li class="tab-link" date-tab="tab-4"><a href = "CPurchase.do">구매목록조회</a></li>

	</ul>	
	
	<br>		
	
	<div id="tab-1" class="tab-content currunt">
	
	<div id="head">
		<h3>고객 문의 사항 리스트</h3>
		<br>
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
		<br>

<table class = "table table-hover" border=1 style = "margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom:auto; width: 1100px;">
	<thead>
	<tr>
		<th>회원id</th>
		<th>질문유형</th>
		<th>제목</th>
		<th>등록일</th>
	</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${CBlist}" var="dto">
		<tr>
			<td>${dto.ubid }</td>
			<td>${dto.inquiryType }</td>
			<td>${dto.cTitle}</td>
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
	
	</div>	

</div>


		<%-- <div id="head">
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

<table class = "table table-hover" border=1 style = "margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom:auto; width: 1100px;">
	<thead>
	<tr>
		<th>회원id</th>
		<th>질문유형</th>
		<th>제목</th>
		<th>등록일</th>
	</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${CBlist}" var="dto">
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
	</div>	 --%>

<footer class="contaniner-fluid text-center">
<%@ include file = "footer.jsp" %>
</footer>
</body>
</html>