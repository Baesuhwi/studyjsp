package ch11_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LogonDBBean {
	// LogonDBBean 전역 객체 생성 (한개의 객체만 생성해서 공유)
	private static LogonDBBean instance = new LogonDBBean();

	// LogonDBBean 객체를 리턴하는 메소드
	public static LogonDBBean getInstance() {
		return instance;
	}

	private LogonDBBean() {
	}

	// 커넥션 풀에서 커넥션 객체를 얻어내는 메소드
	private Connection getConnection() throws Exception {
	        Context initCtx = new InitialContext();
	        Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
	        return ds.getConnection();
	    }

	// 회원가입 처리(registerPro.jsp)에서 사용하는 새 레코드 추가 메소드
	public void insertMember(LogonDataBean member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String orgPass = member.getPasswd();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, orgPass);
			pstmt.setString(3, member.getName());
			pstmt.setTimestamp(4, member.getReg_date());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getTel());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	}
	
	
	// 로그인 폼 처리(loginPro.jsp) 페이지의 사용자 인증 처리 및
	// 회원 정보 수정/ 탈퇴를 사용자 인증(memberCheck.jsp)에서 사용하는 메소드
	
	public int userCheck(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		
		try {
			conn = getConnection();
			
			String orgPass = passwd;
			
			pstmt = conn.prepareStatement("select passwd from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if(orgPass.equals(dbpasswd))
					x = 1;	// 인증성공
				else
					x = 0;	// 비밀번호 틀림
			}else	// 해당 아이디 없을때
				x = -1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}
	
	// 아이디 중복 확인(confirmId.jsp)에서 아이디의 중복 여부를 확인하는 메소드
	public int confirmId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
			
		try {
			conn = getConnection();
				
			pstmt = conn.prepareStatement("select id from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
				
			if(rs.next()) {	//아이디 존재
				x = 1;	//같은 아이디 있음
			}else
				x = -1;	//같은 아이디 없음
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	           if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	           if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}
	
	// 회원 정보 수정 폼(modifyForm.jsp)을 위한 기존 가입 정보를 가져오는 메소드
	public LogonDataBean getMember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LogonDataBean member = null;
		
		try {
			conn = getConnection();
			
			String orgPass = passwd;
			
			pstmt = conn.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if(orgPass.equals("dbpasswd")) {
					member = new LogonDataBean();
					member.setId(rs.getString("id"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
		
		
	// 회원 정보 수정 처리(modifyPro.jsp)에서 회원 정보 수정을 처리하는 메소드
	
	// 회원 탈퇴 처리(deletePro.jsp)에서 회원 정보를 삭제하는 메소드
}
