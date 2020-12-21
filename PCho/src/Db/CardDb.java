package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardDb {
	
	public static ArrayList<String> CardNumDb(String Card[]) {
		//카드 숫자 읽어서 사용 중이면 제거하기 위한 db
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

			sql = "select c_state from Pcca where c_code=?";

			pst = con.prepareStatement(sql);

			for (int i = 1; i < Card.length; i++) {

				pst.setInt(1, Integer.parseInt(Card[i]));

				rs = pst.executeQuery();

				while (rs.next()) {
					no = rs.getString("c_state");
				}
				
				if (no.equals("사용 중")) {
					no1.add(Card[i]);
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

	public static int Cardadd(String Card) {
		//로그 아웃시 데이터 베이스 카드 사용 가능으로 수정
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
			pst.setString(1, "사용 가능");
			pst.setInt(2, Integer.parseInt(Card));

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

	public static int Cardsub(String Card) {
		//로그인시 해당 카드번호 사용 중으로 변환
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
			pst.setString(1, "사용 중");
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
