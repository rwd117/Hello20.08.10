package kozinnn;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchPwdframe extends JFrame implements ActionListener {

	private JTextField tf;
	private JTextField tf1;
	private JButton btnS;
	private JButton btnC;
	private JLabel lblNewLabel_2;
	private String scode,icode;
	private int scd,icd;
	
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user = "system";
	private String pwd = "123456";
	
	private String sql="select m_code from member1 where m_code=? and m_name=?";
	
	Pwdupdateframe pwup;
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs;

	public SearchPwdframe() {
		initialize();
		dbcon();
	}

	public void dbcon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initialize() {
		this.setVisible(true);
		this.setTitle("비밀번호 수정");
		this.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("\uCF54\uB4DC");
		lblNewLabel.setBounds(65, 75, 57, 15);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setBounds(65, 127, 57, 15);
		this.add(lblNewLabel_1);

		tf = new JTextField();
		tf.setBounds(165, 72, 116, 21);
		this.add(tf);
		tf.setColumns(10);

		tf1 = new JTextField();
		tf1.setBounds(165, 124, 116, 21);
		this.add(tf1);
		tf1.setColumns(10);

		btnS = new JButton("\uD655\uC778");
		btnS.setBounds(65, 193, 97, 23);
		this.add(btnS);

		btnC = new JButton("\uCDE8\uC18C");
		btnC.setBounds(239, 193, 97, 23);
		this.add(btnC);

		lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		lblNewLabel_2.setBounds(148, 31, 103, 15);
		this.add(lblNewLabel_2);

		btnS.addActionListener(this);
		btnC.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnS)) {
			SearchPw();
			SearCheck();
			Term();
		}else if(e.getSource().equals(btnC)) {
			this.setVisible(false);
			dispose();
		}
	}
	
	public void SearchPw() {//입력한값 비교하는 거
		String code=tf.getText();
		String name=tf1.getText();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,Integer.valueOf(code));
			pst.setString(2, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				scode = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void SearCheck() {//scode를 입력하여 비교
		
		String name=tf1.getText();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,Integer.valueOf(scode));
			pst.setString(2, name);
			rs = pst.executeQuery();
			while (rs.next()) {
				icode = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void Term() {
		scd=Integer.valueOf(scode);
		icd=Integer.valueOf(icode);
		if(scd==icd) {
			pwup=new Pwdupdateframe(scd);
			pwup.setVisible(true);
			pwup.setBounds(100, 100, 450, 300);
		}if(scd!=icd) {
			JOptionPane.showMessageDialog(null, "코드 혹은 이름이 틀렸습니다.");
		}
	}
}
