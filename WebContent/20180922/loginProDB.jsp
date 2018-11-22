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
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<%
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		String idt = (String)request.getParameter("idt");
		String password = (String)request.getParameter("passwd");
		
		try{
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
			conn = ds.getConnection();
			
			String sql ="select * from member where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idt);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(idt.equals(rs.getString("userid")) && password.equals("password")){
					out.println("웰컴");
				} else { out.println("비밀번호 틀림");} 
			}else { out.println("아이디 틀림");} 
			
		}catch(Exception e){
					out.println("dd");
			}finally{
				if(rs != null)
					try{rs.close();}catch(SQLException sqle){}
				if(pstmt != null)
					try{pstmt.close();}catch(SQLException sqle){}
				if(conn != null)
					try{conn.close();}catch(SQLException sqle){}
				}	
					
%>
</body>
</html>