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
 <style type="text/css">
        /* Set the size of the div element that contains the map */
        #map {
            height: 400px;
            /* The height is 400 pixels */
            width: 100%;
            /* The width is the width of the web page */
        }
    </style>
    <script>
    // 구글 맵에 내가 위치 하고 싶은 마커 
        function initMap() {

            const map = new google.maps.Map(document.getElementById("map"), {
                zoom: 14,
                center: { lat: 37.5016976, lng: 127.025265 }, // 현재 내가 보여주고 싶은 위치 
            });

            for (var i = 0; i < locations.length; i++) {
                var marker = new google.maps.Marker({
                    map: map,
                    label: locations[i].place,
                    position: new google.maps.LatLng(locations[i].lat, locations[i].lng),
                });
            }
        }
    	// 내가 표시해주고 싶은 내용  
        const locations = [
            { place:"Nbio", lat: 37.5016976, lng: 127.025265 }
            //{ place:"어린이대공원역", lat: 37.547263, lng: 127.074181 },
        ];

    </script>
</head>

<body>
<header>
<%@ include file = "header.jsp" %>
</header>

<div class="container">
<h1 style="color: #32CD32">회사 정보</h1>
<ul class="nav nav-tabs">

	<li class="tab-link current" date-tab="tab-1"></li>

	</ul>	
	
	<br>	
	
	<div id="tab-1" class="tab-content currunt">
	
	<h3>Nbio 찾아오시는 길</h3>
    <!--The div element for the map -->
    <div id="map"></div>

    <!-- Async script executes immediately and must be after any DOM elements used in callback. -->
    <!-- key=(인증받은 키 값 입력) -->
    <script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALmXZZNjkoJwGI63Uw-HiphRHSC9bY3hc&callback=initMap&libraries=&v=weekly"
        async></script>
    <li>서울특별시 서초구 서초동 1305 서산빌딩 5층</li>
    <li>Tel: +82 2556 5611</li>
    <li>9호선 신논현역 6번출구 방향 도보 5분</li>
    <li>2호선 강남역 10번 출구 방향 도보 10분</li>
	
	</div>	

</div>



   <!--  <h3>Nbio 찾아오시는 길</h3>
    The div element for the map
    <div id="map"></div>

    Async script executes immediately and must be after any DOM elements used in callback.
    key=(인증받은 키 값 입력)
    <script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALmXZZNjkoJwGI63Uw-HiphRHSC9bY3hc&callback=initMap&libraries=&v=weekly"
        async></script>
    <li>서울특별시 서초구 서초동 1305 서산빌딩 5층</li>
    <li>Tel: +82 2556 5611</li>
    <li>9호선 신논현역 6번출구 방향 도보 5분</li>
    <li>2호선 강남역 10번 출구 방향 도보 10분</li> -->
        
    <footer>
		<%@ include file = "footer.jsp" %>
	</footer>
</body>
</html>