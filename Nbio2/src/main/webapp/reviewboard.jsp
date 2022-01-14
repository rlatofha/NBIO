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


<h2>게시판 수정 및 삭제  </h2>
	<table border="0">
		<form action="CBlist.do" method="post" enctype="Multipart/form-data"> <!-- modify.do -->	
			<tr>
				<td>회원ID</td>
				<td><input type="text" name="ubid" readonly="readonly" value="${board_view.ubid }"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="cTitle" size="20" readonly="readonly" value="${board_view.cTitle  }"></td>
			</tr>
			
			<tr>
				<td>질문유형</td>
				<td><input type="text" name="inquiryType" size="20" readonly="readonly" value="${board_view.inquiryType  }"></td>
			</tr>
			
			
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="30" name="cContent" readonly="readonly" >${board_view.cContent  }</textarea></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><img alt="${board_view.cUploadfile  }" src="./upload/${board_view.cUploadfile  }" height="100" width="100"></td>
			</tr>
			<!-- 댓글 작성 -->
			<tr>
				<td colspan="2"><input type="submit" value="목록보기">
			</tr>

		</form>
		<table border="1">
			<tr>
			<th>회원id</th><th>질문내용</th><th>등록일자</th><th>댓글삭제</th>
	        </tr>
			<c:forEach items="${reboard_view }" var="dto">
			<tr>
				
				<td><input type="text" name="ruid"  size="10" value="${dto.ruid }" readonly="readonly" ></td>
				<td><input type="text" name="reviewContent"  size="50" value="${dto.reviewContent }" readonly="readonly" ></td>
				<td><input type="text" name="reviewDate" value="${dto.reviewDate }"> </td>
				<td><a href ="reviewdelete.do?reviewContent=${dto.reviewContent }">삭제</a></td>
			</tr>
			</c:forEach> 
		 </table>
					
			<!-- 댓글 작성 -->
			<form action="reviewInsert.do" method="post">
			<input type="hidden" name="ubid" value="${board_view.ubid }">
				댓글 : <input type="text" name="reviewContent"  size="50">
					<input type="submit" value="댓글작성">
			</form>

	
</body>
</html>