package a20_09_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbctest1 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="system";
		String password="123456";
		String sql="select*from member";
		
		Class.forName(driver);//DB로딩 
		Connection con=DriverManager.getConnection(url,user,password);//연결 고리를 만들어서 DB에 접속하기 위함.
		Statement stmt=con.createStatement();//con을 이용하여 한가지의 틀을 만듬.
		ResultSet rs=stmt.executeQuery(sql);//stmt에 sql을 넣어서 실행.
		
		while(rs.next()) {//찍어낼때는 하나하나 다해야함.
		System.out.print(rs.getString(1)+"\t");
		System.out.print(rs.getString(2)+"\t");
		System.out.print(rs.getString(3)+"\t");
		System.out.print(rs.getString(4)+"\t");
		System.out.println(rs.getInt(5));
		}
	
	}
}
