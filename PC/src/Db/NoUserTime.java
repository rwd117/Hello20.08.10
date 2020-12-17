package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoUserTime {

	public static String Setting(String Card, String name) {

		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "123456";
		String sql = null;
		String Time="";
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		boolean flag=false;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			sql = "select nm_Time from PCnome where nm_Carnum=?";;
			pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(Card));
			rs= pst.executeQuery();
			
			while(rs.next()) {
				Time=rs.getString(1);
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Time;
	}
}
