<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id="testBean" class="ch08.bean.TestBean">
		<jsp:setProperty name="testBean" property="id"/>
	</jsp:useBean>
		
		입력된 아이디:<jsp:getProperty name="testBean" property="id" />

</body>
</html>