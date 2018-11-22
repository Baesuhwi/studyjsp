<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="registerPro.jsp">
	 <table>
	    <tr>
	    	<td><label for="idt">아이디</label>
	    	<td><input id="idt" name="idt" type="text" size="20" maxlength="30" placeholder="example@kings.com" autofocus required>
	    <tr>
	      	<td><label for="passwd">비밀번호</label>
	      	<td><input id="passwd" name="passwd" type="password" size="20" placeholder="6~12자 숫자/문자" maxlength="12" required>
	    <tr>
	    	<td><label for="name">이름</label>
	    	<td><input id="name" name="name" type = "text" size="20" placeholder="킹도라" required>
	    <tr>
	       	<td><input type="submit" value="회원 가입">
	       		<input type="reset" value="다시작성">
	  </table>
	</form>
</body>
</html>