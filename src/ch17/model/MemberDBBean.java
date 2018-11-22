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
	
	//MemberDBBean 전역 객체 생성 (한개의 객체만 생성해서 공유)
	private static MemberDBBean instance = new MemberDBBean();
	
	//MemberDBBean 객체를 리턴하는 메소드
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
		
        while (rs.next()) {//해당 아이디에 대한 레코드가 존재
				member = new Member();//데이터저장빈 객체생성
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
		return list;//데이터 저장빈 객체 member 리턴
    }
}

