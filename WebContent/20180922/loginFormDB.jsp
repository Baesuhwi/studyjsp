<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-sclae=1.0"/>
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="loginProDB.jsp">
		<table>
			<tr>
				<td class="label"><label for="idt">아이디</label>
				<td class="content"><input id="idt" name="idt" type="text" size="20" required>
			<tr>
				<td class="label"><label for="passwd">비밀번호</label>
				<td class="content"><input id="passwd" name="passwd" type="password" size="20" required>
			<tr>
				<td><input type ="submit" value="전송">
		</table>
	</form>

</body>
</html>