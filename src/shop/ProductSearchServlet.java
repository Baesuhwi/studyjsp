package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/ProductSearchServlet")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("productSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("search");
		
		HttpSession session = request.getSession();
		session.setAttribute("productList", select(name));
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	
	private ArrayList<Product> select(String name){
		 	
			Connection conn = null;
		    PreparedStatement pstmt = null;
		    Context initCtx;
		    ResultSet rs = null;
		    ArrayList<Product> list = null;
		    Product p = null;
		    
		    try {
		    	initCtx = new InitialContext();
				Context envCtx = (Context) initCtx.lookup("java:comp/env");
			    DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
			    conn = ds.getConnection();
			    
			    list = new ArrayList<Product>();
			    
			    String sql = "select * from product where name LIKE ?";
			    pstmt = conn.prepareStatement(sql);
			    pstmt.setString(1, name+"%");
			    rs = pstmt.executeQuery();
			    
			    while(rs.next()) {
			    	p = new Product();
			    	p.setName(rs.getString("name"));
			    	p.setPrice(rs.getInt("price"));
			    	list.add(p);
			    }
			    
			    
		    } catch(Exception e) {
		    	System.out.println("¸Á");
		    }
		 return list;  
	}
	
	
	
	
	
	
	
	
	
}
