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
<!-- <nav>
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
</nav> -->

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
		<c:forEach items="${kidlist }" var="dto1">
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
	
<%-- <table>



<c:set var="lists" scope="session" value="${list}"/>
<c:set var="totalCount" scope="session" value="${list.size }"/>
<c:set var="perPage" scope="session"  value="${5}"/>
<c:set var="pageStart" value="${param.start}"/>
<c:if test="${empty pageStart or pageStart < 0}">
       <c:set var="pageStart" value="0"/>
</c:if>
<c:if test="${totalCount < pageStart}">
       <c:set var="pageStart" value="${pageStart - perPage}"/>
</c:if>
    <a href="?start=${pageStart - perPage}"> << </a> ${pageStart + 1} - ${pageStart + perPage} 
    <a href="?start=${pageStart + perPage}"> >> </a>  
                                            
<h1>page</h1>
   <c:forEach var="listz" items="${list}" 
                        begin="${pageStart}" end="${pageStart + perPage - 1}">
              ${listz}
   </c:forEach>
</table>
 --%>	
 	<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
</body>
</html>

	
	
	<%-- <table> 
						<div class="paging">
						<div class="element">					
							<c:set var="page" value="${currentpage}"/>
							
							<!-- page maxpage를 넘었을 경우 제한 -->
							<c:if test="${page > maxpage}">
								<c:set var="page" value="${maxpage}"/>
							</c:if>
							
							<!-- 페이지를 8개씩 나누기 위해 현재 페이지에 보여줄 max값 설정 -->
							<fmt:formatNumber value="${page/8 - (page/8 % 1)}" type="pattern" pattern="0" var="full"/>
							<c:set var="full" value="${full * 8}"/>	
													
							<!-- prev(전페이지), next(다음페이지) 개수 설정 -->
							<c:set var="scope" value="${page%8}"/>			
							<c:choose>
								<c:when test="${scope == 0}">
									<c:set var="prev" value="8"/>
									<c:set var="next" value="1"/>
								</c:when>
								<c:when test="${scope < 9}">
									<c:set var="prev" value="${scope}"/>
									<c:set var="next" value="${9-scope}"/>
								</c:when>
							</c:choose>								
							
							<!-- prev 버튼 -->
							<c:if test="${page > 8}">
								<fmt:formatNumber value="${(page-1)/8 - (((page-1)/8) % 1)}" type="pattern" pattern="0" var="prevb"/>
								<c:set value="${(prevb-1)*8 + 1}" var="prevb"/>
								<span id="prevBtn" class="prev button" value="${prevb}"></span>
							</c:if>
							
							<!-- 전 페이지 -->
							<c:if test="${page != 1}">							
								<c:set var="j" value="${prev}"/>				
								<c:forEach var="i" begin="1" end="${prev-1}">
									<c:set var="j" value="${j - 1}"/>			
									<c:if test="${(page - j) > 0}">								
										<span class="no">${page - j}</span>
									</c:if>
								</c:forEach>
							</c:if>
							
							<!-- 현재 페이지 -->
							<span class="no selected">${page}</span>
							
							<!-- 다음 페이지 -->
							<c:if test="${page != maxpage}">
								<c:forEach var="i" begin="1" end="${next-1}">
									<c:if test="${maxpage >= page+i}">
										<span class="no">${page+i}</span>
									</c:if>
								</c:forEach>
							</c:if>
							
							<!-- next 버튼 -->
							<c:if test="${maxpage >= page + next}">
								<fmt:formatNumber value="${(page-1)/8 - (((page-1)/8) % 1)}" type="pattern" pattern="0" var="nextb"/>
								<c:set value="${(nextb+1)*8 + 1}" var="nextb"/>
								<span id="nextBtn" class="next button" value="${nextb}"></span>
							</c:if>							
						</div>
					</div>
	</table> --%>
<!-- <style type = "text/css"> 
.page { 
	color: red; 
}
</style>
	<div class = "page">
		<a href= "list.do?pg=1">1</a>
		<a href= "list.do?pg=2">2</a>
		<a href= "list.do?pg=3">3</a>
		<a href= "list.do?pg=4">4</a>
		<a href= "list.do?pg=5">5</a>
	</div> -->
<!-- 


</body>
</html> -->