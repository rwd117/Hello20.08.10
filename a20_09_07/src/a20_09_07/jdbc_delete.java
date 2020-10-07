package a20_09_07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.swing.JInternalFrame;

public class jdbc_delete extends JInternalFrame implements ActionListener {

	public static void main(String[] args) {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="system";
		String password="123456";
		String sql="delete from member where id=? and pwd=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("id 입력");
		String id=sc.next();
		System.out.println("pwd 입력");
		String pwd=sc.next();
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement prt=con.prepareStatement(sql);
			prt.setString(1, id);
			prt.setString(2, pwd);
			
			int re=prt.executeUpdate();
			if(re==1) System.out.println("dd");
			
		}catch(Exception e){
				e.printStackTrace();}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
