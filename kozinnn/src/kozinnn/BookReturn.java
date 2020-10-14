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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookReturn extends JInternalFrame implements ActionListener, Runnable {

	private JTable table;
	private JTextField tf2;
	private JButton btnReturn, btnex,btnSearch;
	private int year,month,date;
	private String Date;

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "system";
	String password = "123456";

	Connection con = null;
	PreparedStatement pst = null;
	PreparedStatement pstmtto, pstmttosc;

	CheckModel model;

	String sqlUpdate = "update checkout set	c_curr='π›≥≥',c_dday=? where c_bcode=?";
	String sqlSearch = "select * from checkout where c_curr='π›≥≥' order by c_code asc";
	
	String sqlTotal="select * from checkout where c_curr='¥Î√‚ ¡ﬂ' order by c_code asc";
	
	String sqlSear="select * from checkout where c_bcode like'%";
	String sql;
	
	public BookReturn() {
		initialize();
		dbcon();
		clear();
		to();
	}

	private void initialize() {
		this.getContentPane().setLayout(null);
		this.setTitle("√• π›≥≥");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 185, 651, 254);
		this.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("\uCC45 \uCF54\uB4DC");
		label.setBounds(128, 68, 57, 15);
		this.getContentPane().add(label);

		tf2 = new JTextField();
		tf2.setBounds(197, 65, 274, 21);
		this.getContentPane().add(tf2);
		tf2.setColumns(10);

		btnReturn = new JButton("\uBC18\uB0A9");
		btnReturn.setBounds(374, 107, 97, 23);
		this.getContentPane().add(btnReturn);

		btnex = new JButton("");
		btnex.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\EXIT.GIF"));
		btnex.setBounds(33, 24, 40, 23);
		this.getContentPane().add(btnex);

		JLabel lblNewLabel_1 = new JLabel("\uCC45 \uCF54\uB4DC \uBC18\uB4DC\uC2DC \uC785\uB825");
		lblNewLabel_1.setBounds(194, 24, 215, 34);
		this.getContentPane().add(lblNewLabel_1);

		btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setBounds(197, 107, 97, 23);
		getContentPane().add(btnSearch);

		Thread thr = new Thread(this);
		thr.start();

		btnReturn.addActionListener(this);
		btnex.addActionListener(this);
		btnSearch.addActionListener(this);
	}

	public void dbcon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clear() {
		tf2.setText("");
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnex)) {
			subCloseWindow();
		} else if (e.getSource().equals(btnReturn)) {
			Return();
			Search2();
			clear();
		} else if(e.getSource().equals(btnSearch)) {
			Search();
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

	public void Return() {
		// c_mcode,c_mname,c_bcode,c_bname,c_curr,c_day
		String bcode = tf2.getText();
		
		try {
			pst = con.prepareStatement(sqlUpdate);
			pst.setString(1, Date);
			pst.setInt(2, Integer.valueOf(bcode));
			int res=pst.executeUpdate();
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
	
	public void Search() {
		String bcode=tf2.getText();
		sql=sqlSear+bcode+"%'"+ "order by c_code asc";
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
	
	public void Search2() {
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
