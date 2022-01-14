<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원가입</title>
<h3 style="color: #98FA73;">회원가입 페이지 입니다</h3>
</head>
<style>
body {
	font-size: small;
	font-family: Arial, '맑은 고딕';
}

.finish {
	height: 40px;
	width: 100px;
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

div {
	align: "center";
	margin: 0px 550px 0px;
}

.addr {
	padding: px;
}
</style>
<!-- <script src="/webapp/js/bootstrap.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
//^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$ 
$(function(){
		 $('#id').on('blur' ,function() {
			 var id = $('#id').val();
				console.log($('#id').val());
				$.ajax({
					url : 'idcheck.do?id='+ id,
					type : 'get',
					success : function(seq) {
						console.log("1 = 중복o / 0 = 중복x : "+ seq );	
						if (seq == "1") {
								// 1 : 아이디가 중복되는 문구
								$("#id_check").text("사용중인 아이디입니다 :p");
								$("#id_check").css("color", "red");
								$("#reg_submit").attr("disabled", true);
						}else{
							  if(id == ""){
								$('#id_check').text('아이디를 입력해주세요 :)')
								$('#id_check').css('color', 'red');
								$("#reg_submit").attr("disabled", true);			
							 } else if(!/^[a-z]+[a-z0-9]{5,19}$/g.test(id)){
								$('#id_check').html("아이디는 영문로 시작하는 영문 또는 숫자 5~20자리만 가능합니다. :)");
								$('#id_check').css('color', 'red');
								$("#reg_submit").attr("disabled", true);
							 } else {
								$('#id_check').html("사용 가능한 아이디 입니다.");
								$('#id_check').css('color', 'green');
								$("#reg_submit").attr("disabled", true);
							 }
							}
						}, error : function() {
								console.log("실패");
						}
					});
				});
		 
		 $("#alert-success").hide();
		 $("#alert-danger").hide(); 
		 $("input").keyup(function(){
			 var pwd1=$("#pwd").val(); 
			 var pwd2=$("#pwdChk").val(); 
			 if(pwd1 != "" || pwd2 != ""){ 
				 if(pwd1 == pwd2){ 
					 $("#alert-success").show(); 
					 $("#alert-danger").hide(); 
					 $("#submit").removeAttr("disabled"); 
				 }else{ 
					 $("#alert-success").hide(); 
					 $("#alert-danger").show(); 
					 $("#submit").attr("disabled", "disabled"); 
					 } 
				 } 
			 }); 
		 $('#pwd').on('keyup' ,function(event) {
			    if (!/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/g.test($('#pwd').val())) {
			        $('#invalid-pwd').html(" 비밀번호는 하나이상의 문자, 숫자, 특수문자로 8자 이상 입력해 주시기 바랍니다.");
			        $('#invalid-pwd').show(); 
			    } else {
			        $('#invalid-pwd').empty();
			    }
			});
		 $('#mail').on('keyup' ,function(event) {
			    if (!/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g.test($('#mail').val())) {
			        $('#invalid-email').html(" 유효한 이메일 주소를 입력해 주시기 바랍니다.");
			        $('#invalid-email').show(); 
			    } else {
			        $('#invalid-email').empty();
			    }
			});
		
		 $('#name').on('keyup' ,function() {
			    if ($('#name').val() ==""){
			    	$('#invalid-name').empty();
	   		    } else if(! /^[가-힣]+$/g.test($('#name').val())) {
			        $('#invalid-name').html(" 이름은 한글, 글자로만 입력해 주시기 바랍니다.");
			        $('#invalid-name').show(); 
			    } else {
			        $('#invalid-name').empty();
			    }
			});
		 $('#tel').on('keyup' ,function(event) {
			  	if ($('#tel').val() ==""){
			    	$('#invalid-tel').empty();
	   		    } else if (! /^010-?([0-9]{4})-?([0-9]{4})$/g.test($('#tel').val())) {
			        $('#invalid-tel').html(" 올바른 형식의 전화번호가 아닙니다.");
			        $('#invalid-tel').show(); 
			    } else {
			        $('#invalid-tel').empty();
			    }
			});
		 $('#birth').on('keyup' ,function(event) {
			  	if ($('#birth').val() ==""){
			    	$('#invalid-birth').empty();
	   		    } else if (! /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/g.test($('#birth').val())) {
			        $('#invalid-birth').html(" 올바른 형식의 생년월일이 아닙니다.");
			         $('#invalid-birth').show(); 
			    } else {
			        $('#invalid-birth').empty();
			    }
			});
		
		
		
		});

		

    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.	
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
 
	
</script>


<body>
	<header>
		<%@ include file = "header.jsp" %>
	</header>  
	<main>
		<form action="memberjoin.do" name="join" method="post" id= "form1">
			<div class="join">아이디</div>
			<div class="join">
				<input type="text" name="id" size="40" id="id" class="form-control"
					required="required" placeholder="아이디 입력 영문 소문자,숫자 포함 4~20자리" maxlength="20" >
			</div>
			<div class=check_font id="id_check"></div>

			<p>
			<div class="join">비밀번호</div>
			<div class="join">
				<input type="password" name="pwd" id="pwd" size="40">
			</div>
			<div id="invalid-pwd"></div>
			</p>

			<p>
			<div class="join">비밀번호 확인</div>
			<div class="join">
				<input type="password" name="pwdChk" id="pwdChk" size="40">
			</div>
			<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
			<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
			</p>

			<p>
			<div class="join">이름</div>
			<div class="join">
				<input type="text" name="name" id="name" size="40">
			</div>
			<div id="invalid-name"></div>
			</p>

			<p>
			<div class="join">이메일</div>
			<div class="join">
				<input type="text" name="mail" id="mail" size="40">
			</div>
			<div id="invalid-email"></div>
			</p>


			<p class="join">
			<div>전화번호</div>
			<div class="join">
				<input type="text" name="tel" id="tel" size="40" placeholder="예시)01022221111">
			</div>
			<div id="invalid-tel"></div>
			</p>


			<p>
			<div>주소</div>
			<div>
				<input type="text" id="sample4_postcode" placeholder="우편번호" readonly="readonly">
				<input class="finish1" type="button"
					onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
			</div>
			<div>
				<input type="text" name="sample4_jibunAddress" readonly="readonly"
					id="sample4_jibunAddress" placeholder="지번주소" size="40">
			</div>
			<div>
				<input type="text" name="sample4_roadAddress" readonly="readonly"
					id="sample4_roadAddress" placeholder="도로명주소" size="40">
			</div>
			<div>
				<span id="guide" style="color: #999; display: none"></span>
			</div>
			<div>
				<input type="text" name="sample4_detailAddress"
					id="sample4_detailAddress" placeholder="상세주소">
			</div>
			</p>

			<div class="join">성별</div>
			<div class="join">
				<input type="radio" name="gender" value="man" checked="checked">남성
				<input type="radio" name="gender" value="woman">여성
			</div>


			<p class="join">
			<div for="birth">생년월일</div>
			<div>
				<input name="birth" id="birth" size="20" placeholder="예시)19991010"/>
			</div>
			<div id="invalid-birth"></div>
			</p>

			<p>
			<div class="join"></div>
			<div class="join">비밀번호 찾기 질문</div>
			<div class="join">
				<select name="pwInfo">
					<option value="pwInfo1">자신이 나온 초등학교는?</option>
					<option value="pwInfo2">자신이 살고 있는 동네는?</option>
				</select>
			</div>
			<div class="join">비밀번호 찾기 답</div>
			<div class="join">
				<input type="text" name="pwAns" size="40">
			</div>
			</p>

			<div><p>
				<label> <input type="checkbox" name="all" id="all">
					전체 동의
				</label>
			</p>
			</div>
			<div>
			<p>
				<label> <input type="checkbox" name="c1" id="c1"> <a
					href="#">Nbio 이용약관 동의</a> (필수)
				</label>
			</p>
			</div>
			<div>
			<p>
				<label> <input type="checkbox" name="c2" id="c2"> <a
					href="#">개인정보 수집 및 이용에 대한 안내</a> (필수)
				</label>
			</p>
			</div>
			<div>
			<p>
				<label> <input type="checkbox" name="c3" id="c3"> <a
					href="#">위치정보 이용약관 동의</a> (선택)
				</label>
			</p>
			</div>
			<div class="join">
				<!-- <input type="button" class="finish" value="회원가입" id="regSumit"
					onclick="join()"> -->
				<input type="submit" class="finish" value="회원가입">
			</div>
		</form>
	</main>
		<footer>
		<%@ include file = "footer.jsp" %>
	</footer>
</body>
	<script>
	var doc = document; 
	var form1 = doc.getElementById('form1'); 
	var inputs = form1.getElementsByTagName('INPUT'); 
	var form1_data = {
		"c1": false, 
		"c2": false, 
		"c3": false
	}; 

	var c1 = doc.getElementById('c1'); 
	var c2 = doc.getElementById('c2'); 
	var c3 = doc.getElementById('c3'); 

	function checkboxListener() {
		form1_data[this.name] = this.checked; 

		if(this.checked) {
			// submit 할때 체크하지 않아 색이 변한 font 를 다시 원래 색으로 바꾸는 부분. 
			this.parentNode.style.color = "#000"; 
		}
	}


		c1.onclick = c2.onclick = c3.onclick = checkboxListener; 

		var all = doc.getElementById('all'); 

		all.onclick = function() {
			if (this.checked) {
				setCheckbox(form1_data, true); 
			} else {
				setCheckbox(form1_data, false); 
			}
		}; 


		function setCheckbox(obj, state) {
			for (var x in obj) {
				obj[x] = state; 

				for(var i = 0; i < inputs.length; i++) {
					if(inputs[i].type == "checkbox") {
						inputs[i].checked = state; 
					}
				}

			}
		}


	/*all.onclick = function() {
		if (this.checked) {
			for (var x in form1_data) {
				form1_data[x] = true; 
				for(var i = 0; i < inputs.length; i++) {
					if(inputs[i].type == "checkbox") {
						inputs[i].checked = true; 
					}
				}
			}
		} else {
			for (var x in form1_data) {
				form1_data[x] = false; 
				for(var i = 0; i < inputs.length; i++) {
					if(inputs[i].type == "checkbox") {
						inputs[i].checked = false; 
					}
				}
			}
		}
	}; */


	form1.onsubmit = function(e) {
		e.preventDefault(); // 서브밋 될때 화면이 깜빡이지 않게 방지

		if ( !form1_data['c1'] ) {
			alert('Nbio 이용약관 동의를 하지 않았습니다'); 
			c1.parentNode.style.color = 'red'; 
			return false; 
		}

		if ( !form1_data['c2'] ) {
			alert('개인정보 수집 및 이용에 대한 안내를 선택하지 않았습니다.'); 
			c2.parentNode.style.color = 'red'; 
			return false; 
		}

		this.submit(); 
	}; 
	

	/*  function join() {
		var regExpid = /^[a-z0-9]{4,20}$/;
		var regExppwd = /(?=.*\d)(?=.*[a-zA-ZS]).{8,16}/;
		var regExpname = /^[가-힣]+$/;
		var regExptel = /^\d{3}-\d{3,4}-\d{4}$/;

		var form = document.Join
		var id = form.id.value.trim();
		var pwd = form.pwd.value.trim();
		var name = form.id.value.trim();
		var mail = form.mail.value.trim();


	}  */
</script>

</html>