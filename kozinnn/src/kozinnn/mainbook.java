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
	private JMenuItem btin,btex,btup,btde,btsena,btsema;
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "system";
	String pwd = "123456";
	
	Bookinsert Binsert;
	BookUpdate Bupdate;

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
		
		JMenu mn1 = new JMenu("\uCD94\uAC00/\uC218\uC815/\uC0AD\uC81C");
		menuBar.add(mn1);
		
		JMenu mn2 = new JMenu("\uAC80\uC0C9");
		menuBar.add(mn2);
		
		btex = new JMenuItem("\uC885\uB8CC");
		mn.add(btex);
		
		btin = new JMenuItem("\uCD94\uAC00");
		mn1.add(btin);
		
		btup = new JMenuItem("\uC218\uC815");
		mn1.add(btup);
		
		btde = new JMenuItem("\uC0AD\uC81C");
		mn1.add(btde);
		
		btsena = new JMenuItem("\uCC45 \uC81C\uBAA9");
		mn2.add(btsena);
		
		btsema = new JMenuItem("\uC791\uAC00");
		mn2.add(btsema);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\uCD9C\uD310\uC0AC");
		mn2.add(mntmNewMenuItem);
		
		btex.addActionListener(this);
		btin.addActionListener(this);
		btup.addActionListener(this);
		btde.addActionListener(this);
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
			
		}else if(e.getSource().equals(btsena)) {
			
		}else if(e.getSource().equals(btsema)) {
			
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
}
