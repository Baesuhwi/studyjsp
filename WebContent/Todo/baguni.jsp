<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, shop.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

		ArrayList<Product> ProductList =
				(ArrayList<Product>)session.getAttribute("aa");

	for( int i=0; i < ProductList.size(); i++){
		out.println(ProductList.get(i).getName());
	}
%>
</body>
</html>