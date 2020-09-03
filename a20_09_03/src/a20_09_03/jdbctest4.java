package a20_09_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbctest4 {

	public static void main(String[] args) throws Exception {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="system";
		String password="123456";
		String sql="delete from member where code='1005'";
		
		Class.forName(driver);
		Connection cnt=DriverManager.getConnection(url,user,password);
		Statement stm=cnt.createStatement();
		int re=stm.executeUpdate(sql);
		
		if(re==1) System.out.println("d");
	}

}
