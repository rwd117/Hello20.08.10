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
			//스크롤이 있어야 순서를 마음대로 찍을 수 있음. next는 무조건 다음 것만.
			rs=st.executeQuery(sql);
			rs.absolute(2);//2번째줄,previous를 하면 첫번째줄이 쓰여짐
			/*rs.last();//->확장된 명령 추가.해야함,rs.previous()와 세트,마지막 줄 제외한 다 불러냄.
*/			while(rs.previous()) {//last로 끝으로가서 previous로 이전의 것을 하나씩.
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
