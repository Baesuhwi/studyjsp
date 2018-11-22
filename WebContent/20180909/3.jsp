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
<%
	String name = (String)session.getAttribute("name");
	String gender = request.getParameter("gender");
	
	if(gender.equals("m")){
			gender = "man";
	} else {
		gender = "women";
	}
%>

	이름 : <%=name %>
	성별 : <%=gender %>
</body>
</html>