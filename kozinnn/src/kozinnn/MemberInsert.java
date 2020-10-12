package kozinnn;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class MemberInsert extends JInternalFrame implements ActionListener {
	//m_code,m_name,m_address,m_phone
	private JButton btnIn,btnCa,btnEx;

	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user="system";
	String password="123456";
	
	Connection con=null;
	PreparedStatement pst=null;
	PreparedStatement pstmtto, pstmttosc;
	
	Bookmodel model;
	
	String sqlInsert="insert into member1 values(no_seq2.nextval,?,?,?)";
	String sqlTotal="select * from member1 order by m_code asc";
	private JTextField tf;
	private JTextField tf1;
	private JTextField tf2;
	private JTable table;

	public MemberInsert() {
		initialize();
		dbcon();
		to();
		memCan();
	}

	private void initialize() {
		this.setTitle("ȸ�� ���");
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(38, 46, 57, 15);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_1.setBounds(233, 46, 57, 15);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_2.setBounds(38, 99, 57, 15);
		this.getContentPane().add(lblNewLabel_2);
		
		tf = new JTextField();
		tf.setBounds(105, 43, 104, 21);
		this.getContentPane().add(tf);
		tf.setColumns(10);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(302, 43, 185, 21);
		this.getContentPane().add(tf1);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(105, 96, 427, 21);
		this.getContentPane().add(tf2);
		
		btnIn = new JButton("\uCD94\uAC00");
		btnIn.setBounds(146, 152, 97, 23);
		this.getContentPane().add(btnIn);
		
		btnCa = new JButton("\uCDE8\uC18C");
		btnCa.setBounds(390, 152, 97, 23);
		this.getContentPane().add(btnCa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 196, 674, 250);
		this.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnEx = new JButton("");
		btnEx.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\EXIT.GIF"));
		btnEx.setBounds(38, 10, 33, 23);
		this.getContentPane().add(btnEx);
		
		JLabel lblNewLabel_3 = new JLabel("\uC774\uB984,\uC804\uD654 \uBC88\uD638 \uD544\uC218 \uC785\uB825");
		lblNewLabel_3.setBounds(539, 21, 147, 65);
		getContentPane().add(lblNewLabel_3);
		
		btnEx.addActionListener(this);
		btnIn.addActionListener(this);
		btnCa.addActionListener(this);
	}

	public void dbcon() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void to() {
		try {
			pstmttosc=con.prepareStatement(sqlTotal,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmtto=con.prepareStatement(sqlTotal);
			
			ResultSet rsscroll=pstmttosc.executeQuery();
			ResultSet rs=pstmtto.executeQuery();
			
			if(model==null) model=new Bookmodel();
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
		if(e.getSource().equals(btnEx)) {
			subCloseWindow();
		}else if(e.getSource().equals(btnIn)) {
			memInsert();
			to();
		}else if(e.getSource().equals(btnCa)) {
			memCan();
		}
	}
	
	public void memInsert() {
		String name=tf.getText();
		String phone=tf1.getText();
		String address=tf2.getText();
		
		try {
			
			pst=con.prepareStatement(sqlInsert);
			pst.setString(1, name);
			pst.setString(2, address);
			pst.setString(3, phone);
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
	
	public void memCan() {
		tf.setText("");
		tf1.setText("");
		tf2.setText("");
	}
	
	public void subCloseWindow() {
	       
		try {
           
        	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        } catch(Exception e) {
            e.printStackTrace();
        }
        setVisible(false);
        dispose();
    }
}
