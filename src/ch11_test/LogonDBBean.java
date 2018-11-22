package ch11_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LogonDBBean {
	// LogonDBBean ���� ��ü ���� (�Ѱ��� ��ü�� �����ؼ� ����)
	private static LogonDBBean instance = new LogonDBBean();

	// LogonDBBean ��ü�� �����ϴ� �޼ҵ�
	public static LogonDBBean getInstance() {
		return instance;
	}

	private LogonDBBean() {
	}

	// Ŀ�ؼ� Ǯ���� Ŀ�ؼ� ��ü�� ���� �޼ҵ�
	private Connection getConnection() throws Exception {
	        Context initCtx = new InitialContext();
	        Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/TestDB");
	        return ds.getConnection();
	    }

	// ȸ������ ó��(registerPro.jsp)���� ����ϴ� �� ���ڵ� �߰� �޼ҵ�
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
	
	
	// �α��� �� ó��(loginPro.jsp) �������� ����� ���� ó�� ��
	// ȸ�� ���� ����/ Ż�� ����� ����(memberCheck.jsp)���� ����ϴ� �޼ҵ�
	
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
					x = 1;	// ��������
				else
					x = 0;	// ��й�ȣ Ʋ��
			}else	// �ش� ���̵� ������
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
	
	// ���̵� �ߺ� Ȯ��(confirmId.jsp)���� ���̵��� �ߺ� ���θ� Ȯ���ϴ� �޼ҵ�
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
				
			if(rs.next()) {	//���̵� ����
				x = 1;	//���� ���̵� ����
			}else
				x = -1;	//���� ���̵� ����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	           if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	           if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
		return x;
	}
	
	// ȸ�� ���� ���� ��(modifyForm.jsp)�� ���� ���� ���� ������ �������� �޼ҵ�
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
		
		
	// ȸ�� ���� ���� ó��(modifyPro.jsp)���� ȸ�� ���� ������ ó���ϴ� �޼ҵ�
	
	// ȸ�� Ż�� ó��(deletePro.jsp)���� ȸ�� ������ �����ϴ� �޼ҵ�
}
