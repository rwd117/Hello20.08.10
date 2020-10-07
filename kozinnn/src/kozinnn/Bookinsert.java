package kozinnn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import javax.swing.ImageIcon;

public class Bookinsert extends JInternalFrame implements ActionListener{
	
	private JTextField tf;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTable table;
	private JButton Btok,Btca; 
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user="system";
	String password="123456";
	
	Connection con=null;
	PreparedStatement pst=null;
	PreparedStatement pstmtto, pstmttosc;
	
	Bookmodel model;
	
	String sqlInsert="insert into book values(?,?,?,?,?,?)";
	String sqlTotal="select * from book ";
	private JButton btn1;
	
	public Bookinsert() {
		initialize();
		dbcon();
		to();
	}
	
	private void initialize() {
		this.setTitle("책 추가");
		this.getContentPane().setLayout(null);
		

		JLabel lblNewLabel = new JLabel("\uCC45 \uCF54\uB4DC");
		lblNewLabel.setBounds(39, 57, 88, 20);
		this.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uC885\uB958");
		label.setBounds(39, 101, 88, 20);
		this.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uC81C\uBAA9");
		label_1.setBounds(39, 155, 88, 20);
		this.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uC791\uAC00 \uC774\uB984");
		label_2.setBounds(39, 212, 88, 20);
		this.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uCD9C\uD310\uC0AC");
		label_3.setBounds(39, 265, 88, 20);
		this.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uB4F1\uB85D \uB0A0\uC9DC");
		label_4.setBounds(39, 322, 88, 20);
		this.getContentPane().add(label_4);
		
		tf = new JTextField();
		tf.setBounds(139, 57, 157, 21);
		this.getContentPane().add(tf);
		tf.setColumns(10);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(139, 101, 157, 21);
		this.getContentPane().add(tf1);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(139, 155, 157, 21);
		this.getContentPane().add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(139, 212, 157, 21);
		this.getContentPane().add(tf3);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(139, 265, 157, 21);
		this.getContentPane().add(tf4);
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		tf5.setBounds(139, 322, 157, 21);
		this.getContentPane().add(tf5);
		
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
		
		btn1 = new JButton("");
		btn1.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\EXIT.GIF"));
		btn1.setBounds(39, 10, 32, 23);
		this.getContentPane().add(btn1);
		
		btn1.addActionListener(this);
		Btok.addActionListener(this);
		Btca.addActionListener(this);
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
		if(e.getSource().equals(Btok)) {
			add();
			to();
		}else if(e.getSource().equals(Btca)) {
			clear();
		}else if(e.getSource().equals(btn1)){
			subCloseWindow();
		}
		
	}
	public void clear() {
		tf.setText("");
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		
	}
	
	public void add() {
		//코드,종류,제목,작가이름,출판사,날짜
		String code=tf.getText();
		String number=tf1.getText();
		String title=tf2.getText();
		String name=tf3.getText();
		String bhome=tf4.getText();
		String day=tf5.getText();
		
		try {
			
			pst=con.prepareStatement(sqlInsert);
			pst.setString(1, code);
			pst.setString(2, number);
			pst.setString(3, title);
			pst.setString(4, name);
			pst.setString(5, bhome);
			pst.setString(6, day);
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
