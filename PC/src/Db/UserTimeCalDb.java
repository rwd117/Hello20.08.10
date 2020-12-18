package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTimeCalDb {
	public static boolean Setting(String ID, String TimeCheck, String Time) {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "123456";
		String sql = null;
		String sqlUpdate = null;
		String idCheck = "";
		String AllTime="";
		String Timesend="";
		
		boolean flag = false;

		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
					//Time가 실시간 timesend가 총 시간
			
					sql="select pm_Time from Pcme where Pm_id=?";
					pst=con.prepareStatement(sql);
					pst.setString(1, ID);
					rs =pst.executeQuery();
			
					while(rs.next()) {
						Timesend=rs.getString(1);
					}
					
					int idx = Timesend.indexOf(":");

					String hour = Timesend.substring(0, idx);
					String minute = Timesend.substring(idx + 1);

					// 지금 insert할 타임
					int idxx = Time.indexOf(":");

					String hours = Time.substring(0, idxx);
					String minutes = Time.substring(idxx + 1);
					
					int intminut;
					int inthour=0;
					
					int intmin=Integer.parseInt(minute);
					int intmins=Integer.parseInt(minutes);

					if(intmins>intmin) {
						intmin=intmin+60;
						inthour=inthour-1;		
					}
					
					intminut = intmin - intmins;
					//1분이랑 45분이면?
					
					String Allminutes = Integer.toString(intminut);

					inthour = inthour + Integer.parseInt(hour) - Integer.parseInt(hours);

					String Allhour = Integer.toString(inthour);

					AllTime = Allhour + ":" + Allminutes;

					sqlUpdate = "update Pcme set Pm_time=? where Pm_id=?";
					pst2 = con.prepareStatement(sqlUpdate);
					pst2.setString(1, AllTime);
					pst2.setString(2, ID);
					pst2.executeUpdate();
	
					flag = true;
			

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
