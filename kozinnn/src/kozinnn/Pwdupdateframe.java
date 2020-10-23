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

public class Pwdupdateframe extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField tf;
	private JTextField tf1;
	private int mcode;
	private JButton btnG, btnC;

	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user = "system";
	private String pwd = "123456";

	private String sql = "update member1 set m_pwd=? where m_code=?";
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs;

	public Pwdupdateframe(int A) {
		mcode = A;
		initialize();
		dbcon();
		return;
	}

	public Pwdupdateframe() {
		
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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC218\uC815");
		lblNewLabel.setBounds(149, 56, 93, 15);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setBounds(61, 103, 97, 15);
		this.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_2.setBounds(61, 156, 97, 15);
		this.add(lblNewLabel_2);

		tf = new JTextField();
		tf.setBounds(170, 100, 116, 21);
		this.add(tf);
		tf.setColumns(10);

		tf1 = new JTextField();
		tf1.setBounds(170, 153, 116, 21);
		this.add(tf1);
		tf1.setColumns(10);

		btnG = new JButton("\uC218\uC815");
		btnG.setBounds(75, 208, 97, 23);
		this.add(btnG);

		btnC = new JButton("\uCDE8\uC18C");
		btnC.setBounds(242, 208, 97, 23);
		this.add(btnC);

		btnG.addActionListener(this);
		btnC.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnG)) {
			Goupdate();
		} else if (e.getSource().equals(btnC)) {
			this.setVisible(false);
			dispose();
		}
	}

	public void Goupdate() {
		String pwd = tf.getText();
		String pwd2 = tf1.getText();
		if (pwd.equals(pwd2)) {
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, pwd);
				pst.setInt(2, mcode);
				pst.executeUpdate();
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
			JOptionPane.showMessageDialog(null, "비밀 번호 변경 완료!");
			this.setVisible(false);
			
		}else if(!pwd.equals(pwd2)) {
			JOptionPane.showMessageDialog(null, "비밀번호를 한번 더 확인 해 주세요");
			return;
		
		}
	}

}
