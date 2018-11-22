<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.Timestamp" %>
	
	<% request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id="registerBean" class="ch08.bean.RegisterBean">
		<jsp:setProperty name="registerBean" property="*"/>
	</jsp:useBean>
    
    <% registerBean.setReg_date(new Timestamp(System.currentTimeMillis()));%>
	<table>
	  <tr>
	  	<td>아이디
	  	<td><jsp:getProperty name="registerBean" property="idt"/>
	  <tr>
	  	<td>비밀번호	
		<td><jsp:getProperty name="registerBean" property="passwd"/>
	  <tr>
	  	<td>이름
	  	<td><jsp:getProperty name="registerBean" property="name"/>
	  <tr>
	    <td>가입일
	    <td><jsp:getProperty name="registerBean" property="reg_date"/>	
	</table>
	</body>
</html>