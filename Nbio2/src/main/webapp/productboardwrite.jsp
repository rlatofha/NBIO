<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<%@ include file = "header.jsp" %>
	</header>  
	<table>
		<h3>제품 후기 입력</h3>	
		<form action="ProReInsert.do" method="post" enctype="Multipart/form-data">
		<%String pCode = request.getParameter("pCode"); %>
		<%String id = request.getParameter("id"); %>
		<input type="hidden" name="pCode" value="<%=pCode%>">
		<input type="hidden" name="id" value="<%=id%>">
        제목        : <input type="text" name="prTitle"><br>
        내용 : <textarea rows="10" cols="30" name="prContent"></textarea><br>
        첨부파일 : <input type="file" name="file" ><br>
        <input type="submit" value="저장">  
   		</form>
	</table>
	<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
</body>
</html>