package kozinnn;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NewMemberframe extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField tf;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JButton btnGo, btnCa;
	private String name, phone, pwd, address, scode;
	private int icode;
	private boolean bln=false;
	

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "system";
	String password = "123456";

	Connection con = null;
	PreparedStatement pst = null;
	PreparedStatement pstmtto, pstmttosc;
	ResultSet rs;

	private String sql1 = "insert into member1(m_code,m_name,m_phone,m_pwd,m_address,m_amt,m_amount) values(no_seq2.nextval,?,?,?,?,3,3)";
	private String sql2 = "insert into member1(m_code,m_name,m_phone,m_pwd,m_amt,m_amount) values(no_seq2.nextval,?,?,?,3,3)";
	private String sqlS	= "select m_code from member1 order by m_code asc";
	public NewMemberframe() {
		initialize();
		dbcon();
	}

	public void dbcon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initialize() {
		this.setVisible(true);
		this.setTitle("회원가입");
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(62, 122, 77, 15);
		getContentPane().add(lblNewLabel);

		tf = new JTextField();
		tf.setBounds(194, 119, 116, 21);
		getContentPane().add(tf);
		tf.setColumns(10);

		JLabel label = new JLabel("\uC8FC\uC18C");
		label.setBounds(62, 297, 77, 15);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_1.setBounds(62, 180, 77, 15);
		getContentPane().add(label_1);

		JLabel label_4 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_4.setBounds(62, 237, 77, 15);
		getContentPane().add(label_4);

		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(194, 177, 116, 21);
		getContentPane().add(tf1);

		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(194, 234, 116, 21);
		getContentPane().add(tf2);

		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(194, 297, 116, 21);
		getContentPane().add(tf3);

		btnGo = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnGo.setBounds(61, 368, 97, 23);
		getContentPane().add(btnGo);

		btnCa = new JButton("\uCDE8\uC18C");
		btnCa.setBounds(213, 368, 97, 23);
		getContentPane().add(btnCa);

		JLabel lblNewLabel_1 = new JLabel(
				"\uC774\uB984 \uBE44\uBC00\uBC88\uD638 \uC804\uD654\uBC88\uD638 \uD544\uC218 \uC785\uB825");
		lblNewLabel_1.setBounds(76, 29, 214, 44);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("\uC804\uD654\uBC88\uD638'-' \uC81C\uC678");
		label_2.setBounds(114, 64, 214, 44);
		getContentPane().add(label_2);

		btnGo.addActionListener(this);
		btnCa.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnGo)) {
			Check();
		} else if (e.getSource().equals(btnCa)) {
			dispose();
		}
	}

	public void InsertGo() {
		name = tf.getText();
		phone = tf1.getText();
		pwd = tf2.getText();
		address = tf3.getText();
		if(name.equals("")||phone.equals("")||pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "이름, 전화번호, 비밀번호에 빈 칸이 있습니다.");
			return;
		}
		if(phone.contains("-")) {
			JOptionPane.showMessageDialog(null, "전화번호에 -가 있습니다.");
			bln=true;
			return;
		}
		try {
			pst = con.prepareStatement(sql1);
			pst.setString(1, name);
			pst.setString(2, phone);
			pst.setString(3, pwd);
			pst.setString(4, address);
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
	}

	public void InsertGo2() {
		name = tf.getText();
		phone = tf1.getText();
		pwd = tf2.getText();
		if(name.equals("")||phone.equals("")||pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "이름, 전화번호, 비밀번호에 빈 칸이 있습니다.");
			return;
		}
		if(phone.contains("-")) {
			JOptionPane.showMessageDialog(null, "전화번호에 -가 있습니다.");
			bln=true;
			return;
		}
		try {
			pst = con.prepareStatement(sql2);
			pst.setString(1, name);
			pst.setString(2, phone);
			pst.setString(3, pwd);
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
	}

	public void Check() {
		if(tf3.getText().equals("")||tf3.getText().equals(null)) {
			InsertGo2();
			if(bln==false) {
			CodeCheck();
			icode=Integer.valueOf(scode);
			JOptionPane.showMessageDialog(null, "회원가입이 되셨습니다. 고객님의 회원 코드는 "+icode+" 입니다.잊지 말아주세요");
			dispose();
			}
		}else {
			InsertGo();
			if(bln==false) {
			CodeCheck();
			icode=Integer.valueOf(scode);
			JOptionPane.showMessageDialog(null, "회원가입이 되셨습니다. 고객님의 회원 코드는 "+icode+" 입니다.잊지 말아주세요");
			dispose();
			}
		}
	}

	public void CodeCheck() {
		try {
			pst = con.prepareStatement(sqlS);
			rs=pst.executeQuery();
			while(rs.next()) {
				scode=rs.getString(1);
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
}
