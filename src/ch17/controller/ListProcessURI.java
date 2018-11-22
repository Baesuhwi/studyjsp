package ch17.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch17.model.MemberDBBean;

public class ListProcessURI implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//DBCP�� ������ �� ����� ������ ��� �޾ƿͼ�
		//ArrayList<MemberBean>����
		//request.setAttribute("members")�� ��
		//return"/ch17/list.jsp";
		
		MemberDBBean db = MemberDBBean.getInstance();
		request.setAttribute("members", db.getList());
		return "/ch17/list.jsp";
	}
}