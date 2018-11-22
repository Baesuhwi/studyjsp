<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-sclae=1.0"/>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr class="label">
			<td> 아이디
			<td> 이름
			<td> 비밀번호	
	<% 
	
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		try{
			String url= "jdbc:mariadb://localhost:3306/test";
			String id = "root";
			String pw = "1234";
			
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "select * from member";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				String idt = rs.getString("userid");
				String passwd = rs.getString("password");
				String name = rs.getString("username");
		%>
				<tr>
					<td><%=idt%>
					<td><%=name%>
					<td><%=passwd%>	
		<%    }
		} catch(Exception e){
			System.out.println("dd");
		} finally{
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