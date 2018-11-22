<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
	
</script>

<script>
	$(document).ready(function() {
		$("p").mouseenter(function() {

			$(this).text("왔구려, 마우스포인터!!");
		});

		$("p").mouseleave(function() {
			$(this).text("돌아와 마우스포인터!!!");
		});

		$("button").dblclick(function() {
			$(this).css("background-color", "#FF0000");
		});
	});
</script>
</head>
<body>
	<p>마우스 포터인터를 여기에!!!</p>
	<button>더블 클릭 하세요</button>
</body>
</html>