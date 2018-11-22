<%@ page import = "java.util.ArrayList, ch08.bean.TodoBean" %>
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
<form action ="TodoServlet" method="post">
		해야 할 일을 추가하세요 <input type="text" name ="detail"><br>
		<input type = "submit"	value="추가하기"> 
<br>

	<c:if test="${todoList == null}">
	등록된게 없습니다.
	</c:if>
	<c:if test="${todoList != null}">
		<ul>
			<c:forEach var="p" items="${todoList}">
				<li> ${p.detail}<br>
			</c:forEach>
		</ul>
	</c:if>
	
	
	<%
		ArrayList<TodoBean> todoList =
		(ArrayList<TodoBean>)session.getAttribute("todoList");
		
		if(todoList != null){ 
			out.println("<ul>");
			for( int i=0; i < todoList.size(); i++){
				out.println("<li>");
				out.println(todoList.get(i).getDetail());
				out.println("</li>");
			}
			
		}
		%>
		
</form>
</body>
</html>