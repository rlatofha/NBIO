<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>구매내역 조회</h1>
	
	<form action="search.do" method="post">
		검색선택 : 
		<select name="search">
		<option value="name">이름</option>
		<option value="purchaseprice">가격</option>
		</select>&nbsp;&nbsp;&nbsp;
		<input type="text" name="content" size="20">
		<input type="submit" value="검색">
	</form>
	
	
	
	<table border="1">
		<tr>
			<th>제품명</th><th>제품 id</th><th>제품코드</th><th>가격</th><th>수량</th><th>구매날짜</th><th>수량</th>
		</tr>
		<c:forEach items="${pulist}" var ="dto"> <!--forEach는 반복문  -->
			<tr>
				<td>${dto.pName}</a></td>
				<td>${dto.puid}</td>
				<td>${dto.pucode}</td>
				<td>${dto.purchaseprice}</td>
				<td>${dto.purchasequantitiy}</td>
				<td>${dto.purchasedate}</td>
				<td>${dto.pumDate}</td>
			</tr>
		</c:forEach>	
		<tr>
		</tr>	
	</table>
		<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
	
</body>
</html>