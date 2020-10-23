package kozinnn;

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

public class SearchCodeframe extends JFrame implements ActionListener{

	private JFrame frame;
	private JTextField tf;
	private JTextField tf1;
	private JButton btnS,btnC;
	private String code;
	

	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user = "system";
	private String pwd = "123456";
	
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs;
	
	private String sql="select m_code from member1 where m_name=? and m_phone=?";
	
	public SearchCodeframe() {
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
		this.setTitle("Code 찾기");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(52, 67, 93, 15);
		this.add(lblNewLabel);
		
		tf = new JTextField();
		tf.setBounds(179, 64, 146, 21);
		this.add(tf);
		tf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_1.setBounds(52, 116, 57, 15);
		this.add(lblNewLabel_1);
		
		tf1 = new JTextField();
		tf1.setBounds(179, 113, 146, 21);
		this.add(tf1);
		tf1.setColumns(10);
		
		btnS = new JButton("\uCC3E\uAE30");
		btnS.setBounds(79, 186, 97, 23);
		this.add(btnS);
		
		btnC = new JButton("\uCDE8\uC18C");
		btnC.setBounds(230, 186, 97, 23);
		this.add(btnC);
		
		btnS.addActionListener(this);
		btnC.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnS)) {
			Search();
			Result();
		}else if(e.getSource().equals(btnC)) {
			this.setVisible(false);
		}
	}
	
	public void Search() {
		String name=tf.getText();
		String phone=tf1.getText();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, phone);
			rs = pst.executeQuery();
			while (rs.next()) {
				code = rs.getString(1);
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
	
	public void Result() {
		if(code==null) {
			JOptionPane.showMessageDialog(null, "이름 혹은 전화번호를 확인 해주세요");
			return;
		}else {
			JOptionPane.showMessageDialog(null, "회원님의 코드 번호는"+code+"입니다.");
			return;
		}
	}
}
