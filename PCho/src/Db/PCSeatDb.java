package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PCSeatDb {
	// pc방 자리 사용중인것만 나타내기
	public static ArrayList<String> PCNum(String Seat[]) {

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
				if (no.equals("사용 중")) {
					no1.add(Seat[i]);
				}
			}

			if (no1.size() == 0) {
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

	// 로그아웃시 자리가 다시 사용 가능으로 바뀜
	public static int PCSeatAdd(String Seat) {

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

			rs = pst.executeUpdate();

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

	// 로그인시 자리가 사용 중으로 바뀜
	public static int PCSeatSub(String Seat) {

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
			pst.setString(1, "사용 중");
			pst.setInt(2, Integer.parseInt(Seat));

			rs = pst.executeUpdate();

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

	// pcse의 시트에 관환 정보를 다넣고? 사용중이냐 사용가능이냐를 구별.

	public static ArrayList<Integer> PCSeatAll() {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "123456";
		String sql = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs;

		ArrayList<Integer> it = new ArrayList<Integer>();

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			sql = "select pc_code from Pcse";

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				it.add(rs.getInt(1));
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

		return it;

	}

	public static ArrayList<Integer> PCSeatCheck(ArrayList<Integer> Pcseatall) {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "system";
		String password = "123456";
		String sql = null;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs;

		ArrayList<Integer> str = new ArrayList<Integer>();

		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, user, password);

			sql = "select pc_state from Pcse where pc_code=?";

			pst = con.prepareStatement(sql);
			// 자리를 검색하고 그 모든 자리를 하나하나 대입 그후 사용중이면 그에 해당하는 그 열을 특정 열에 저장한ㄷ.
			for (int i = 0; i < Pcseatall.size(); i++) {
				pst.setInt(1, Pcseatall.get(i));
				rs = pst.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("pc_state").equals("사용 중")) {
						str.add(Pcseatall.get(i));
					}
				}
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

		return str;

	}

}
