<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<footer class="contaniner-fluid text-center">
Nbio는 통신판매중개자이며 통신판매의 당사자가 아닙니다.<br>
따라서 입점 판매자가 등록한 상품, 거래정보 및 거래에 대하여 Nbio는 일체의 책임을 지지 않습니다.<br>
대표이사 : 김성진 주소 : 서울특별시 강남구 강남대로 441,5층 사업자등록번호 : 111-11-11111 통신판매업신고번호 : 2018-서울강남-0000 <br>
고객센터 : 쇼핑(배송상품) 1111-1111 건강영양제 파트너센터 0000-0000 E-mail aaaaaaa@aaanbio.com
</footer>



</body>
</html>