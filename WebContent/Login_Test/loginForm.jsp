<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/style.css"/>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script src="login.js"></script>

	<form action="" method="post">
		<label for="id">아이디</label>
		<input type="text" id="id" name="id" autofocus><br>
		<label for="passwd">비밀번호</label>
		<input type="password" id="passwd" name="passwd"><br>
		<button id="login">로그인</button>
		<button id="register">회원가입</button>
	</form>
