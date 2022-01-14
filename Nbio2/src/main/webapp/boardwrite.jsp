<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"

href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>문의사항 작성 페이지</title>
</head>
<body>
<header>
<%@ include file = "header.jsp" %>
</header>

<div class="container">
<h1 style="color: #32CD32">고객 문의사항 작성</h1>
<ul class="nav nav-tabs">

	<li class="tab-link current" date-tab="tab-1"></li>

	</ul>	
	
	<br>	
	
	<div id="tab-1" class="tab-content currunt">
	
	<table>
		<h3>고객 문의사항 입력</h3>	
		<form action="boardwrite.do" method="post" enctype="Multipart/form-data">
		회원ID        : <input type="text" name="ubid" value = "${id}" readonly="readonly"><br>
        제목        : <input type="text" name="cTitle"><br>
        질문유형 : <select name="inquiryType">
					<option >로그인/회원가입</option>
					<option >상품문의</option>
					<option >배송문의</option>
					<option >주문문의</option>
					<option >기타</option>
				</select><br>
        내용 : <textarea rows="10" cols="30" name="cContent"></textarea><br>
        첨부파일 : <input type="file" name="file" ><br>
        <input type="submit" value="저장">  
   		</form>
	</table>
	
	</div>	

</div>



<%-- 
	<table>
		<h3>고객 문의사항 입력</h3>	
		<form action="boardwrite.do" method="post" enctype="Multipart/form-data">
		회원ID        : <input type="text" name="ubid" value = "${id}" readonly="readonly"><br>
        제목        : <input type="text" name="cTitle"><br>
        질문유형 : <select name="inquiryType">
					<option >로그인/회원가입</option>
					<option >상품문의</option>
					<option >배송문의</option>
					<option >주문문의</option>
					<option >기타</option>
				</select><br>
        내용 : <textarea rows="10" cols="30" name="cContent"></textarea><br>
        첨부파일 : <input type="file" name="file" ><br>
        <input type="submit" value="저장">  
   		</form>
	</table> --%>
	
	
<footer class="contaniner-fluid text-center">
<%@ include file = "footer.jsp" %>
</footer>
</body>
</html>