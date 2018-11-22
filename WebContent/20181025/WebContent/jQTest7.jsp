<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery Ajax메소드 - $.post()</title>
<style>
#result {
	width: 200px;
	height: 200px;
	border: 5px double #6699FF;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
	
</script>
<script>
	$(document).ready(function() {
		$("b1").click(function() {
			$.post("process.jsp", {
				name : "kingdora",
				stus : "homebody"
			}, function(data, status) {
				if (status = "success")
					$("#result").html(data);
			});
		});
	});
</script>
</head>
<body>
	<button id = "b1">결과</button>
	<div id = "result"></div>
</body>
</html>
