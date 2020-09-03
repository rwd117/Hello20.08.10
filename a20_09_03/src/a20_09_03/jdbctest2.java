package a20_09_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbctest2 {

	public static void main(String[] args) throws Exception {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="system";
		String password="123456";
		String sql="insert into member(code,name,id,pwd)"
		+"values('1005','¶ì¸®·Õ','choi','hoi')";
		
		Class.forName(driver);
		Connection cnt=DriverManager.getConnection(url,user,password);
		Statement stmt=cnt.createStatement();
		int re=stmt.executeUpdate(sql);
		
		if(re==1) System.out.println("d");
		
		
		
	}

}
