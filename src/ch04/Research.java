package ch04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Research
 */
@WebServlet("/Research")
public class Research extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Research() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		
		
		
		String name = request.getParameter("id");
		String gender = request.getParameter("gender");
		String season[] = request.getParameterValues("season");
		String s = "";
		if(gender.equals("m")){
			gender = "남자";
		} else{
			gender = "여자";
		}
		
		if(season == null) {
			s = s+ "선택없음";
		}else{
			
			for(int i=0; i < season.length; i++) {
			if(season[i].equals("spring")) {
					s = s + "봄";
			}
			if(season[i].equals("summer")) {
					s = s + "여름";
			}
			if(season[i].equals("fall")) {
				s = s + "가을";
			}
			if(season[i].equals("winter")) 
				s = s + "겨울";
			
		}	
	  }
		
		System.out.println(gender);
		System.out.println(s);
		
		response.sendRedirect("researchTest.jsp?name="+ name + "&gender=" + gender + "&s="+ s);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
