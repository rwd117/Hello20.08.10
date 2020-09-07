package a20_09_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jdbc_insert {

	public static void main(String[] args) {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="system";
		String password="123456";
		String sql="insert into member(code,name,id,pwd,age) values(?,?,?,?,?)";
		
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement prt=con.prepareStatement(sql);
			prt.setString(1, "1006");
			prt.setString(2, "¿ÃªÛ»£");
			prt.setString(3, "choi");
			prt.setString(4, "6666");
			prt.setInt(5, 20);
			int res=prt.executeUpdate();
			if(res==1) System.out.println("dd");
			else System.out.println("d");
		}catch(Exception e){
				e.printStackTrace();}
	}

}
