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
		
		Class.forName(driver);//DB�ε� 
		Connection con=DriverManager.getConnection(url,user,password);//���� ���� ���� DB�� �����ϱ� ����.
		Statement stmt=con.createStatement();//con�� �̿��Ͽ� �Ѱ����� Ʋ�� ����.
		ResultSet rs=stmt.executeQuery(sql);//stmt�� sql�� �־ ����.
		
		while(rs.next()) {//������ �ϳ��ϳ� ���ؾ���.
		System.out.print(rs.getString(1)+"\t");
		System.out.print(rs.getString(2)+"\t");
		System.out.print(rs.getString(3)+"\t");
		System.out.print(rs.getString(4)+"\t");
		System.out.println(rs.getInt(5));
		}
	
	}
}
