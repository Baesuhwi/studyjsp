package ch17.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ch11.logon.LogonDataBean;

public class MemberDBBean {
	
	//MemberDBBean ���� ��ü ���� (�Ѱ��� ��ü�� �����ؼ� ����)
	private static MemberDBBean instance = new MemberDBBean();
	
	//MemberDBBean ��ü�� �����ϴ� �޼ҵ�
	public static MemberDBBean getInstance() {
		return instance;
	}
	
	private MemberDBBean() {};
	
	private Connection getConnection() throws Exception {
        Context initCtx = new InitialContext();
        Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
        return ds.getConnection();
    }
	
	public ArrayList<Member> getList() {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Member member=null;
	
        ArrayList<Member> list = new ArrayList<Member>();
        try {
            conn = getConnection();
		
		pstmt = conn.prepareStatement("select * from member");
        rs = pstmt.executeQuery();
		
        while (rs.next()) {//�ش� ���̵� ���� ���ڵ尡 ����
				member = new Member();//����������� ��ü����
                  member.setId(rs.getString("id"));
				  member.setName(rs.getString("name"));
				  member.setPasswd(rs.getString("passwd"));
                  member.setReg_date(rs.getTimestamp("reg_date"));
                  member.setAddress(rs.getString("address"));
                  member.setTel(rs.getString("tel"));
                  list.add(member);
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return list;//������ ����� ��ü member ����
    }
}

