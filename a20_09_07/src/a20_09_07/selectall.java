package a20_09_07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class selectall {

	public static void main(String[] args) {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="system";
		String password="123456";
		String sql="select*	from member ";
		Connection con;
		PreparedStatement pst;
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		/*finally {
			try{
				con.close();
			pst.close();
			}catch(Exception e2) {
				
			}*/
		}
	}

