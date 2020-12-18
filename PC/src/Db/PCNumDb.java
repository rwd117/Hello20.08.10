package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PCNumDb {
	//pc방 자리 사용중인것만 나타내기
	public static ArrayList<String> Setting(String Seat[]) {

		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "123456";
		String sql = null;

		String no = null;
		ArrayList<String> no1 = new ArrayList<String>();

		ResultSet rs;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			sql = "select pc_state from Pcse where pc_code=?";

			pst = con.prepareStatement(sql);

			for (int i = 1; i < Seat.length; i++) {

				pst.setInt(1, Integer.parseInt(Seat[i]));

				rs = pst.executeQuery();

				while (rs.next()) {
					no = rs.getString(1);
				}
				for (int j = 0; j < Seat.length; j++) {
					if (no.equals("사용 중")) {
						no1.add(Seat[i]);
					}
				}
			}
			
			if(no1.size()==0) {
				no1.add("전부 사용 가능합니다");
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

		return no1;
	}
}
