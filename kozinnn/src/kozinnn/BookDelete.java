package kozinnn;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookDelete  extends JInternalFrame implements ActionListener{

	private JFrame frame;
	private JTextField tf;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTable table;
	private JButton Btok, Btca, btn1, btn2, btn3, btn4,btnexit;

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
	
	String sqlTotal = "select * from book ";
	String sqlDeletec="delete from book where b_code=?";
	String sqlDeleten="delete from book where b_number=?";
	String sqlDeletet="delete from book where b_title=?";
	String sqlDeletena="delete from book where b_name=?";
	String sqlDeletej="delete from book where b_ju=?";
	private JButton btn5;
	
	
	public BookDelete() {
		initialize();
		dbcon();
		set();
		to();
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
	
	public void set() {
		tf.setEnabled(false);
		tf1.setEnabled(false);
		tf2.setEnabled(false);
		tf3.setEnabled(false);
		tf4.setEnabled(false);
		tf.setText("");
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
	}

	private void initialize() {
		this.getContentPane().setLayout(null);
		this.setTitle("Ã¥ ¼öÁ¤");

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

		Btok = new JButton("\uC0AD\uC81C");
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
		btn1.setBounds(293, 114, 84, 23);
		this.getContentPane().add(btn1);

		btn2 = new JButton("\uD65C\uC131\uD654");
		btn2.setBounds(293, 155, 84, 23);
		this.getContentPane().add(btn2);

		btn3 = new JButton("\uD65C\uC131\uD654");
		btn3.setBounds(293, 201, 84, 23);
		this.getContentPane().add(btn3);

		btn4 = new JButton("\uD65C\uC131\uD654");
		btn4.setBounds(293, 247, 84, 23);
		this.getContentPane().add(btn4);
		
		btn5 = new JButton("\uD65C\uC131\uD654");
		btn5.setBounds(293, 295, 84, 23);
		this.getContentPane().add(btn5);
		
		btnexit = new JButton("");
		btnexit.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\EXIT.GIF"));
		btnexit.setBounds(24, 10, 30, 23);
		this.getContentPane().add(btnexit);
		

		Btok.addActionListener(this);
		Btca.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btnexit.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
