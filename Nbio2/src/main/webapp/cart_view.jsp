<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script>
function choisePri(){
	document.cartForm.submit();
}

$(function(){
	var cartno = document.getElementsByName("pCode");
	var count = cartno.length;

	$("#allCheck").click(function(){
		var cnList = $("input[name=pCode]");
		for(var i = 0; i<cnList.length; i++){
			cnList[i].checked = this.checked;
		}
	});
	$("input[name='pCode']").click(function(){
		if($("input[name='pCode']:checked").length == count){
			$("#allCheck")[0].checked= true;
		}
		else {
			$("#allCheck")[0].checked= false;
		}
	});
	

});

</script>
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

<h1 style="text-align: center;">장바구니</h1>

<br>
<br>
<br>
<table style= "margin-left:auto; margin-top: auto; margin-right: auto; " width= 1000px; height = auto;>
	<tr>
		<td style="text-align: right;">
			<form action="cartAllDelete.do">
				<input type="submit" value="장바구니 비우기">
			</form>
		</td>
	</tr>
</table>
<br>
	<form action="purchase_cart.do">
		<table border="1" style= "margin-left:auto; margin-top: auto; margin-right: auto; " width= 1000px; height = auto; >
				<tr><%-- 장바구니 페이지 --%>
					<th>전부선택<input type="checkbox" id="allCheck"></th>
					<th>이미지</th>
					<th>상품명</th>
					<th>구매수량</th>
					<th>상품가격</th>
					<th>삭제선택</th>
				</tr>
			<c:set var="sum" value="0" />
			<c:forEach items="${cart_view}"  var="dto">
				<tr>
					<td><input type="checkbox" name="pCode" value="${dto.pCode}"></td>
					<td><img alt="${dto.pImg}" src="${dto.pImg}" height="50" width="50"></td>
					<td>${dto.pName}</td>
					<td>
					<a href="cartQtyDown.do?pCode=${dto.pCode}" >
					-
					</a>
					${dto.cartQty}
					<a href="cartQtyUp.do?pCode=${dto.pCode}" >
					+
					</a>
					</td>
					<td><input type="text" name="pPrice" value="${dto.pPrice * dto.cartQty}" readonly="readonly"></td>
					<td><a href="cartSelectDelete.do?pCode=${dto.pCode}">삭제</a></td>
				</tr>
				
			<%-- <c:set var="sum" value="${sum + (dto.pPrice * dto.cartQuy)}" /> --%>
			</c:forEach>
				</table>
			<br>
			<br>
			<br>
			<br>
			<br>
				<table style= "margin-left:auto; margin-top: auto; margin-right:auto; " width= 1000px; height = auto;>
				<tr>
					<td colspan="6" style="text-align: right;"><input type="submit" value="구매"></td>
				</tr>
			</table>
		<br><br>
	</form>
	<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
</body>
</html>