<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 결과</title>
</head>
<body>
	<header>
		<%@ include file = "header.jsp" %>
	</header>  

<% Object pwd = session.getAttribute("pwd"); %>
고객님의 비밀번호 <%=pwd %> 입니다.

<div>
			&nbsp;<a href="mainpage">메인 페이지</a>
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="login.jsp">로그인</a>
</div>
	<footer>
		<%@ include file = "footer.jsp" %>
	</footer>

</body>
</html>
<style>
a:link, a:visited {
	background-color: white;
	font-size: 12px; color : black;
	padding: 3px;
	border-radius: 3px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	color: black;
}
</style>