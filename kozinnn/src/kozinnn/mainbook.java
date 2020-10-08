package kozinnn;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class mainbook implements ActionListener {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenuItem btin,btex,btup,btde,btsena,btsema,btnpublish;
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "system";
	String pwd = "123456";
	
	Bookinsert Binsert;
	BookUpdate Bupdate;
	BookDelete Bdelete;
	BookTitle Btitle;
	BookMan Bman;
	BookPublish Bpublish;

	static Connection conn = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainbook window = new mainbook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mainbook() {
		initialize();
		dbcon();
	}
	
	public void dbcon() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 361, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mn = new JMenu("\uC2DC\uC2A4\uD15C");
		menuBar.add(mn);
		
		JMenu mn2 = new JMenu("\uAC80\uC0C9");
		menuBar.add(mn2);
		
		btex = new JMenuItem("\uC885\uB8CC");
		mn.add(btex);
		
		btsena = new JMenuItem("\uCC45 \uC81C\uBAA9 \uAC80\uC0C9");
		mn2.add(btsena);
		
		btsema = new JMenuItem("\uC791\uAC00 \uAC80\uC0C9");
		mn2.add(btsema);
		
		btnpublish =new JMenuItem("출판사 검색");
		mn2.add(btnpublish);
		btnpublish.addActionListener(this);
		
		JMenu mn1 = new JMenu("\uCD94\uAC00/\uC218\uC815/\uC0AD\uC81C");
		menuBar.add(mn1);
		
		btin = new JMenuItem("\uCD94\uAC00");
		mn1.add(btin);
		
		btup = new JMenuItem("\uC218\uC815");
		mn1.add(btup);
		
		btde = new JMenuItem("\uC0AD\uC81C");
		mn1.add(btde);
		
		
		btin.addActionListener(this);
		btup.addActionListener(this);
		btde.addActionListener(this);
		
		btex.addActionListener(this);
		btsena.addActionListener(this);
		btsema.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btex)) {
			System.exit(0);
		}else if(e.getSource().equals(btin)) {
			goInsert();
		}else if(e.getSource().equals(btup)) {
			goUpdate();
		}else if(e.getSource().equals(btde)) {
			goDelete();
		}else if(e.getSource().equals(btsena)) {
			goTitle();
		}else if(e.getSource().equals(btsema)) {
			goMan();
		}else if(e.getSource().equals(btnpublish)) {
			goPublish();
		}
	}
	
	public void goInsert() {
		Binsert = new Bookinsert();
		Binsert.pack();
		Binsert.setVisible(true);
		Binsert.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Binsert);
		try {
			Binsert.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void goUpdate() {
		Bupdate = new BookUpdate();
		Bupdate.pack();
		Bupdate.setVisible(true);
		Bupdate.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Bupdate);
		try {
			Bupdate.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void goDelete() {
		Bdelete = new BookDelete();
		Bdelete.pack();
		Bdelete.setVisible(true);
		Bdelete.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Bdelete);
		try {
			Bdelete.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goTitle() {
		Btitle = new BookTitle();
		Btitle.pack();
		Btitle.setVisible(true);
		Btitle.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Btitle);
		try {
			Btitle.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goMan() {
		Bman = new BookMan();
		Bman.pack();
		Bman.setVisible(true);
		Bman.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Bman);
		try {
			Bman.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goPublish() {
		Bpublish = new BookPublish();
		Bpublish.pack();
		Bpublish.setVisible(true);
		Bpublish.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Bpublish);
		try {
			Bpublish.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
