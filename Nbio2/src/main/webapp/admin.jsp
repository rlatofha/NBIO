<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content = "width=device-width, initial-scale=1">
<link rel="stylesheet" 
href= "https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"> </script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style> 
#head {text-align: center; }</style>
</head>
<body>
<div id="head">	<h1>관리자 페이지</h1> 
				<h3> 관리자 모드</h3>
</div>	
	
	<table class="adminpage" style = "margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom:auto;" height= 150px;>
	<tr> 
	<td >	<form action = "clist.do" method="get"><input type="submit" value="고객 현황 조회" size="50" style="text-align:center; display:blcok; margin: 0 auto;"></form> </td>
	</tr>
	<tr> 
	<td>	<form action = "pulist.do" method="get"><input type="submit" value="주문 현황 조회" size="50" style="text-align:center; display:blcok; margin: 0 auto;"></form> </td>
	</tr>
	<tr> 
	<td>	<form action = "plist.do" method= "get"><input type="submit" value="상품 현황 조회" size="50" style="text-align:center; display:blcok; margin: 0 auto;"></form> </td>
	</tr>
	<tr> 
	<td>	<form action="CBlist.do" method="get"><input type="submit" value="고객 문의 관리" size="50" style="text-align:center; display:blcok; margin: 0 auto;"></form></td>
	</tr>
	</table>

</body>
</html>