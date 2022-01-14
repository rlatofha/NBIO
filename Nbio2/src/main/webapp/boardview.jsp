<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>

<h2>게시판 수정 및 삭제  </h2>
	<table border="0">
		<form action="Bmodify.do" method="post" enctype="Multipart/form-data"> <!-- modify.do -->	
			<tr>
				<td>회원ID</td>
				<td><input type="text" name="ubid" readonly="readonly" value="${board_view.ubid }"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="cTitle" size="20" value="${board_view.cTitle  }"></td>
			</tr>
			
			<tr>
				<td>질문유형</td>
				<td><input type="text" name="inquiryType" size="20" value="${board_view.inquiryType  }"></td>
			</tr>
			
			
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="30" name="cContent" >${board_view.cContent  }</textarea></td>
			</tr>
			<tr>

				<td>파일수정</td>
				<td><input type="file" name="file"  size="20" ></td>
				
			</tr>
			<tr>
				<td>파일<td>
				<td><img alt="${board_view.cUploadfile  }" src="./upload/${board_view.cUploadfile  }" height="100" width="100"></td>
			</tr>
			
			
			
			<!-- 댓글 작성 -->
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;<a href="CBlist.do">목록보기</a> <a href="delete.do?ubid=${board_view.ubid }">삭제</a></td>
			</tr>

		</form>
	</table>			
		


</body>
</html>





