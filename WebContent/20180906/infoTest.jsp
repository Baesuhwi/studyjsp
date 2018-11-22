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
	String param = request.getParameter("age");
	int age = Integer.parseInt(param);
	String result;
	String[] test = {"a", "b", "c"};
	
	if(age >= 20) result ="성인";
	else result="미성년";
	
	request.setAttribute("result", result);// 첫번쨰 변수이름 두번째 자바 오브젝트타입 (이론적으로 자바에서 쓰는 모든 데이터를 보내는것이 가능)
	request.setAttribute("test", test);
	RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
	dispatcher.forward(request, response);
	
%>
</body>
</html>