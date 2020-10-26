package kozinnn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JPanel implements ActionListener {

	private JMenuItem McodeSe, MnameSe;
	private JButton btnGo, btnCan, btnNew, btnCode, btnPwd;
	private JTextField tf;
	private JTextField tf1;
	private String mCode, mCodec, mPwd, mpd;
	private int mcode, mcodec, count = 0, cnt = 0;
	private boolean A = true;

	private String sql = "select m_code from member1 where m_code=?";
	private String sql2 = "select m_pwd from member1 where m_pwd=? and m_code=?";
	
	
	SearchCodeframe Sch;
	SearchPwdframe Sp;
	NewMemberframe nmf;

	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user = "system";
	private String pwd = "123456";

	Connection con;
	PreparedStatement pst;

	ResultSet rs, rst, rstt, rsttt;

	public Login() {
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

	public void initialize() {
		this.setLayout(null);
		this.setVisible(true);

		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778 \uD654\uBA74");
		lblNewLabel.setBounds(345, 118, 102, 23);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0 \uCF54\uB4DC");
		lblNewLabel_1.setBounds(220, 190, 64, 15);
		this.add(lblNewLabel_1);

		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setBounds(220, 248, 64, 15);
		this.add(label);

		btnGo = new JButton("\uC811\uC18D");
		btnGo.setBounds(247, 313, 95, 23);
		this.add(btnGo);

		btnCan = new JButton("\uCDE8\uC18C");
		btnCan.setBounds(432, 313, 85, 23);
		this.add(btnCan);

		tf = new JTextField();
		tf.setBounds(330, 187, 147, 21);
		this.add(tf);
		tf.setColumns(10);

		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(330, 245, 147, 21);
		this.add(tf1);

		btnNew = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNew.setBounds(555, 166, 109, 23);
		this.add(btnNew);

		btnCode = new JButton("\uCF54\uB4DC \uCC3E\uAE30");
		btnCode.setBounds(555, 215, 109, 23);
		this.add(btnCode);

		btnPwd = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnPwd.setBounds(555, 272, 126, 23);
		this.add(btnPwd);

		btnGo.addActionListener(this);
		btnCan.addActionListener(this);
		btnNew.addActionListener(this);
		btnCode.addActionListener(this);
		btnPwd.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnGo)) {
			Check();
			if (count == 2 && cnt == 2)
				Term();
		} else if (e.getSource().equals(btnCan)) {
			clearLogin();
		} else if (e.getSource().equals(btnNew)) {
			nmf = new NewMemberframe();
			nmf.setVisible(true);
			nmf.setBounds(100, 100, 500, 500);
		} else if (e.getSource().equals(btnCode)) {
			Sch = new SearchCodeframe();
			Sch.setVisible(true);
			Sch.setBounds(100, 100, 450, 300);
		} else if (e.getSource().equals(btnPwd)) {
			Sp = new SearchPwdframe();
			Sp.setVisible(true);
			Sp.setBounds(100, 100, 450, 300);
		}
	}

	public void clearLogin() {
		rs = null;
		rst = null;
		rstt = null;
		rsttt = null;
		tf.setText("");
		tf1.setText("");
	}

	public void Search() {
		String Code = tf.getText();
		System.out.println(Code);
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.valueOf(Code));
			rs = pst.executeQuery();
			while (rs.next()) {
				count = count + 1;
				mCode = rs.getString(1);
			}
			if (count != 1) {
				JOptionPane.showMessageDialog(null, "코드를 잘못 입력했습니다.");
				count = 0;
				cnt = 0;
				return;
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

	public void SearchCheck() {

		mcode = Integer.valueOf(mCode);
		System.out.println(mcode);
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, mcode);
			rstt = pst.executeQuery();
			while (rstt.next()) {
				count = count + 1;
				mCodec = rstt.getString(1);
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

	public void Search2() {// mPwd 결과값 저장
		String Pwd = tf1.getText();
		String Code = tf.getText();
		try {
			pst = con.prepareStatement(sql2);
			pst.setString(1, Pwd);
			pst.setInt(2, Integer.valueOf(Code));
			rst = pst.executeQuery();
			while (rst.next()) {
				cnt = cnt + 1;
				mPwd = rst.getString(1);
			}
			if (cnt != 1) {
				JOptionPane.showMessageDialog(null, "비밀번호를 잘못 입력했습니다.");
				count = 0;
				cnt = 0;
				return;
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

	public void Search2Check() {// mpd에 저장
		String Code = tf.getText();
		try {
			pst = con.prepareStatement(sql2);
			pst.setString(1, mPwd);
			pst.setInt(2, Integer.valueOf(Code));
			rsttt = pst.executeQuery();
			while (rsttt.next()) {
				mpd = rsttt.getString(1);
				cnt = cnt + 1;
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

	public void Term() {//

		// mCode->mcode, mCodec->mcodec,
		mcodec = Integer.valueOf(mCodec);

		String a = mpd;
		String b = mPwd;

		if ((mcodec == mcode) && (a.equals(b))) {
			count = 0;
			cnt = 0;
			A = false;
			if (mcodec >= 0 && mcodec < 1000) {
				main2 mbk=new main2(mcodec,a,A);
			} else if (mcodec >= 1000) {
				McodeSe.setVisible(false);
				MnameSe.setVisible(false);
			}
		} else if ((mcodec != mcode) || (!a.equals(b))) {
			System.out.println("?");
			if ((mcodec != mcode)) {
				JOptionPane.showMessageDialog(null, "코드를 잘못 입력했습니다.");
				count = 0;
				cnt = 0;
				return;
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호를 잘못 입력했습니다.");
				count = 0;
				cnt = 0;
				return;
			}
		}

	}

	public void Check() {
		if (tf.getText().equals("") && tf1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "코드와 비밀번호를 입력해주세요");
			return;
		} else if (tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "코드를 입력 해 주세요");
			return;
		} else if (tf1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력 해 주세요");
			return;
		} else {
			Search();
			if (count == 1)
				SearchCheck();
			Search2();
			Search2Check();
		}
	}

}
