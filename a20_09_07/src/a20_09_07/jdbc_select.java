package a20_09_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbc_select {

	public static void main(String[] args) {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="system";
		String password="123456";
		String sql="select*	from member where id=? and pwd=?";
		Scanner sc=new Scanner(System.in);
		
		System.out.println("id 입력");
		String id=sc.next();
		
		System.out.println("pwd 입력");
		String pwd=sc.next();
		
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pwd);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString(1)+"  ");
				System.out.print(rs.getString(2)+"  ");
				System.out.print(rs.getString(3)+"  ");
				System.out.print(rs.getString(4)+"  ");
				System.out.println(rs.getString(5));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
