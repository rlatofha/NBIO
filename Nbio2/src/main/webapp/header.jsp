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
<nav class= "navbar navbar">
	<div class = "container-fluid">
		<div class="navbar-header"> 
		<button type ="button" class= "navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
			<span class = "icon-bar"></span>
			<span class = "icon-bar"></span>
			<span class = "icon-bar"></span>		
		</button>
	
		</div>
		
		<div class = "collapse navbar-collapse" id="myNavbar">
			<ul class = "nav navbar-nav"> 
				<li><a class="navbar-brand" href="list.do"><img class = "img" alt = "./images/nbio.png" src = "./images/nbio.png" style = "height: 40px; width: 80px;"></a></li>
				<li class = "active"> <a href="mainpage.jsp"><h4>Home</h4></a></li>
				
				
				<%-- 회사 소개 및 회사 오는 길 확인 --%>
				<li><a href="companylocation.jsp"><h4>Company</h4> </a></li>
				
				
				<li><button class ="btn btn-link navbar-btn" type="button" data-toggle="dropdown"><h4>제품</h4>
					<span class="caret"></span>	</button>
			<ul class="dropdown-menu">
				<li><a href="malelist.do"> 남성</a></li>
				<li><a href="femalelist.do"> 여성</a></li>
				<li><a href="kidlist.do"> 유아</a></li>
				<li><a href="elderlist.do"> 노인</a></li>
			</ul></li>
			<li> <button class ="btn btn-link navbar-btn" type="button" data-toggle="dropdown"> <h4>영양</h4>
				<span class="caret"></span>	</button>
			<ul class="dropdown-menu">
				<li><a href="cardiolist.do"> 심혈관</a></li>
				<li><a href="preglist.do"> 임산부</a></li>
				<li><a href="joinlist.do"> 연골,관절</a></li>
				<li><a href="menopauselist.do"> 폐경기,갱년기</a></li>
				<li><a href="osteolist.do"> 골다골증</a></li>
				<li><a href="digestivelist.do"> 소화</a></li>
			</ul></li>
			
			<%-- 상품 추천 jsp --%>
			<li><a href="recommandlist.jsp"><h4>추천상품</h4></a></li>
			
			</ul>	
					<div class = "collapse navbar-collapse" id="myNavbar">
			<ul class = "nav navbar-nav navbar-right"> 
			
			<%-- jsp 입력 부분 --%>
			<c:if test="${id eq null}">
			<li><a href="login.jsp"><h4><span class ="glyphicon glyphicon-log-in"></span> 로그인</h4>	</a></li>
			</c:if>
			<c:if test="${id ne null}">
			<li><a href="logout.jsp"><h4><span class ="glyphicon glyphicon-log-in"></span> 로그아웃</h4>	</a></li>
			</c:if>
			<li><a href="mypage.jsp"><h4>마이페이지</h4></a></li>
			<li><a href="cart_view.do"><h4>장바구니</h4></a></li>
			
			</ul>
		</div>
		</div>
		

		<div class = "col-sm-13" style = "text-align: center;"> 
		<a href="mainpage.do">
			<img class = "img" alt = "./images/nbio.png" src = "./images/nbio.png" style = "height: 80px; width: 160px;">
		</a>
		</div>
		<br>
		<br>
		
		
		

	</div>
</nav>



</body>
</html>