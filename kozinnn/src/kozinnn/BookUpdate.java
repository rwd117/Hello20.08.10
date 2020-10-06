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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookUpdate extends JInternalFrame implements ActionListener {

	private JFrame frame;
	private JTextField tf;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTable table;
	private JButton Btok, Btca, btn1, btn2, btn3, btn4;

	private final static int A = 0;
	private final static int B = 1;
	private final static int C = 2;
	private final static int D = 3;
	private final static int E = 4;
	private final static int F = 5;
	int cmd = A;

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "system";
	String password = "123456";

	Connection con = null;
	PreparedStatement pst = null;
	PreparedStatement pstmtto, pstmttosc;

	Bookmodel model;
	// b_code,b_number,b_title,b_name,b_ju,b_in
	String sqlUpdaten = "update book set b_number=?  where b_code=?";
	String sqlUpdatet = "update book set b_title=?  where b_code=?";
	String sqlUpdatena = "update book set b_name=?  where b_code=?";
	String sqlUpdatej = "update book set b_ju=?  where b_code=?";
	String sqlUpdatei=	"update book set b_in=?  where b_code=?";

	String sqlTotal = "select * from book ";
	private JLabel label_4;
	private JTextField tf5;
	private JButton btn5;
	private JLabel lblll;

	public BookUpdate() {
		initialize();
		set();
		dbcon();
		to();
	}

	public void set() {
		tf1.setEnabled(false);
		tf2.setEnabled(false);
		tf3.setEnabled(false);
		tf4.setEnabled(false);
		tf5.setEnabled(false);
		tf.setText("");
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
	}

	private void initialize() {
		this.getContentPane().setLayout(null);
		this.setTitle("책 수정");

		JLabel lblNewLabel = new JLabel("\uCC45 \uCF54\uB4DC");
		lblNewLabel.setBounds(24, 115, 88, 20);
		this.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("\uC885\uB958");
		label.setBounds(24, 156, 88, 20);
		this.getContentPane().add(label);

		JLabel label_1 = new JLabel("\uC81C\uBAA9");
		label_1.setBounds(24, 202, 88, 20);
		this.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\uC791\uAC00 \uC774\uB984");
		label_2.setBounds(24, 248, 88, 20);
		this.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\uCD9C\uD310\uC0AC");
		label_3.setBounds(24, 296, 88, 20);
		this.getContentPane().add(label_3);

		tf = new JTextField();
		tf.setBounds(124, 115, 157, 21);
		this.getContentPane().add(tf);
		tf.setColumns(10);

		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(124, 156, 157, 21);
		this.getContentPane().add(tf1);

		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(124, 202, 157, 21);
		this.getContentPane().add(tf2);

		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(124, 248, 157, 21);
		this.getContentPane().add(tf3);

		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(124, 296, 157, 21);
		this.getContentPane().add(tf4);

		Btok = new JButton("\uCD94\uAC00");
		Btok.setBounds(72, 393, 116, 23);
		this.getContentPane().add(Btok);

		Btca = new JButton("\uCDE8\uC18C");
		Btca.setBounds(213, 393, 116, 23);
		this.getContentPane().add(Btca);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(389, 30, 339, 386);
		this.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btn1 = new JButton("\uD65C\uC131\uD654");
		btn1.setBounds(293, 155, 84, 23);
		this.getContentPane().add(btn1);

		btn2 = new JButton("\uD65C\uC131\uD654");
		btn2.setBounds(293, 201, 84, 23);
		this.getContentPane().add(btn2);

		btn3 = new JButton("\uD65C\uC131\uD654");
		btn3.setBounds(293, 247, 84, 23);
		this.getContentPane().add(btn3);

		btn4 = new JButton("\uD65C\uC131\uD654");
		btn4.setBounds(293, 295, 84, 23);
		this.getContentPane().add(btn4);
		
		label_4 = new JLabel("\uB4F1\uB85D\uB0A0\uC9DC");
		label_4.setBounds(24, 337, 88, 20);
		getContentPane().add(label_4);
		
		tf5 = new JTextField();
		tf5.setEnabled(false);
		tf5.setColumns(10);
		tf5.setBounds(124, 337, 157, 21);
		getContentPane().add(tf5);
		
		btn5 = new JButton("\uD65C\uC131\uD654");
		btn5.setBounds(293, 336, 84, 23);
		getContentPane().add(btn5);
		
		lblll = new JLabel("\uD65C\uC131\uD654 \uBC84\uD2BC \uD558\uB098\uB97C \uB20C\uB7EC \uC8FC\uC138\uC694 (\uBCF5\uC218 \uBD88\uAC00)");
		lblll.setBounds(24, 30, 325, 43);
		getContentPane().add(lblll);

		Btok.addActionListener(this);
		Btca.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
	}

	public void dbcon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void to() {
		try {
			pstmttosc = con.prepareStatement(sqlTotal, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmtto = con.prepareStatement(sqlTotal);

			ResultSet rsscroll = pstmttosc.executeQuery();
			ResultSet rs = pstmtto.executeQuery();

			if (model == null)
				model = new Bookmodel();
			model.getRowCount(rsscroll);
			model.setData(rs);
			table.setModel(model);
			table.updateUI();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmtto.close();
				pstmttosc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(Btok)) {
			if (cmd == A) {
				bpla();
				to();
			} else if (cmd == B) {
				bplb();
				to();
			} else if (cmd == C) {
				bplc();
				to();
			} else if (cmd == D) {
				bpld();
				to();
			} else if (cmd == E) {
				bple();
				to();
			} else if (cmd == F) {
				bplf();
				to();
			}
		} else if (e.getSource().equals(Btca)) {
			set();
		} else if (e.getSource().equals(btn1)) {
			if(cmd==B) {
				tf1.setEnabled(false);
				cmd=A;
				return;
			}
			tb1();
			cmd = B;
			
		} else if (e.getSource().equals(btn2)) {
			if(cmd==C) {
				tf2.setEnabled(false);
				cmd=A;
				return;
			}
			tb2();
			cmd = C;
		} else if (e.getSource().equals(btn3)) {
			if(cmd==D) {
				tf3.setEnabled(false);
				cmd=A;
				return;
			}
			tb3();
			cmd = D;
		} else if (e.getSource().equals(btn4)) {
			if(cmd==E) {
				tf4.setEnabled(false);
				cmd=A;
				return;
			}
			tb4();
			cmd = E;
		} else if(e.getSource().equals(btn5)) {
			if(cmd==F) {
				tf5.setEnabled(false);
				cmd=A;
				return;
			}
			tb5();
			cmd=F;
		}
	}

	public void tb1() {
		tf1.setEnabled(true);
		tf2.setEnabled(false);
		tf3.setEnabled(false);
		tf4.setEnabled(false);
		tf5.setEnabled(false);
	}

	public void tb2() {
		tf2.setEnabled(true);
		tf1.setEnabled(false);
		tf3.setEnabled(false);
		tf4.setEnabled(false);
		tf5.setEnabled(false);
	}

	public void tb3() {
		tf3.setEnabled(true);
		tf2.setEnabled(false);
		tf1.setEnabled(false);
		tf4.setEnabled(false);
		tf5.setEnabled(false);
	}

	public void tb4() {
		tf4.setEnabled(true);
		tf2.setEnabled(false);
		tf1.setEnabled(false);
		tf3.setEnabled(false);
		tf5.setEnabled(false);
	}

	public void tb5() {
		tf1.setEnabled(false);
		tf2.setEnabled(false);
		tf3.setEnabled(false);
		tf4.setEnabled(false);
		tf5.setEnabled(true);
	}
	
	public void bpla() {
		// b_code,b_number,b_title,b_name,b_ju,b_in
		lblll.setText("활성화 버튼을 눌러주세요. 하나만 수정 가능 합니다.");
	}

	public void bplb() {
		// b_code,b_number,b_title,b_name,b_ju,b_in
		String code = tf.getText();
		String number = tf1.getText();
		
		try {

			pst = con.prepareStatement(sqlUpdaten);
			pst.setString(2, code);
			pst.setString(1, number);
			int res = pst.executeUpdate();

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

	public void bplc() {
		// b_code,b_number,b_title,b_name,b_ju,b_in
		String code = tf.getText();
		String title = tf2.getText();
		
		try {

			pst = con.prepareStatement(sqlUpdatet);
			pst.setString(2, code);
			pst.setString(1, title);
			int res = pst.executeUpdate();

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

	public void bpld() {
		// b_code,b_number,b_title,b_name,b_ju,b_in
		String code = tf.getText();
		String name= tf3.getText();
		
		try {

			pst = con.prepareStatement(sqlUpdatena);
			pst.setString(2, code);
			pst.setString(1, name);
			int res = pst.executeUpdate();

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

	public void bple() {
		// b_code,b_number,b_title,b_name,b_ju,b_in
		String code = tf.getText();
		String ju= tf4.getText();
		
		try {

			pst = con.prepareStatement(sqlUpdatej);
			pst.setString(2, code);
			pst.setString(1, ju);
			int res = pst.executeUpdate();

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

	public void bplf() {
		String code = tf.getText();
		String in= tf5.getText();
		
		try {

			pst = con.prepareStatement(sqlUpdatei);
			pst.setString(2, code);
			pst.setString(1, in);
			int res = pst.executeUpdate();

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
