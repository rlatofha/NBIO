<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

  <head>
  
  

    <title>Geocoding service</title>

    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet"
	
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    
    

    <meta charset="utf-8">
    
     <script>

        function initMap() {// 구글 맵에서의 최초 위치!

          var map = new google.maps.Map(document.getElementById('map'), {

            zoom: 16,

            center: {lat: 37.566535, lng: 126.97796919999996}

          });

          var geocoder = new google.maps.Geocoder();

 

          document.getElementById('submit').addEventListener('click', function() {

            geocodeAddress(geocoder, map);

          });

        }

 

        function geocodeAddress(geocoder, resultsMap) { // 찾고자 하는 정보  

          var address = document.getElementById('address').value;

          geocoder.geocode({'address': address}, function(results, status) {

            if (status === google.maps.GeocoderStatus.OK) {

              resultsMap.setCenter(results[0].geometry.location);

              var marker = new google.maps.Marker({

                map: resultsMap,

                position: results[0].geometry.location

              });

 

              document.getElementById('location_code').innerHTML = results[0].geometry.location;

            } else {

              alert('Geocode was not successful for the following reason: ' + status);

            }

          });

        }

    </script>

    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALmXZZNjkoJwGI63Uw-HiphRHSC9bY3hc&signed_in=true&callback=initMap"

        async defer></script>

 

  </head>

    

  <!-- 키 값을 입력 해야합니다. -->

 

  <body>
  
  <header>
<%@ include file = "header.jsp" %>
</header>
  

    <style>

      html, body {

        height: 700px;

        margin: 0;

        padding: 0;

      }

      #map {

        height: 700px;

      }

      #floating-panel {

      top: 10px;

      left: 25%;

      z-index: 5;

      background-color: #fff;

      padding: 5px;

      border: 1px solid #999;

      text-align: center;

      font-family: 'hanna','Roboto','sans-serif';

      line-height: 30px;

      padding-left: 10px;

      }

    </style>

 

 	

	<div class="container">
	<h1 style="color: #32CD32">마이 페이지</h1>
	<ul class="nav nav-tabs">

	<li class="tab-link current" date-tab="tab-1"><a href = "editinfo.do">회원정보수정</a></li>

	<li class="tab-link" date-tab="tab-2"><a href = "Questionlist.do">고객문의사항</a></li>

	<li class="tab-link" date-tab="tab-3"><a href = "addressSearch.jsp">배송지주소검색</a></li>

	<li class="tab-link" date-tab="tab-4"><a href = "CPurchase.do">구매목록조회</a></li>

	</ul>	
	
	<br>	
	
	<br>	
	
	<br>	
	
	<div id="tab-1" class="tab-content currunt"><h2>배송지 주소 수정사항 확인</h2>
	<br>
	<br>
	<br>
    <div id="floating-panel">

      <input id="address" type="textbox" value="서울">

      <input id="submit" type="button" value="배송지 검색"> 

    </div>    

    <div id="map"></div></div>	

</div>
 	

	<!-- <h2>배송지 주소 수정사항 확인</h2>
    <div id="floating-panel">

      <input id="address" type="textbox" value="서울">

      <input id="submit" type="button" value="배송지 검색"> 

 

    </div>    

 

    <div id="map"></div> -->

 

   <!--  <script>

        function initMap() {// 구글 맵에서의 최초 위치!

          var map = new google.maps.Map(document.getElementById('map'), {

            zoom: 16,

            center: {lat: 37.566535, lng: 126.97796919999996}

          });

          var geocoder = new google.maps.Geocoder();

 

          document.getElementById('submit').addEventListener('click', function() {

            geocodeAddress(geocoder, map);

          });

        }

 

        function geocodeAddress(geocoder, resultsMap) { // 찾고자 하는 정보  

          var address = document.getElementById('address').value;

          geocoder.geocode({'address': address}, function(results, status) {

            if (status === google.maps.GeocoderStatus.OK) {

              resultsMap.setCenter(results[0].geometry.location);

              var marker = new google.maps.Marker({

                map: resultsMap,

                position: results[0].geometry.location

              });

 

              document.getElementById('location_code').innerHTML = results[0].geometry.location;

            } else {

              alert('Geocode was not successful for the following reason: ' + status);

            }

          });

        }

    </script>

    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyALmXZZNjkoJwGI63Uw-HiphRHSC9bY3hc&signed_in=true&callback=initMap"

        async defer></script> -->

        

  

        

<footer class="contaniner-fluid text-center">
<%@ include file = "footer.jsp" %>
</footer>

  </body>

</html>