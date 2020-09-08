package a20_09_08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class exjdbc_select {

	public static void main(String[] args) {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="system";
		String password="123456";
		String sql="select * from member";
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//��ũ���� �־�� ������ ������� ���� �� ����. next�� ������ ���� �͸�.
			rs=st.executeQuery(sql);
			rs.absolute(2);//2��°��,previous�� �ϸ� ù��°���� ������
			/*rs.last();//->Ȯ��� ��� �߰�.�ؾ���,rs.previous()�� ��Ʈ,������ �� ������ �� �ҷ���.
*/			while(rs.previous()) {//last�� �����ΰ��� previous�� ������ ���� �ϳ���.
				System.out.print(rs.getString(1)+"  ");
				System.out.print(rs.getString(2)+"  ");
				System.out.print(rs.getString(3)+"  ");
				System.out.print(rs.getString(4)+"  ");
				System.out.println(rs.getInt(5));
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
