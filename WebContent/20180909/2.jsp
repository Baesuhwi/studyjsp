<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width.inital-scale=1.0"/>
<title>Insert title here</title>
</head>
<body>
	<%  String name = request.getParameter("name");
		session.setAttribute("name", name);
	%>
	<form action="3.jsp">
			남 <input type="radio" name="gender" value="m">
			여 <input type="radio" name="gender" value="f">
			<input type="submit" value="전송">
	</form>
</body>
</html>