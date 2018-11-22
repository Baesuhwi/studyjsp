<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery 연습</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<!--
<style>
	div#displayImg{
		width:300px;
		height:350px;
		border:5px double #6699FF;
	}
</style>
-->
<script>
	$(document).ready(function(){
		$("#b1").click(function(){
			$("#b2").text($("p").text());
		});
		
		$("#b2").click(function(){
			$("#displayImg").html("<img src='pung.jpg'>");
		});
	});
</script>

</head>
<body>
	<p>이미지 표시</p>
	<button id="b1">버튼레이블 변경</button>
	<div id="displayImg"></div>
	<button id="b2">그냥 버튼</button>
</body>
</html>