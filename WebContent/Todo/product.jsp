<%@ page import = "java.util.ArrayList, shop.Product" %>
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
	<c:if test="${empty productList }">
	  검색된 결과가 없습니다.
	</c:if>
	<c:if test="${!empty productList}">
			<c:forEach var="p" items="${productList}">
					${p.name} ${p.price}
			</c:forEach>
	</c:if>
	<%--
	<c:if test="${productList == null}">
		등록된 상품이 없습니다.
	</c:if>
	<c:if test="${productList != null}">
			<form action="ProductServlet" method="post">
				<c:forEach var="p" items="${ProductList}">
					<input type="checkbox" name="selected" value="${p.name}"/>
						${p.id},${p.name},${p.info},${p.price}<br>
				</c:forEach>
				<input type="submit" value="전송">
			</form>	
	</c:if>
	 --%>
</body>
</html>