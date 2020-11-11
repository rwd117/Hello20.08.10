package kozinnn;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class mainbook implements ActionListener {
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenuItem btin, btex, btup, btde, btsena, btsema, btnpublish;
	private JMenuItem btnReturn, btnCheckout, delbtn;
	private JMenuItem McodeSe, MnameSe;
	private JMenu mn, mn1, mn2, mn3, mn4;
	private JPanel pan, panel;
	private JButton btnGo, btnCan, btnNew, btnCode, btnPwd;
	private JTextField tf;
	private JTextField tf1;
	private String mCode, mCodec, mPwd, mpd;
	private int mcode, mcodec, count = 0, cnt = 0;
	private boolean A = true;

	SearchCodeframe Sch; 
	SearchPwdframe Sp;
	NewMemberframe nmf;

/*	private Dimension dim;*/
	private Container container;

	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user = "system";
	private String pwd = "123456";

	private String sql = "select m_code from member2 where m_code=?";
	private String sql2 = "select m_pwd from member2 where m_pwd=? and m_code=?";

	Connection con;
	PreparedStatement pst;

	ResultSet rs, rst, rstt, rsttt;
	private JMenuItem btnLog;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainbook window = new mainbook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mainbook() {
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
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	/*	int width = screenSize.width / 2;
		int height = screenSize.height / 2;*/
		int x = screenSize.width / 4;
		int y = screenSize.height / 4;
		frame.setBounds(x, y, 833, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				if (pan != null) {
					pan.setBounds(0, 0, frame.getWidth(), frame.getHeight());
				}
			}
		});
		container = frame.getContentPane();
		container.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 10, 833, 540);
		frame.getContentPane().add(panel);
		panel.setVisible(true);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778 \uD654\uBA74");
		lblNewLabel.setBounds(345, 118, 102, 23);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0 \uCF54\uB4DC");
		lblNewLabel_1.setBounds(220, 190, 64, 15);
		panel.add(lblNewLabel_1);

		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setBounds(220, 248, 64, 15);
		panel.add(label);

		btnGo = new JButton("\uC811\uC18D");
		btnGo.setBounds(247, 313, 95, 23);
		panel.add(btnGo);

		btnCan = new JButton("\uCDE8\uC18C");
		btnCan.setBounds(432, 313, 85, 23);
		panel.add(btnCan);

		tf = new JTextField();
		tf.setBounds(330, 187, 147, 21);
		panel.add(tf);
		tf.setColumns(10);

		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(330, 245, 147, 21);
		panel.add(tf1);

		btnNew = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNew.setBounds(555, 166, 109, 23);
		panel.add(btnNew);

		btnCode = new JButton("\uCF54\uB4DC \uCC3E\uAE30");
		btnCode.setBounds(555, 215, 109, 23);
		panel.add(btnCode);

		btnPwd = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnPwd.setBounds(555, 272, 126, 23);
		panel.add(btnPwd);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 361, 21);
		frame.setJMenuBar(menuBar);
		menuBar.setVisible(false);

		mn = new JMenu("\uC2DC\uC2A4\uD15C");
		menuBar.add(mn);

		btnLog = new JMenuItem("\uB85C\uADF8\uC544\uC6C3");
		mn.add(btnLog);

		btex = new JMenuItem("\uC885\uB8CC");
		mn.add(btex);

		mn1 = new JMenu("\uAC80\uC0C9");
		menuBar.add(mn1);

		btsena = new JMenuItem("\uCC45 \uC81C\uBAA9 \uAC80\uC0C9");
		mn1.add(btsena);

		btsema = new JMenuItem("\uC791\uAC00 \uAC80\uC0C9");
		mn1.add(btsema);

		btnpublish = new JMenuItem("출판사 검색");
		mn1.add(btnpublish);

		McodeSe = new JMenuItem("\uD68C\uC6D0 \uBC88\uD638 \uAC80\uC0C9");
		mn1.add(McodeSe);

		MnameSe = new JMenuItem("\uD68C\uC6D0 \uC774\uB984 \uAC80\uC0C9");
		mn1.add(MnameSe);

		mn2 = new JMenu("\uD68C\uC6D0 \uAD00\uB9AC");
		menuBar.add(mn2);

		delbtn = new JMenuItem("\uD68C\uC6D0 \uC0AD\uC81C");
		mn2.add(delbtn);
		delbtn.addActionListener(this);

		mn3 = new JMenu("\uCC45 \uCD94\uAC00/\uC218\uC815/\uC0AD\uC81C");
		menuBar.add(mn3);

		btin = new JMenuItem("\uCD94\uAC00");
		mn3.add(btin);

		btup = new JMenuItem("\uC218\uC815");
		mn3.add(btup);

		btde = new JMenuItem("\uC0AD\uC81C");
		mn3.add(btde);

		mn4 = new JMenu("\uB300\uCD9C/\uBC18\uB0A9");
		menuBar.add(mn4);

		btnCheckout = new JMenuItem("\uB300\uCD9C");
		mn4.add(btnCheckout);

		btnReturn = new JMenuItem("\uBC18\uB0A9");
		mn4.add(btnReturn);

		btex.addActionListener(this);
		btsena.addActionListener(this);
		btsema.addActionListener(this);
		btnpublish.addActionListener(this);
		McodeSe.addActionListener(this);
		MnameSe.addActionListener(this);

		btnCheckout.addActionListener(this);
		btnReturn.addActionListener(this);

		btnGo.addActionListener(this);
		btnCan.addActionListener(this);
		btnNew.addActionListener(this);
		btnCode.addActionListener(this);
		btnPwd.addActionListener(this);
		btnLog.addActionListener(this);

		btin.addActionListener(this);
		btup.addActionListener(this);
		btde.addActionListener(this);
	}

	public void clear() {
		container.removeAll();
		container.setVisible(false);
		container.setVisible(true);
	}
	
	public void clearLogin() {
		rs = null;
		rst = null;
		rstt = null;
		rsttt = null;
		tf.setText("");
		tf1.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (A == true) {
			if (e.getSource().equals(btnGo)) {
				Check();
				if (count == 2 && cnt == 2)
					Term();
			} else if (e.getSource().equals(btnCan)) {
				clearLogin();
			} else if (e.getSource().equals(btnNew)) {
				nmf = new NewMemberframe();
				nmf.setVisible(true);
				nmf.setBounds(500, 300, 400, 450);
			} else if (e.getSource().equals(btnCode)) {
				Sch = new SearchCodeframe();
				Sch.setVisible(true);
				Sch.setBounds(500, 300, 450, 300);
			} else if (e.getSource().equals(btnPwd)) {
				Sp = new SearchPwdframe();
				Sp.setVisible(true);
				Sp.setBounds(500, 300, 450, 300);
			}
		} else if ((A == false)&&(!e.getSource().equals(btnLog))) {
			clear();
			if (e.getSource().equals(btex)) {
				System.exit(0);
			} else if (e.getSource().equals(btin)) {
				pan = new Bookinsert();
				// goInsert();//å �߰�
			} else if (e.getSource().equals(btup)) {
				pan = new BookUpdate();
				// goUpdate();//å ����
			} else if (e.getSource().equals(btde)) {
				pan = new BookDelete();
				// goDelete();//å ����
			} else if (e.getSource().equals(btsena)) {
				pan = new BookTitle();// å ���� �˻�
			} else if (e.getSource().equals(btsema)) {
				pan = new BookMan();
				// goMan();//�۰� �˻�
			} else if (e.getSource().equals(btnpublish)) {
				pan = new BookPublish();// ���ǻ� �˻�
			} else if (e.getSource().equals(McodeSe)) {
				pan = new MemberCode();// ȸ�� ��ȣ �˻�
			} else if (e.getSource().equals(MnameSe)) {
				pan = new MemberName();
				// goMname();//ȸ�� �̸� �˻�
			} else if (e.getSource().equals(btnReturn)) {
				pan = new BookReturn();// å �ݳ�
			} else if (e.getSource().equals(btnCheckout)) {
				pan = new BookCheckOut();
				// goCheckout();//å ����
			} else if (e.getSource().equals(delbtn)) {
				pan = new MemberDelete();// ȸ�� ����
			} 
			pan.setBounds(0, 0, frame.getWidth(), frame.getHeight());
			frame.getContentPane().add(pan);
		}else if ((A == false)&&(e.getSource().equals(btnLog))) {
			clear();
			clearLogin();
			panel.setVisible(true);
			panel.setBounds(12, 10, 833, 540);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			menuBar.setVisible(false);
			A=true;
			JOptionPane.showMessageDialog(null, "로그 아웃 되었습니다.");
		}
		
		
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

	public void Search2() {// mPwd ����� ����
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

	public void Search2Check() {// mpd�� ����
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
			panel.setVisible(false);
			count = 0;
			cnt = 0;
			A = false;
			menuBar.setVisible(true);
			if (mcodec >= 0 && mcodec<1000) {
				mn2.setVisible(true);
				mn3.setVisible(true);
				mn4.setVisible(true);
				McodeSe.setVisible(true);
				MnameSe.setVisible(true);
			} else if (mcodec >= 1000) {
				mn2.setVisible(false);
				mn3.setVisible(false);
				mn4.setVisible(false);
				McodeSe.setVisible(false);
				MnameSe.setVisible(false);
			}
		} else if ((mcodec != mcode) || (!a.equals(b))) {
			System.out.println("?");
			if ((mcodec != mcode)) {
				JOptionPane.showMessageDialog(null, "코드가 틀렸습니다.");
				count = 0;
				cnt = 0;
				return;
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
				count = 0;
				cnt = 0;
				return;
			}
		}

	}

	public void Check() {
		if (tf.getText().equals("") && tf1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "빈칸을 채워 주세요");
			return;
		} else if (tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "빈칸을 채워 주세요");
			return;
		} else if (tf1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "빈칸을 채워 주세요");
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