package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class airconDAO {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	
	public void connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// localhost: Oracle DB�� ��ġ�� PC�� ip�ּ� ����
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pass = "hr";

		conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6.jar���� �Ǵ� driver��� Ȯ��!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB�������..");
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if(rs != null) {rs.close();}
			if (psmt != null) {psmt.close();}
			if (conn != null) {conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		public MemberDTO loginCheck(String email, String pw) {
			
		}
	}
}
