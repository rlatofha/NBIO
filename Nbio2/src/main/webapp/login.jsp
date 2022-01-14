<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
function login(){

	var id = $('#id').val();
	var pwd = $('#pwd').val();
	$.ajax({
		type:"POST",
		url: 'login.do',
		data:{"id" :id, "pwd" : pwd},
		success: function(chk){
						 if(chk == "1") {
							alert("로그인 성공")
			              	location.href = "mainpage.jsp";
						  } if(chk == "2") {
							alert("관리자 로그인 성공")
			              	location.href = "admin.jsp";
			              } else {
			                 alert("아이디나 비밀번호를 다시 확인해주세요.");
			                 $("#id").val("");
			                 $("#pwd").val("");
			                 <%session.invalidate();%>
			             }
					}		
				});

			}

</script>
</script>

<body width="100%" height="100%">

	<form action="login.do" method="get" class = "loginForm">
		
		<div class = "idForm"> 
			<input type="text" name="id" id="id" class="id" placeholder="ID">
		</div>

		<div class="passForm">
			<input type="password" name="pwd" id="pwd" class= "pw" placeholder="PW">
		</div>
		
		<div><input type="button" value="로그인" class="btn" onclick="login()"></div>
		
		
	
		<div class = "bottomText">
			&nbsp;<a href="findid.jsp">아이디 찾기</a>
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="findpwd.jsp">비밀번호찾기</a>
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="member.jsp">회원가입</a>
		</div>

	<ul onclick="kakaoLogin();" >
      <a href="javascript:void(0)">
      <div class = kakao><span><img src=https://developers.kakao.com/tool/resource/static/img/button/login/simple/ko/kakao_login_small.png ></span></div>  
      </a> </ul>
	
	</form>
</body>
</html>


<style>
*{
  margin: 0px;
  padding: 0px;
  text-decoration: none;
  font-family:sans-serif;

}

body {
  background-image: #34495e;
}

.loginForm {
  position:absolute;
  width:300px;
  height:400px;
  padding: 30px, 20px;
  background-color:#FFFFFF;
  text-align:center;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 15px;
}

.loginForm h2{
  text-align: center;
  margin: 30px;
}

.idForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.passForm{
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.id {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.pw {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.btn {
  position:relative;
  left:40%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:80%;
  height:40px;
  background: linear-gradient(#006400)	;
  background-position: left;
  background-size: 200%;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  display:inline;
}

.btn:hover {
  background-position: right;
}

.bottomText {
  text-align: center;
}

/* a:link, a:visited {
	background-color: white;
	font-size: 12px; color : black;
	padding: 3px;
	border-radius: 3px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	color: black;
}

ul{
   list-style:none;
   }

body {
	font-size: small;
	font-family: Arial, '맑은 고딕';
}

.login {
 	height: 28px;
	width: 220px;
	background-color: #A8F552;
	border-radius: 16px; border : 0;
	color: white;
	border: 0; 
}

.finish1 {
	height: 28px;
	width: 100px;
	background-color: #A8F552;
	border-radius: 10px;
	border: 0;
	color: white;
}
 */
.kakao{
/* 	margin:0px 510px 0px; */
	padding-top: 15px;
	align: "center";
}
/* 
div {
	align: "center";
	margin: 0px 550px 0px;
}

.addr {
	padding: px;
}
} */
</style>

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('8c444191ac2d42920c184c4d2695d7b6'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>