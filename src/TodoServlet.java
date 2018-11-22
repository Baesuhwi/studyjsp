

import java.io.IOException;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import javax.sql.*;

import ch08.bean.TodoBean;

import java.util.ArrayList;

/**
 * Servlet implementation class TodoServlet
 */
@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
	   request.setCharacterEncoding("utf-8");
      HttpSession session = request.getSession();
      session.setAttribute("todoList", getList());
      response.sendRedirect("Todo.jsp");
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
	   request.setCharacterEncoding("utf-8");
	   String detail = request.getParameter("detail");
	   add(detail);
	  
	   HttpSession session = request.getSession();
	   session.setAttribute("todoList", getList());       
       response.sendRedirect("Todo.jsp"); 
   }
   
   private ArrayList<TodoBean> getList(){
      
      ArrayList<TodoBean> list = null;
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      Context initCtx;
      try {
         initCtx = new InitialContext();
         Context envCtx = (Context) initCtx.lookup("java:comp/env");
         DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
         conn = ds.getConnection();
         
         list = new ArrayList<>();
         
         String sql = "Select * from todo";
         pstmt=conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            TodoBean t = new TodoBean();
            t.setId(rs.getInt("todo_id"));
            t.setDetail(rs.getString("detail"));
            t.setDone(rs.getBoolean("done"));
            list.add(t);
         }

      } catch (NamingException | SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("fail");
      }
       return list;
   }
   
   private int add(String detail) {
	   	
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    int result = 0;
	    Context initCtx;
	    
	   try {
		
		initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
	    DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
	    conn = ds.getConnection();
	    
	    String sql = "insert into todo(detail) values(?)";
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1,detail);
        result = pstmt.executeUpdate();
         } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	  return result;
   }
   
   
}
