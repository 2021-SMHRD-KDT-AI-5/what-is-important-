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
			// localhost: Oracle DB가 설치된 PC의 ip주소 설정
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pass = "hr";

		conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6.jar파일 또는 driver경로 확인!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결실패..");
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
		}
	
////	public airconDTO Check(airconDTO aircon) {
//	
//		airconDTO aircon = null;
//	try {
//		//DB연결기능
//		connection();
//		// 쿼리 실행
//		String sql = "select * from aircon where product_madeBy=? and  product_madeBy=? and product_madeBy=? ";
//
//		psmt = conn.prepareStatement(sql);
//
//
//		rs = psmt.executeQuery();
//
//		if (rs.next()) {// select한 데이터가 있다면
//			String getEmail = rs.getString(1);
//			String getTel = rs.getString(3);
//			String getAddress = rs.getString(4);
//			
//			aircon = new airconDTO(product_num,  product_madeBy,  product_name,  product_type, 
//					product_year,  cool_scale, energy_rank,  counsum_E,  product_price );
//		}
//	
//
//	
//		}
	

}