package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cardsub {
	public static int Setting(String Card) {

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
			
			sql = "update PCca set c_state=? where c_code=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, "»ç¿ë Áß");
			pst.setInt(2, Integer.parseInt(Card));
			
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
