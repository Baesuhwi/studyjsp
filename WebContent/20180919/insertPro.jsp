<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-sclae=1.0"/>
<title>Insert title here</title>

</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	 <%@ page import="java.sql.*" %>
	<%
			String idt = request.getParameter("idt");
			String passwd = request.getParameter("passwd");
			String name = request.getParameter("name");
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			String str="";
			try {
				String url= "jdbc:mariadb://localhost:3306/test";
				String id = "root";
				String pw = "1234";
				

				
				Class.forName("org.mariadb.jdbc.Driver");
				conn = DriverManager.getConnection(url, id, pw);
				
				String sql = "insert into member values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,idt);
				pstmt.setString(2,name);
				pstmt.setString(3,passwd);
				pstmt.executeUpdate();
				
				out.println("member 테이블에 새로운 레코드를 추가했습니다.");
				
			}catch(Exception e) {
				
				out.println("멤버 테이블에 새로운 레코드를 추가에 실패했습니다."); 
			} finally {
				if(pstmt != null)
					try { pstmt.close();}catch(SQLException sqle){}
					if(conn != null)
						try { conn.close();}catch(SQLException sqle){}
					}
	%>

</body>
</html>