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
	
	<!-- <c:set var="var" value="2" />-->
	<!--${var}  표현언어 : 변수 var 을 불러오는뜻 -->
	<!--${1+1}  계산 및 아니라 널체크 도 해줌 -->
	<!--${productList} <!-- 세션에 있는걸 불러올수 있다.? -->
	
	<h3>JSTL core 태그 예제 - if,choose,when,otherwise</h3>
	<c:set var="country" value="${'Korea'}"/>
	<c:if test="${country != null}">
	 	국가명 : <c:out value="${country}"/><br>
	 	<!-- 국가명 : ${country} 이것도 출력가능 -->
	</c:if>
	
	<c:choose>
		<c:when test="${country == 'Korea'}">
		<p><c:out value="${country}"/>의 겨울은  춥다.
		</c:when>
		<c:when test="${country == 'Canada'}">
		<p><c:out value="${country}"/>의 겨울은 매우 춥다.
		</c:when>
		<c:otherwise>
			<p>그외의 나라들의 겨울은 알수 없다.
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>