<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- <%@ taglib prefix="c_rt" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%
	String current_page = request.getParameter("current_page"); 
	int ItemCount = 
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8 "> 
<meta name="viewport" content = "width=device-width, initial-scale=1">
<link rel="stylesheet" 
href= "https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"> 
</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style> 
	<%-- 해더 부분 시작 --%>
	.navbar{ 
		background-color: 	#FFFFFF	; 
		margin-bottom:auto; 
		border-radius:0; 
		border: none; 
		outline: none; 
	}
    <%-- 해더 부분 끝 --%>
	<%-- 메인 부분 시작 --%>
	.row.content {
	margin-left: auto;
	}
	.img{ 
		margin-bottom: auto; 	
	}
	.sidnav{
		padding-top: 0px; 
		padding-left: -5px; 
		background-color: #f1f1f1; 
		height: 100% 
	}
	.col-sm-3{
		padding-left: -3px;
	}
	footer { 
		background-color : #FFFFFF; 
		color:#A9A9A9 ; 
		padding: 40px; 
	}
	@media screen and (max-width: 767px){ 
		.sidenav{ 
			height: auto; 
			padding: 0px; 
	}
		.row.content {height: auto;}
	}

</style>
</head>
<body>
<%-- 해더 시작 --%>
<header>
<%@ include file = "header.jsp" %>
</header>
<!--  <nav>
  <ul>
    <li><a href="list.do">Home</a></li>
    <li><a href="#">About</a></li>
    <li><a href="#">제품	</a>
      <ul>
        <li><a href="femalelist.do">Female</a></li>
        <li><a href="malelist.do">Male</a></li>
        <li><a href="kidlist.do">Kid</a></li>
        <li><a href="elderlist.do">Elder</a></li>
      </ul>
    </li>
    <li><a href="#">영양</a>
      <ul>
        <li><a href="preglist.do	">임신, 임산부</a></li>
        <li><a href="joinlist.do">연골, 관절</a></li>
        <li><a href="cardiolist.do">심혈관</a></li>
        <li><a href="digestivelist.do">소화	</a></li>
        <li><a href="menopauselist.do">폐경기, 갱년기</a></li>
        <li><a href="osteolist.do">뼈, 골다골증</a></li>
      </ul>
    </li>
  </ul>
</nav>
검색:  -->
	<form action= "search.do" method="get"> 
	<select name = "search1"> 
		<option value = "brand"> 브랜드 </option>
		<option value = "pName" selected = "selected"> 제품명 </option>
	</select> &nbsp;&nbsp; 
	<td><input type = "text" name = "search2" size = "50"></td>
	<input type = "submit" value = "검색"> 
	</form>
	<div class="container-fluid">
	<div class ="row"> 
	<h1> 건강 기능 식품</h1>
		<c:forEach items="${osteolist }" var="dto1">
			<div class = "col-md-3">
			<div class = "thumbnail">
			<a href ="product_info.do?pCode=${dto1.pCode }"><img alt = "${dto1.pImg }" src="${dto1.pImg}" width= "300" height = "300"> </a>
			<div class = "caption"> 
			<p>${dto1.pName }</p>
			<p>${dto1.pPrice}</p>
	</div>
	</div>
	</div>
		</c:forEach>
	</div>
	</div>	
	
	<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
</body>
</html>

