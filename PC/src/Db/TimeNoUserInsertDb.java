package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TimeNoUserInsertDb {
	
	public static int Setting(String Card, String Time, String name) {

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
			
			sql = "insert into PCnome values(nm_seq1.nextval,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, Card);
			pst.setString(2, Time);
			pst.setString(3, name);
			
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
