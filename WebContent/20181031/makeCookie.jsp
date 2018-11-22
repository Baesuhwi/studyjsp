<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("id", "kingdora");	// Cookie("쿠키 이름", "쿠키 값")
		cookie.setMaxAge(60*2);
		response.addCookie(cookie);
		
		out.println("쿠키가 생성되었습니다.");
	%>
	
	<form action="useCookie.jsp" method="post">
		<table>
			<tr>
			<td><input type="submit" value="생성된 쿠키 확인">
		</table>
	</form>
</body>
</html>