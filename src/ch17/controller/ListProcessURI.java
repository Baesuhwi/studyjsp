package ch17.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch17.model.MemberDBBean;

public class ListProcessURI implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//DBCP로 접속한 뒤 사용자 정보를 모두 받아와서
		//ArrayList<MemberBean>으로
		//request.setAttribute("members")한 뒤
		//return"/ch17/list.jsp";
		
		MemberDBBean db = MemberDBBean.getInstance();
		request.setAttribute("members", db.getList());
		return "/ch17/list.jsp";
	}
}