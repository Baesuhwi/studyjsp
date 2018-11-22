<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width.initial-scale=1.0"/>
<title>Insert title here</title>
</head>
<body>

	<%String name = request.getParameter("name"); %>
	포함되는 페이지 includedTest.jsp 입니다. <p>
	<b><%=name%></b> 님 오셧구려..
	
	<hr>
</body>
</html>