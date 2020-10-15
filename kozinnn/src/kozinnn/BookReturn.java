package kozinnn;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookReturn extends JInternalFrame implements ActionListener, Runnable {

	private JTable table;
	private JTextField tf2;
	private JButton btnReturn, btnex, btnSearch,btnmcode;
	private String Date,bamount, bamt;
	private int year, month, date, amount, amt;
	private final static int A=0;
	private final static int B=0;
	int cmd=0;
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "system";
	String password = "123456";

	Connection con = null;
	PreparedStatement pst = null;
	PreparedStatement pstmtto, pstmttosc;
	ResultSet rst, rstt, rs;

	CheckModel model;

	String sqlUpdate = "update checkout set	c_curr='반납',c_dday=? where c_bcode=? and c_mcode=?";
	String sqlSearch = "select * from checkout where c_curr='반납' order by c_code asc";

	String sqlbamount = "select b_amount from book where b_code=?";
	String sqlbamt = "select b_amt from book where b_code=?";

	String sqlbupdate = "update book set b_amount=b_amount+1 where b_code=?";

	String sqlTotal = "select * from checkout where c_curr='대출 중' order by c_code asc";

	String sqlSear = "select * from checkout where c_curr='대출 중' and c_bcode like'%";
	String sql;
	private JTextField tf1;

	public BookReturn() {
		initialize();
		dbcon();
		clear();
		to();
	}

	private void initialize() {
		this.getContentPane().setLayout(null);
		this.setTitle("책 반납");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 185, 651, 254);
		this.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("\uCC45 \uCF54\uB4DC");
		label.setBounds(127, 124, 57, 15);
		this.getContentPane().add(label);

		tf2 = new JTextField();
		tf2.setBounds(196, 121, 274, 21);
		this.getContentPane().add(tf2);
		tf2.setColumns(10);

		btnReturn = new JButton("\uBC18\uB0A9");
		btnReturn.setBounds(373, 152, 97, 23);
		this.getContentPane().add(btnReturn);

		btnex = new JButton("");
		btnex.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\EXIT.GIF"));
		btnex.setBounds(33, 24, 40, 23);
		this.getContentPane().add(btnex);

		JLabel lblNewLabel_1 = new JLabel("\uAC80\uC0C9\uC740 \uCC45 \uCF54\uB4DC, \uBC18\uB0A9\uC740 \uD68C\uC6D0,\uCC45 \uCF54\uB4DC \uB458 \uB2E4");
		lblNewLabel_1.setBounds(194, 24, 276, 34);
		this.getContentPane().add(lblNewLabel_1);

		btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setBounds(197, 152, 97, 23);
		getContentPane().add(btnSearch);
		
		JLabel label_1 = new JLabel("\uD68C\uC6D0 \uCF54\uB4DC");
		label_1.setBounds(127, 82, 57, 15);
		getContentPane().add(label_1);
		
		tf1 = new JTextField();
		tf1.setText("");
		tf1.setColumns(10);
		tf1.setBounds(196, 79, 274, 21);
		getContentPane().add(tf1);
		
		btnmcode = new JButton("\uD65C\uC131\uD654");
		btnmcode.setBounds(493, 78, 97, 23);
		getContentPane().add(btnmcode);

		Thread thr = new Thread(this);
		thr.start();

		btnReturn.addActionListener(this);
		btnex.addActionListener(this);
		btnSearch.addActionListener(this);
		tf1.addActionListener(this);
		btnmcode.addActionListener(this);
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
				model = new CheckModel();
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
	
	public void clear() {
		tf1.setText("");
		tf2.setText("");
		tf1.setEnabled(false);
		cmd=A;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnex)) {
			subCloseWindow();
		} else if (e.getSource().equals(btnReturn)) {
			BookAmount();
			BookAmt();
			BookTerm();
		} else if (e.getSource().equals(btnSearch)) {
			Search();//대출 중인 책들을 나타내는 것.
		} else if(e.getSource().equals(btnmcode)) {
			BtnMcode();
		}
	}
	
	public void BookAmount() {
		String book = tf2.getText();
		try {
			pst = con.prepareStatement(sqlbamount);
			pst.setInt(1, Integer.valueOf(book));
			rstt = pst.executeQuery();
			while (rstt.next()) {
				bamount = rstt.getString(1);
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

	public void BookAmt() {
		String book = tf2.getText();
		try {
			pst = con.prepareStatement(sqlbamt);
			pst.setInt(1, Integer.valueOf(book));
			rstt = pst.executeQuery();
			while (rstt.next()) {
				bamt = rstt.getString(1);
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

	public void BookCal() {

		String book = tf2.getText();
		try {
			pst = con.prepareStatement(sqlbupdate);

			pst.setInt(1, Integer.valueOf(book));

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

	public void BookTerm() {
		amount = Integer.valueOf(bamount);
		amt = Integer.valueOf(bamt);
		if (amount == amt) {
			JOptionPane.showMessageDialog(null, "책 수량 동일");
			Search();
			clear();
			return;
		} else if (amount<=amt) {
			BookCal();
			Return();
			Search2();
			clear();
		}

	}

	public void Return() {
		// c_mcode,c_mname,c_bcode,c_bname,c_curr,c_day
		String mcode=tf1.getText();
		String bcode = tf2.getText();
		try {
			pst = con.prepareStatement(sqlUpdate);
			pst.setString(1, Date);
			pst.setInt(2, Integer.valueOf(bcode));
			pst.setInt(3, Integer.valueOf(mcode));
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

	public void Search() {//해당하는 책 코드를 검색.
		String bcode = tf2.getText();
		sql = sqlSear + bcode + "%'" + "order by c_code asc";
		try {
			pst = con.prepareStatement(sql);

			pstmttosc = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmtto = con.prepareStatement(sql);

			ResultSet rsscroll = pstmttosc.executeQuery();
			ResultSet rs = pstmtto.executeQuery();

			if (model == null)
				model = new CheckModel();
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
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void Search2() {//반납한 모든 책들을 나타냄.
		try {
			pstmttosc = con.prepareStatement(sqlSearch, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmtto = con.prepareStatement(sqlSearch);

			ResultSet rsscroll = pstmttosc.executeQuery();
			ResultSet rs = pstmtto.executeQuery();

			if (model == null)
				model = new CheckModel();
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
	
	public void BtnMcode() {
		if(cmd==A) {
			tf1.setEnabled(true);
			cmd=B;
			return;
		}
			tf1.setEnabled(false);
			cmd=A;
	}
	
	public void subCloseWindow() {
		try {

			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(false);
		dispose();
	}

	public void run() {
		while (true) {
			Calendar now = Calendar.getInstance();
			year = now.get(Calendar.YEAR);
			month = now.get(Calendar.MONTH) + 1;
			date = now.get(Calendar.DATE);

			Date = year + "/" + month + "/" + date;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
