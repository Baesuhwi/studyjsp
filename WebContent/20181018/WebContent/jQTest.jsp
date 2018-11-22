<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- p.227 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>Insert title here</title>
<style type="text/css">
	div#displayArea{
		width : 200px;
		height : 200px;
		border : 5px double #6699FF;
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script>
	$(document).ready(function(){
		$("button").click(function(){
			$("#displayArea").html("<img src='pung.jpg' border='0'/>");
			});
	});
</script>
</head>
<body>
		<div id="displayArea">이 곳의 내용이 변경</div>
		<button>표시</button>
</body>
</html>