<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	
<div class="container-fluid text-center"> 

<div class = "row"> 
	<%-- first image --%>
	<div class = "col-sm-3"> 
		<div class = "container-fluid">
			<a href = "femalelist.do">
			<img class = "img" alt = "./images/women.jpeg" src = "./images/women.jpeg" style = "height: 170%; width: 130%;">
			</a>	
		</div>
	</div>
	<%-- end of first image --%>
	<%-- second image --%>
	<div class = "col-sm-3"> 
		<div class = "container-fluid">
			<a href = "malelist.do">
			<img class = "img" alt = "./images/men.jpeg" src = "./images/men.jpeg" style = "height: 170%; width: 130%;">
			</a>	
		</div>
	</div>
	<%-- end of second image --%>
	
		<div class = "col-sm-3"> 
		<div class = "container-fluid">
			<a href = "kidlist.do">
			<img class = "img" alt = "./images/kids.jpeg" src = "./images/kids.jpeg" style = "height: 170%; width: 130%;">
			</a>	
		</div>
	</div>
		<div class = "col-sm-3"> 
		<div class = "container-fluid">
			<a href = "malelist.do">
			<img class = "img" alt = "./images/old.jpeg" src = "./images/old.jpeg" style = "height: 170%; width: 130%;">
			</a>	
		</div>
	</div>
</div>
</div>




<footer class="contaniner-fluid text-center">
<%@ include file = "footer.jsp" %>
</footer>





</body>
</html>