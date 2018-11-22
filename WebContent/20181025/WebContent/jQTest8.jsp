<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		$("#b1").click(function() {//결과버튼 클릭하면 자동 실행
			var query = {//요청 페이지에 전송할 데이터
				name : "kingdora",
				stus : "homebody"
			};
			$.ajax({//process.jsp 페이지에 요청 데이터를 보낸 후 결과를 반환받음
				type : "POST", //전송 방식
				url : "process.jsp", //요청 페이지
				data : query, //전송 데이터
				success : function(data) { //요청 페이지를 실행한 결과
					$("#result").html(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<button id="b1">결과</button>
	<div id="result"></div>
</body>
</html>