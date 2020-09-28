package test10;

import java.awt.EventQueue;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Branch implements ActionListener{
	
	private JFrame 瘤痢包府;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTable table;
	JButton btnInsert,btnSave,btnCancel;
	
	private static final int NONE=0;
	private static final int ADD=1;
	private static final int SAVE=2;
	private static final int TOTAL=3;
	int cmd=NONE;
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user="system";
	String password="123456";
	
	Connection con=null;
	PreparedStatement pst=null;
	PreparedStatement pstmtto, pstmttosc;
	
	Branchmodel model;
	
	/*b_no		
	b_name		
	b_addr		
	b_phone 	
	b_assets*/
	
	String sqlInsert="insert into branch values(?,?,?,?,?)";
	String sqlUpdate="update branch set b_name=?,b_addr=?,b_phone=?,b_assets=?  where b_no=?";
	String sqlTotal="select * from branch order by b_no desc ";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Branch window = new Branch();
					window.瘤痢包府.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Branch() {
		initialize();
		init();
		dbcon();
		to();
	}

	public void dbcon() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		tf4.setEditable(false);
		tf5.setEditable(false);
		btnInsert.setEnabled(true);
		btnSave.setEnabled(true);
		btnCancel.setEnabled(true);
		
	}
	
	private void initialize() {
		瘤痢包府 = new JFrame();
		瘤痢包府.setTitle("\uC9C0\uC810\uAD00\uB9AC");
		瘤痢包府.setBounds(100, 100, 614, 485);
		瘤痢包府.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		瘤痢包府.getContentPane().setLayout(null);
		
		btnInsert = new JButton("\uCD94\uAC00");
		btnInsert.setBounds(12, 25, 97, 23);
		瘤痢包府.getContentPane().add(btnInsert);
		
		btnSave = new JButton("\uC800\uC7A5");
		btnSave.setBounds(121, 25, 97, 23);
		瘤痢包府.getContentPane().add(btnSave);
		
		btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.setBounds(234, 25, 97, 23);
		瘤痢包府.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("\uC9C0\uC810\uBC88\uD638");
		lblNewLabel.setBounds(24, 77, 57, 15);
		瘤痢包府.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uC9C0\uC810\uBA85");
		label.setBounds(24, 102, 57, 15);
		瘤痢包府.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uC8FC\uC18C");
		label_1.setBounds(24, 127, 57, 15);
		瘤痢包府.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_2.setBounds(24, 156, 57, 15);
		瘤痢包府.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uC790\uC0B0\uCD1D\uC561");
		label_3.setBounds(24, 188, 57, 15);
		瘤痢包府.getContentPane().add(label_3);
		
		tf1 = new JTextField();
		tf1.setBounds(102, 74, 116, 21);
		瘤痢包府.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(102, 99, 116, 21);
		瘤痢包府.getContentPane().add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(102, 124, 116, 21);
		瘤痢包府.getContentPane().add(tf3);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(102, 153, 116, 21);
		瘤痢包府.getContentPane().add(tf4);
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		tf5.setBounds(102, 185, 116, 21);
		瘤痢包府.getContentPane().add(tf5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 227, 574, 209);
		瘤痢包府.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnInsert.addActionListener(this);
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	public void call(int a) {
		btnInsert.setEnabled(false);
		btnSave.setEnabled(false);
		btnCancel.setEnabled(true);
	switch(a) {
		case ADD:	
			tf1.setEditable(true);
			tf2.setEditable(true);
			tf3.setEditable(true);
			tf4.setEditable(true);
			tf5.setEditable(true);
			btnInsert.setEnabled(true);
			cmd=ADD;
			break;
			
		case SAVE:	
			tf1.setEditable(true);
			tf2.setEditable(true);
			tf3.setEditable(true);
			tf4.setEditable(true);
			tf5.setEditable(true);
			btnSave.setEnabled(true);
			cmd=SAVE;
			break;
		
		case NONE:
			cmd=NONE;
			break;
		}
	}
	
	public void add() {
		String no=tf1.getText();
		String na=tf2.getText();
		String ju=tf3.getText();
		String tel=tf4.getText();
		int mon=Integer.parseInt(tf5.getText());
		
		try {
			
			pst=con.prepareStatement(sqlInsert);
			pst.setString(1, no);
			pst.setString(2, na);
			pst.setString(3, ju);
			pst.setString(4, tel);
			pst.setInt(5, mon);
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
		
	}
	public void sa() {
		String no=tf1.getText();
		String na=tf2.getText();
		String ju=tf3.getText();
		String tel=tf4.getText();
		int mon=Integer.parseInt(tf5.getText());
		
		try {
			pst=con.prepareStatement(sqlUpdate);
			pst.setString(1, na);
			pst.setString(2, ju);
			pst.setString(3, tel);
			pst.setInt(4, mon);
			pst.setString(5, no);
			
			pst.executeUpdate();
			
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
	}
	public void to() {
		try {
			pstmttosc=con.prepareStatement(sqlTotal,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmtto=con.prepareStatement(sqlTotal);
			
			ResultSet rsscroll=pstmttosc.executeQuery();
			ResultSet rs=pstmtto.executeQuery();
			
			if(model==null) model=new Branchmodel();
			model.getRowCount(rsscroll);
			model.setData(rs);
			table.setModel(model);
			table.updateUI();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
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
		if(e.getSource().equals(btnInsert)) {
			if(cmd!=ADD) {
				call(ADD);
				to();
				return;
				}
				add(); 
				to();
		}else if(e.getSource().equals(btnSave)) {
			if(cmd!=SAVE) {
				call(SAVE);
				to();
				return;}
			sa();
			to();
		}else if(e.getSource().equals(btnCancel)) {
			call(TOTAL);
			to();
		}	
			call(NONE);
			init();	
	}
}
