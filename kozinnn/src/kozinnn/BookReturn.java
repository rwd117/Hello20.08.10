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

public class BookReturn extends JInternalFrame implements ActionListener,Runnable  {

	private JTable table;
	private JTextField tf2;
	private JButton btnReturn, btnex;
	private String mname,bname;
	int year,month,date;
	String Date;
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "system";
	String password = "123456";

	Connection con = null;
	PreparedStatement pst = null;
	PreparedStatement pstmtto, pstmttosc;
	ResultSet rst,rstt;

	CheckModel model;

	String sqlbs = "select b_title from book where b_code=?";
	String sqlms = "select m_name from member1 where m_code=?";
	String sqlInsert = "update checkout set	c_curr=?,c_dday=? from c_bcode=?";
	String sqlSearch="select * from checkout where c_curr='대출 중' order by c_code asc";
	

	public BookReturn() {
		initialize();
		dbcon();
		clear();
		Sear();
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

		JLabel lblNewLabel_1 = new JLabel(
				"\uCC45 \uCF54\uB4DC \uBC18\uB4DC\uC2DC \uC785\uB825");
		lblNewLabel_1.setBounds(194, 24, 215, 34);
		this.getContentPane().add(lblNewLabel_1);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setBounds(197, 107, 97, 23);
		getContentPane().add(btnSearch);
		
		Thread thr=new Thread(this);
		thr.start();
		
		btnReturn.addActionListener(this);
		btnex.addActionListener(this);
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
		rst=null;
		rstt=null;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnex)) {
			subCloseWindow();
		} else if (e.getSource().equals(btnReturn)) {
			Memberselect();
			Bookselect();
			CheckInsert();
			Sear();
			clear();
		}
	}
	
	public void Memberselect() {
		// 1 회원 2 책
		String member = tf2.getText();
		
		try {

			pst = con.prepareStatement(sqlms);
			pst.setInt(1, Integer.valueOf(member));
			rst=pst.executeQuery();
			while(rst.next()) {
			mname=rst.getString(1);
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

	public void Bookselect() {
		// 1 회원 2 책
		String book = tf2.getText();
		
		try {

			pst = con.prepareStatement(sqlbs);
			pst.setInt(1, Integer.valueOf(book));
			rstt=pst.executeQuery();
			while(rstt.next()) {
			bname=rstt.getString(1);
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

	public void CheckInsert() {
		//c_mcode,c_mname,c_bcode,c_bname,c_curr,c_day
		try {
			
			String mcode=tf1.getText();
			String bcode=tf2.getText();
			
			try {
				pst=con.prepareStatement(sqlInsert);
				pst.setInt(1, Integer.valueOf(mcode));
				pst.setString(2, mname);
				pst.setInt(3,Integer.valueOf(bcode));
				pst.setString(4, bname);
				pst.setString(5, Date);
				
				int res=pst.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Sear() {
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
		while(true) {
			Calendar now = Calendar.getInstance();
	        year=now.get(Calendar.YEAR);
			month=now.get(Calendar.MONTH)+1;
			date=now.get(Calendar.DATE);
			
			Date=year+"/"+month+"/"+date;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
