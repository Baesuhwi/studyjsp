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

	<%request.setCharacterEncoding("utf-8"); %>
	<%
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		if(id.equals("kingdora") && pass.equals("1234"))
			session.setAttribute("id",id);
		
		response.sendRedirect("sessionTestForm.jsp");
	%>
</body>
</html>