package a20_09_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdctest3 {

	public static void main(String[] args) throws Exception {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="system";
		String password="123456";
		String sql="Update member set pwd='9999' where code='1001'";
		
		Connection con=null;
		Statement stn=null;
		
		try{Class.forName(driver);
		con=DriverManager.getConnection(url,user,password);
		stn=con.createStatement();
		int re=stn.executeUpdate(sql);
		if(re==1) System.out.println("ddd");
		}
		catch(Exception e){
			e.printStackTrace();
			}
		finally {
			con.close();
		}
	}

}
