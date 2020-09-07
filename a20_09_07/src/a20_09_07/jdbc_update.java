package a20_09_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jdbc_update {

	public static void main(String[] args) {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="system";
		String password="123456";
		String sql="update member set pwd=? where id=?";
		Scanner sc=new Scanner(System.in);
		String pwd=sc.next();
		String id=sc.next();
		
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement prt=con.prepareStatement(sql);
			prt.setString(2, id);
			prt.setString(1, pwd);
			
			int res=prt.executeUpdate();
			if(res==1)System.out.println("d");
		}catch(Exception e){
				e.printStackTrace();}
	}
}


