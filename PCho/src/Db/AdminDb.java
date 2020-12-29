package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class AdminDb {

	
	public static Vector<String> CardSearchDb() {
		//카드 숫자 읽어서 사용 중이면 제거하기 위한 db
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "123456";
		String sql = null;

		Vector<String> v = new Vector<String>();
		
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			sql = "select * from Pcca";

			pst = con.prepareStatement(sql);
			
			rs=pst.executeQuery();
			
			if(rs != null) {
				
				while(rs.next()) {
					
					String code=rs.getString("c_code");
					v.addElement(code);
					String state=rs.getString("c_state");
					v.addElement(state);
				}
				
			}else {
				
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
		return v;
	}
	
}
