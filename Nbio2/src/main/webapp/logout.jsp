<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃처리</title>
</head>
	<header>
		<%@ include file = "header.jsp" %>
	</header>  
<body> 
	<%
        session.invalidate(); 
        response.sendRedirect("mainpage.jsp"); 
    %>
    	<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
    
</body>
</html>