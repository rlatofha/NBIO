<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Vector"%>
    <%String id = (String)session.getAttribute("id");%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8 "> 
<meta name = "viewport" content = "width=device-width", initial-scale="1"> 
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

	productinfo {
	border : 1px solid blick; 
	border-collapse: collapse; 
	} 
	
	productinfo {
		width: 500px; 
		height : 200px; 
		margin-right: auto; 
		padding-top: 50px;
	}
	productinfo { 
	text-align: center; 
	}
	review { 
		width: auto; 
		height : 300px; 
		margin: 0px 800px 0px; 
		margin-left: auto; 
		margin-right: auto; 
		padding-top: 50px;
	}
	
	.productinfoimg{
	text-align: center;
	}

	
</style>
<script type="text/javascript">
	function checkpurchase() {
		var form = document.check
		var tt=parseInt(form.pQuan.value);
		var tt2=parseInt(form.purQuan.value);
		if(form.purQuan.value==0){
			alert("구매수량을 입력해주세요.")
			form.purchasequantity.select()
			return
		}
		if((form.pQuan.value==0) || (tt < tt2)){
			alert("잔여수량이 부족합니다.")
			form.productquantity.select()
			return
		}
		if(form.id.value==""){//변경필요
			alert("로그인을 해주세요.")
			form.purchasequantity.select()
			return
		}
		form.submit()
	}
	function checkcart() {
		var form = document.check
		var tt=parseInt(form.pQuan.value);
		var tt2=parseInt(form.purQuan.value);
		if(form.purQuan.value==0){
			alert("구매수량을 입력해주세요.")
			form.purchasequantity.select()
			return
		}
		if((form.pQuan.value==0) || (tt < tt2)){
			alert("잔여수량이 부족합니다.")
			form.productquantity.select()
			return
		}
		if(form.id.value==""){//변경필요
			alert("로그인을 해주세요.")
			form.purchasequantity.select()
			return
		}
		form.submit()//cart로 submit 못시키나?cart_insert.do
	}
</script>
</head>
<body>
<%-- 해더 시작 --%>
<header>
<%@ include file = "header.jsp" %>
</header>
<%-- 정규문 --%>

<main><%-- 정보나열 --%>	
<div class = "productpicture"> 
<div class = "col-sm-6"> 
<div class = "container-fluid"> 
<img alt="${productInfo.pImg}" src="${productInfo.pImg}" height="100%" width="100%">
</div>
</div>
</div>
<div class ="productinfo"> 
<div class = "col-sm-6"> 
<br> 
<br> 
<br>
<br> 
<br> 
<form action=purchase_info.do name="check" method="get">
 

<table class= "productinfo" border="2" style= "margin-left:100px; margin-top: 50px; " width= 600px; height = 700px >	
			<tr>
			<td colspan = "2"> <h2>&nbsp;제품 정보</h2> </td>
			</tr> 
			<tr>
				<td> <!-- style="text-align: right;padding-right: 10px;" --><h3>&nbsp;상품명</h3></td>	
				<td><!--  style = "text-align: right; padding-left: 30px;" --><h3>&nbsp;${productInfo.pName}</h3></td>
			</tr>	

			<tr>
				<td ><h3>&nbsp;브랜드&nbsp;&nbsp;&nbsp;&nbsp;</h3></td>	
				<td><h3>&nbsp;${productInfo.brand}</h3></td>
			</tr>	
			
			<tr>
				<td><h3>&nbsp;관련&nbsp;&nbsp;&nbsp;&nbsp;</h3></td>	
				<td><h3>
					<c:if test="${productInfo.dis ne null}">&nbsp;${productInfo.dis}<br></c:if>
					<c:if test="${productInfo.hT ne null}">&nbsp;${productInfo.hT}<br></c:if>
					<c:if test="${productInfo.nut ne null}">&nbsp;${productInfo.nut}<br></c:if> </h3></td>
			</tr>	

			<tr>
				<td><h3>&nbsp;잔여수량&nbsp;&nbsp;&nbsp;&nbsp;</h3></td>	
				<td><h3>&nbsp;${productInfo.pQuan}</h3></td>
			</tr>	

			<tr>
				<td><h3>&nbsp;구매수량&nbsp;&nbsp;&nbsp;&nbsp;</h3></td>	
				<td ><h3>&nbsp;<input type="text" name="purQuan" size="10"></h3></td>
			</tr>	
						<tr>
				<td><h3>&nbsp;가격&nbsp;&nbsp;&nbsp;&nbsp;</h3></td>	
				<td><h3>&nbsp;${productInfo.pPrice}</h3></td>
			</tr>

			<tr>
				<td><h3>&nbsp;<input type="button" value="구매하기" onclick="checkpurchase()"></h3></td>
				<td><a href="cart_insert.do?pCode=${productInfo.pCode}"><h3>&nbsp;<input type="button" value="장바구니"></h3></a></td>
			</tr>		
</table>
	<input type="hidden" name="pCode" value="${productInfo.pCode}">
	<input type="hidden" name="id" value="<%=session.getAttribute("id")%>">
	<input type="hidden" name="pPrice" value="${productInfo.pPrice}">
	<input type="hidden" name="pQuan" value="${productInfo.pQuan}">
	<input type="hidden" name="pName" value="${productInfo.pName}">
</form>
</div>
<div class="productinfoimg">
	<div class="col-sm-12">
		<img alt="${productInfo.pInfo}" src="${productInfo.pInfo}" width="1000">
	</div>
</div>


 
<table class= "review"  border="1" style="margin-left:auto; margin-right: auto;" width= 1000px; height = 300px >
	<tr>
	<th colspan="7">상품 후기</th>
	</tr>
	<tr>
	<th>구분</th><th>회원id</th><th>제목</th><th>내용</th><th>사진</th><th>등록일</th><th>삭제</th>
	</tr>
		<c:forEach items="${prvlist }" var="dto">
		<tr>
			<td>${dto.num }</td>
			<td>${dto.prid }</td>
			<td>${dto.prContent }</td>
			<td>${dto.prTitle}</td>
			
			<td><img alt="${dto.prfilepath}" src="./upload/${dto.prfilepath}" height="300" width="300"></td>
			<!--  <td>${dto.prfilepath }</td> -->
			
			
			<td>${dto.prDate }</td>
			<td><a href = "PrReviewDelete.do?pCode=${productInfo.pCode}">삭제</a></td>
		</tr>
		</c:forEach> 
		
		
		<br><br> 
		<tr> 
		<td colspan="7"> 
		<form action="productboardwrite.jsp" method="post">
			<input type="hidden" name="pCode" value="${productInfo.pCode}">
			<input type="hidden" name="id" value="<%=id%>">
			<input type="submit" value="글작성"><br>
		</form>


		
		댓글 page 지정		
		<%
			Object count_obj = request.getAttribute("count");
		
			System.out.print(count_obj);
			
			String count_str = count_obj.toString();
			int count = Integer.parseInt(count_str);
		
			for(int i = 1; i <= count; i++){ 
		%>
			<a href="product_info.do?page=<%=i %>&pCode=${productInfo.pCode}">[<%=i %>]</a>
		<% };%>
		</td>
		</tr> 
		</table>

<!-- <input style="text-align: left ;padding: 1px;"> 관 련 
<input style="text-align: left ;padding: 1px;"> 잔여수량 
<input style="text-align: left ;padding: 1px;"> 구매수량 
<input style="text-align: left ;padding: 1px;"> 가 격 
<input type="button" value="구매하기" onclick="checkpurchase()">
</div> -->
</div>


<%-- <table><tr><td><img alt="${productInfo.pImg}" src="${productInfo.pImg}" height="300" width="300"></td><td>
 --%>	
 <%-- <form action=purchase_info.do name="check" method="get">
		<table>	
			<tr>
				<td style="text-align: right;padding: 1px;">상품명 :</td>	
				<td>${productInfo.pName}</td>
			</tr>	
			<tr>
				<td style="text-align: right;padding: 1px;">브랜드 :</td>	
				<td>${productInfo.brand}</td>
			</tr>	
			<tr>
				<td style="text-align: right;padding: 1px;">관련 :</td>	
				<td>
					<c:if test="${productInfo.dis ne null}">${productInfo.dis}<br></c:if>
					<c:if test="${productInfo.hT ne null}">${productInfo.hT}<br></c:if>
					<c:if test="${productInfo.nut ne null}">${productInfo.nut}<br></c:if>
				</td>
			</tr>		
			<tr>
				<td style="text-align: right;padding: 1px;">잔여수량 :</td>	
				<td>
				<input type="text" name="pQuan" readonly="readonly" size="10" value="${productInfo.pQuan}"></td>
			</tr>	
			<tr>
				<td style="text-align: right;padding: 1px;">구매수량 :</td>	
				<td><input type="text" name="purQuan" size="10"></td>
			</tr>				
			<tr>
				<td style="text-align: right;padding: 1px;">가격 :</td>	
				<td>${productInfo.pPrice}</td>
			</tr>	
			<tr>
				<td><input type="button" value="구매하기" onclick="checkpurchase()"></td>구매확인용 버튼	
				<td><a href="cart_insert.do?pCode=${productInfo.pCode}">장바구니</a></td>  장바구니용 버튼
			</tr>		
		</table>
		<input type="hidden" name="pCode" value="${productInfo.pCode}">			넘겨받는 아이디, 키
		<input type="hidden" name="id" value="<%=session.getAttribute("id")%>">
		<input type="hidden" name="pPrice" value="${productInfo.pPrice}">
		<input type="hidden" name="pName" value="${productInfo.pName}">
	</form>	
</td></tr></table>	
<img alt="${productInfo.pInfo}" src="${productInfo.pInfo}" width="1000">
<br>
<br>
<br>

 --%>

<%--리뷰 페이지 공간(수정 부분) --%>
<%-- <table border="1">
	<tr>
	<th colspan="6">상품 후기</th>
	</tr>
	<tr>
	<th>구분</th><th>회원id</th><th>제목</th><th>내용</th><th>사진</th><th>등록일</th><th>삭제</th>
	</tr>
		<c:forEach items="${prvlist }" var="dto">
		<tr>
			<td>${dto.num }</td>
			<td>${dto.prid }</td>
			<td>${dto.prContent }</td>
			<td>${dto.prTitle}</td>
			
			<td><img alt="${dto.prfilepath}" src="./upload/${dto.prfilepath}" height="300" width="300"></td>
			<!--  <td>${dto.prfilepath }</td> -->
			
			
			<td>${dto.prDate }</td>
			<td><a href = "PrReviewDelete.do?pCode=${productInfo.pCode}">삭제</a></td>
		</tr>
		</c:forEach> 
		</table>
		<form action="productboardwrite.jsp" method="post">
			<input type="hidden" name="pCode" value="${productInfo.pCode}">
			<input type="hidden" name="id" value="<%=id%>">
			<input type="submit" value="글작성"><br>
		</form>



		댓글 page 지정		
		<%
			Object count_obj = request.getAttribute("count");
		
			System.out.print(count_obj);
			
			String count_str = count_obj.toString();
			int count = Integer.parseInt(count_str);
		
			for(int i = 1; i <= count; i++){ 
		%>
			<a href="product_info.do?page=<%=i %>&pCode=${productInfo.pCode}">[<%=i %>]</a>
		<% };%> --%>
		
		
		
		
</main>
<footer></footer>

</body>
</html>