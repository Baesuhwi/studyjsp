package shop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import ch08.bean.TodoBean;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
	     session.setAttribute("ProductList", getList());
		 response.sendRedirect("product.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] a = request.getParameterValues("selected");
		
		ArrayList<Product> ProductList =
				(ArrayList<Product>)request.getSession().getAttribute("ProductList");
	
		ArrayList<Product> aa = new ArrayList<Product>();
		
		for(int i=0; i < ProductList.size(); i++) {
			for(int j=0; j < a.length; j++) {
			 if(ProductList.get(i).getName().equals(a[j])) {
					aa.add(ProductList.get(i));
			  } 
			}
		}
				
		request.getSession().setAttribute("aa",aa);
		response.sendRedirect("baguni.jsp");
	}

	   
	  private ArrayList<Product> getList(){
		   	
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    Context initCtx;
		    ResultSet rs = null;
		    
		    ArrayList<Product> list = null;
		    
		   try {
			
			initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
		    DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
		    conn = ds.getConnection();
		    
		    list = new ArrayList<>();
		    
		    String sql = "select * from product";
		    pstmt = conn.prepareStatement(sql);
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	Product p = new Product();
		    	p.setId(rs.getInt("id"));
		    	p.setInfo(rs.getString("info"));
		    	p.setName(rs.getString("name"));
		    	p.setPrice(rs.getInt("price"));
		    	list.add(p);
		    } 
		    
	         } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return list;
	   }
	   
	
}
