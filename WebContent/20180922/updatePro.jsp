<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String idt = request.getParameter("idt");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	try {
		String url= "jdbc:mariadb://localhost:3306/test";
		String id = "root";
		String pw = "1234";

		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pw);
		
		String sql="select userid, password from member where userid=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,idt);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			String rId=rs.getString("userid");
			String rPasswd = rs.getString("password");
			
			if(idt.equals(rId) && passwd.equals(rPasswd)) {
				sql="update member set username=? where userid=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setString(2,idt);
				pstmt.executeUpdate();
				out.println("member 테이블의 레코드를 수정했습니다");
			}else
				out.println("패스워드가 틀렸습니다");
		} else 
			out.println("아이디가 틀렸습니다");
	} catch(Exception e){
		System.out.println("안대");
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