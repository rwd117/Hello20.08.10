package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PCseatadd {
	//로그아웃시 자리가 다시 사용 가능으로 바뀜
	public static int Setting(String Seat) {

		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "123456";
		String sql = null;
		
		
		Connection con = null;
		PreparedStatement pst = null;
		
		int rs = 0;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			sql = "update PCse set pc_state=? where pc_code=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, "사용 가능");
			pst.setInt(2, Integer.parseInt(Seat));
			
			rs= pst.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}
