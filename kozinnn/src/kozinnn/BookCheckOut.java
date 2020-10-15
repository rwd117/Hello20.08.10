package kozinnn;

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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookCheckOut extends JInternalFrame implements ActionListener,Runnable  {

	private JTable table;
	private JTextField tf1;
	private JTextField tf2;
	private JButton btnCheck, btnex;
	private String mname,bname,bamount,bamt;
	private int year,month,date,amount,amt;
	private String Date;
	
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private	String user = "system";
	private String password = "123456";

	Connection con = null;
	PreparedStatement pst= null;
	PreparedStatement pstmtto, pstmttosc;
	ResultSet rst,rstt,rs;

	CheckModel model;
	String sqlbs = "select b_title from book where b_code=?";
	
	String sqlbamount= "select b_amount from book where b_code=?";
	String sqlbamt= "select b_amt from book where b_code=?";
	
	String sqlbupdate="update book set b_amount=b_amount-1 where b_code=?";

	String sqlms = "select m_name from member1 where m_code=?";
	
	String sqlInsert = "insert into checkout(c_code,c_mcode,c_mname,c_bcode,c_bname,c_curr,c_day) values(no_seq4.nextval,?,?,?,?,'대출 중',?)";
	String sqlSearch="select * from checkout where c_curr='대출 중' order by c_code asc";
	//?는  자동으로 설정,2,4는 입력 3,5는 select 해서 가져오기 6은 입력.7은 쓰레드로 입력.
	//셀렉 해서 북에서 정보를 가져오고 그 정보값을 그 셀에 입력?
	
	public BookCheckOut() {
		initialize();
		dbcon();
		Sear();
		clear();
	}

	private void initialize() {
		this.getContentPane().setLayout(null);
		this.setTitle("책 대출");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 185, 651, 254);
		this.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uBC88\uD638");
		lblNewLabel.setBounds(33, 73, 57, 15);
		this.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("\uCC45 \uCF54\uB4DC");
		label.setBounds(33, 134, 57, 15);
		this.getContentPane().add(label);

		tf1 = new JTextField();
		tf1.setBounds(130, 73, 178, 21);
		this.getContentPane().add(tf1);
		tf1.setColumns(10);

		tf2 = new JTextField();
		tf2.setBounds(130, 131, 178, 21);
		this.getContentPane().add(tf2);
		tf2.setColumns(10);

		btnCheck = new JButton("\uB300\uCD9C");
		btnCheck.setBounds(371, 99, 97, 23);
		this.getContentPane().add(btnCheck);

		btnex = new JButton("");
		btnex.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\EXIT.GIF"));
		btnex.setBounds(33, 24, 40, 23);
		this.getContentPane().add(btnex);

		JLabel lblNewLabel_1 = new JLabel(
				"\uD68C\uC6D0 \uBC88\uD638, \uCC45 \uCF54\uB4DC \uBC18\uB4DC\uC2DC \uC785\uB825");
		lblNewLabel_1.setBounds(130, 24, 212, 48);
		this.getContentPane().add(lblNewLabel_1);
		
		Thread thr=new Thread(this);
		thr.start();
		
		btnCheck.addActionListener(this);
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
		tf1.setText("");
		tf2.setText("");
		rst=null;
		rstt=null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnex)) {
			subCloseWindow();
		} else if (e.getSource().equals(btnCheck)) {
			Memberselect();
			Bookselect();
			BookAmount();
			BookAmt();
			BookTerm();
		}
	}
	
	public void Memberselect() {
		// 1 회원 2 책
		String member = tf1.getText();
		
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

	public void BookAmount() {
		String book = tf2.getText();
		try {
			pst = con.prepareStatement(sqlbamount);
			pst.setInt(1, Integer.valueOf(book));
			rstt=pst.executeQuery();
			while(rstt.next()) {
			bamount=rstt.getString(1);
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
			rstt=pst.executeQuery();
			while(rstt.next()) {
			bamt=rstt.getString(1);
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
	
	public void BookTerm() {
		amount=Integer.valueOf(bamount);
		amt=Integer.valueOf(bamt);
		if(amount==0) {
			JOptionPane.showMessageDialog(null, "책이 없습니다");
			Sear();
			clear();
			return;
		}else if(amount!=0) {
			BookCal();
			CheckInsert();
			Sear();
			clear();
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
	
	public void subCloseWindow() {
		try {

			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(false);
		dispose();
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
