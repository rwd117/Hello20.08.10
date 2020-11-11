package kozinnn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookMan extends JPanel implements ActionListener  {

	private JTextField input;
	private JTable table;
	private JButton btnex; 
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user="system";
	String password="123456";
	
	Connection con=null;
	PreparedStatement pst=null;
	PreparedStatement pstmtto, pstmttosc;
	
	Model model;
	
	String sqlTotal="select * from book1 order by b_code";
	String sqlSearch="select * from book1 where b_name like '%";
	String sql;
	private JButton btnSearch;
	
	public BookMan() {
		initialize();
		dbcon();
		to();
	}

	private void initialize() {
		this.setVisible(true);
		this.setLayout(null);
		
		JLabel lbl = new JLabel("\uC791\uAC00 \uAC80\uC0C9");
		lbl.setBounds(134, 99, 88, 30);
		this.add(lbl);
		
		input = new JTextField();
		input.setBounds(250, 104, 170, 21);
		this.add(input);
		input.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 152, 629, 296);
		this.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnex = new JButton("");
		btnex.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\EXIT.GIF"));
		btnex.setBounds(12, 23, 37, 23);
		this.add(btnex);
		
		btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setBounds(432, 103, 97, 23);
		this.add(btnSearch);
		
		btnex.addActionListener(this);
		input.addActionListener(this);
		btnSearch.addActionListener(this);
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
			
			if(model==null) model=new Model();
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
		if(e.getSource().equals(input)) {
			Sear();
			clear();
		}else if(e.getSource().equals(btnex)) {
			subCloseWindow();
		}else if(e.getSource().equals(btnSearch)) {
			Sear();
			clear();
		}
		
	}
	
	public void Sear() {
		String search=input.getText();	
		sql=sqlSearch+search+"%'";
		
		try {
			pst=con.prepareStatement(sql);
			
			pstmttosc=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmtto=con.prepareStatement(sql);
			
			ResultSet rsscroll=pstmttosc.executeQuery();
			ResultSet rs=pstmtto.executeQuery();
			
			if(model==null) model=new Model();
			model.getRowCount(rsscroll);
			model.setData(rs);
			table.setModel(model);
			table.updateUI();
		} catch(Exception e){
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

	public void subCloseWindow() {
		this.setVisible(false);
	}

	public void clear() {
		input.setText("");
	}
}
