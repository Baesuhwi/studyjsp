<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script>
	$(document).ready(function(){
			$("#b1").click(function(){
				$("#b2").text($("p").text());
			});
			
			$("#b2").click(function(){
				$("#display").html("<img src='pung.jpg' border='0'/>");
			});
		});
</script>

</head>
<body>
	<p> 이미지 표시</p>
	<button id="b1">버튼레이블 변경</button>
	<div id="display"></div>
	<button id="b2">버튼</button>
</body>
</html>