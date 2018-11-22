<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List.do 입니다!</h1>
	<c:forEach var="m" items="${members }">
		${m.id }
		${m.passwd }
		${m.name }
		${m.reg_date }
		${m.address }
		${m.tel }<br>
	</c:forEach>
</body>
</html>