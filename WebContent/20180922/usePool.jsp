<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>Insert title here</title>
</head>
<body>
	<%@page import="java.sql.* , javax.sql.* , javax.naming.*" %>
	<table>
		<tr class="label">
		<td>아이디
		<td>비밀번호
		<td>이름
	<%
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
	
		try{
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
			conn = ds.getConnection();
			
			String sql ="select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String id= rs.getString("userid");
				String passwd=rs.getString("password");
				String name=rs.getString("username");
			
	%>
	
		<tr>
		<td><%=id%>
		<td><%=passwd%>
		<td><%=name %>
		<% } 
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null)
				try{rs.close();}catch(SQLException sqle){}
			if(pstmt != null)
				try{pstmt.close();}catch(SQLException sqle){}
			if(conn != null)
				try{conn.close();}catch(SQLException sqle){}
			}
	
				
				
			
	%>
	
	</table>
</body>
</html>