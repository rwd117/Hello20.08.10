package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberLoginDb {
	public static boolean Setting(String id,String pwd) {

		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "123456";
		String sql = null;
		String pwdCheck="";

		boolean flag = false;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select Pm_pwd from Pcme where Pm_id=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				pwdCheck=rs.getString("Pm_pwd");
			}
			
			if(pwdCheck.equals(pwd)) {
				flag=true;
				
			}else if(!pwdCheck.equals(pwd)){
				
				flag=false;
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

		return flag;
	}
}
