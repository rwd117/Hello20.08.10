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
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Bookinsert extends JInternalFrame implements ActionListener,Runnable{
	
	private JTextField tf;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTable table;
	private JButton Btok,Btca,btngo,btngo2; 
	
	private final static int A = 0;
	private final static int B = 1;
	private final static int C = 2;
	int cmd=A;
	private boolean kfc=true;
	private boolean mac=true;
	int year,month,date;
	String Date;
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user="system";
	String password="123456";
	
	Connection con=null;
	PreparedStatement pst=null;
	PreparedStatement pstmtto, pstmttosc;
	
	Bookmodel model;
	
	String sqlInsertauto="insert into book(b_code,b_number,b_title,b_name,b_ju,b_in,b_amount,b_amt) values(no_seq1.nextval,?,?,?,?,?,2,2)";
	//코드,양 자동입력 -- 버튼 둘다 비활성화
	String sqlInsertamount="insert into book(b_code,b_number,b_title,b_name,b_ju,b_in,b_amount,b_amt) values(?,?,?,?,?,?,2,2)";
	//양 자동입력,코드 수동입력
	String sqlInsertcode="insert into book(b_code,b_number,b_title,b_name,b_ju,b_in,b_amount,b_amt) values(no_seq1.nextval,?,?,?,?,?,?,?)";
	//코드 자동입력,양 수동입력
	String sqlInsertto="insert into book values(?,?,?,?,?,?,?,?)";
	//코드,양 수정
	
	String sqlTotal="select * from book order by b_code asc";
	private JButton btn1;
	private JTextField tf6;
	
	public Bookinsert() {
		initialize();
		dbcon();
		to();
		clear();
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
		
		Btok = new JButton("\uCD94\uAC00");
		Btok.setBounds(69, 424, 116, 23);
		this.getContentPane().add(Btok);
		
		Btca = new JButton("\uCDE8\uC18C");
		Btca.setBounds(215, 424, 116, 23);
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
		
		btngo = new JButton("\uD65C\uC131\uD654");
		btngo.setBounds(307, 56, 70, 23);
		getContentPane().add(btngo);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(131, 18, 165, 29);
		lblNewLabel_1.setText("\uCF54\uB4DC \uC9C0\uC815 \uC6D0\uD560 \uC2DC \uD65C\uC131\uD654");
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblblb = new JLabel("\uCC45 \uC218\uB7C9");
		lblblb.setBounds(39, 326, 88, 20);
		getContentPane().add(lblblb);
		
		tf6 = new JTextField();
		tf6.setText("");
		tf6.setColumns(10);
		tf6.setBounds(139, 326, 157, 21);
		getContentPane().add(tf6);
		
		btngo2 = new JButton("\uD65C\uC131\uD654");
		btngo2.setBounds(307, 325, 70, 23);
		getContentPane().add(btngo2);
		
		Thread thr=new Thread(this);
		thr.start();
		
		btn1.addActionListener(this);
		Btok.addActionListener(this);
		Btca.addActionListener(this);
		btngo.addActionListener(this);
		btngo2.addActionListener(this);
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
	
	public void clear() {
		tf.setText("");
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf6.setText("");
		tf.setEnabled(false);
		tf6.setEnabled(false);
		kfc=true;
		mac=true;
		cmd=A;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(Btok)) {
			adcd();
			to();
			clear();
		}else if(e.getSource().equals(Btca)) {
			clear();
		}else if(e.getSource().equals(btn1)){
			subCloseWindow();
		}else if(e.getSource().equals(btngo)) {
			ab();
		}else if(e.getSource().equals(btngo2)) {
			ac();
		}
	}
	
	public void ab() {
		if(((cmd==A)||(cmd==C))&&(kfc==true)) {
			tf.setEnabled(true);
			cmd=B;
			kfc=false;
			return;
		}else if((kfc==false)&&(mac==false)) {
			tf.setEnabled(false);
			tf.setText("");
			cmd=C;
			kfc=true;
			return;
		}
		tf.setEnabled(false);
		tf.setText("");
		kfc=true;
		cmd=A;
	}
	
	public void ac() {
		if(((cmd==A)||(cmd==B))&&(mac==true)) {
			tf6.setEnabled(true);
			cmd=C;
			mac=false;
			return;
		}else if((kfc==false)&&(mac==false)) {
			tf6.setEnabled(false);
			tf6.setText("");
			cmd=B;
			mac=true;
			return;
		}
		tf6.setEnabled(false);
		tf6.setText("");
		mac=true;
		cmd=A;
	}
	
	public void adcd() {
		//코드,종류,제목,작가이름,출판사,날짜,책 수량,true가 버튼 꺼진것.
		if((kfc==true)&&(mac==true)) {//둘다 꺼짐 
			a();
		}else if((kfc==false)&&(mac==true)) {//코드만 활성화
			b();
		}else if((kfc==true)&&(mac==false)) {//양만 활성화
			c();
		}else if((kfc==false)&&(mac==false)) {//둘다 활성화
			d();
		}
	}

	public void a() {
		String number=tf1.getText();
		String title=tf2.getText();
		String name=tf3.getText();
		String bhome=tf4.getText();
		
		try {
			
			pst=con.prepareStatement(sqlInsertauto);
			pst.setString(1, number);
			pst.setString(2, title);
			pst.setString(3, name);
			pst.setString(4, bhome);
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
	}
	
	public void b() {
		String code=tf.getText();
		String number=tf1.getText();
		String title=tf2.getText();
		String name=tf3.getText();
		String bhome=tf4.getText();
		
		try {
			
			pst=con.prepareStatement(sqlInsertamount);
			pst.setInt(1, Integer.valueOf(code));
			pst.setString(2, number);
			pst.setString(3, title);
			pst.setString(4, name);
			pst.setString(5, bhome);
			pst.setString(6, Date);
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
	
	public void c() {
		String number=tf1.getText();
		String title=tf2.getText();
		String name=tf3.getText();
		String bhome=tf4.getText();
		String amount=tf6.getText();
		
		try {
			
			pst=con.prepareStatement(sqlInsertcode);
			pst.setString(1, number);
			pst.setString(2, title);
			pst.setString(3, name);
			pst.setString(4, bhome);
			pst.setString(5, Date);
			pst.setInt(6, Integer.valueOf(amount));
			pst.setInt(7, Integer.valueOf(amount));
			
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
	
	public void d() {
		String code=tf.getText();
		String number=tf1.getText();
		String title=tf2.getText();
		String name=tf3.getText();
		String bhome=tf4.getText();
		String amount=tf6.getText();
		
		try {
			
			pst=con.prepareStatement(sqlInsertto);
			pst.setInt(1, Integer.valueOf(code));
			pst.setString(2, number);
			pst.setString(3, title);
			pst.setString(4, name);
			pst.setString(5, bhome);
			pst.setString(6, Date);
			pst.setInt(7, Integer.valueOf(amount));
			pst.setInt(8, Integer.valueOf(amount));
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
