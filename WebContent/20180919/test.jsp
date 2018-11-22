<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*"%>
	<%
		Connection con = null;
		ResultSet set = null;
		try {
			String url= "jdbc:mariadb://localhost:3306/test";
			String id = "root";
			String pw = "1234";
			PreparedStatement stmt = null;

			
			Class.forName("org.mariadb.jdbc.Driver");
			
			con = DriverManager.getConnection(url, id, pw);
			if(con != null)
			{
				out.println("MariaDB Connected<br>");
				stmt = con.prepareStatement("select * from member");
				set = stmt.executeQuery();
				while(set.next())
				{ out.println(set.getString(1)+"<br>"); }

				con.close();
			}
		}catch(Exception e) { out.print(e); }
	%>
</body>
</html>