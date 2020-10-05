package bankproject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class mainbank implements ActionListener {

	private JFrame frame;
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "system";
	String pwd = "123456";
	
	static Connection conn = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	
	JMenuItem itemexit;
	JMenuItem itemcustomer;
	JMenuItem itembranch;
	fcustomer ifCustomer;
	
	frmBranch ifrmBranch;
	frmDepositKind ifrmDepositKind;
	frmDepositOrder ifrmDepositOrder;
	frmDepositStatement ifrmDepositStatement;
	frmInOut ifrmInOut;
	frmLoanKind ifrmLoanKind;
	frmLoanOrder ifrmLoanOrder;
	frmPayBack ifrmPayBack;
	JLabel a;
	
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainbank window = new mainbank();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mainbank() {
		initialize();
		dbConnect();
	}
	
	private void dbConnect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\uC2DC\uC2A4\uD15C");
		menuBar.add(mnNewMenu);

		itemexit = new JMenuItem("\uC885\uB8CC");
		mnNewMenu.add(itemexit);

		JMenu mnNewMenu_1 = new JMenu("\uACE0\uAC1D/\uC9C0\uC810\uAD00\uB9AC");
		menuBar.add(mnNewMenu_1);

		itemcustomer = new JMenuItem("\uACE0\uAC1D\uAD00\uB9AC");
		mnNewMenu_1.add(itemcustomer);

		itembranch = new JMenuItem("\uC9C0\uC810\uAD00\uB9AC");
		mnNewMenu_1.add(itembranch);
		
		mnNewMenu_2 = new JMenu("\uB300\uCD9C");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_1 = new JMenuItem("\uB300\uCD9C\uC885\uB958");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuLoanKind();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem = new JMenuItem("\uB300\uCD9C\uC2E0\uCCAD");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuLoanOrder();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		
		mnNewMenu_3 = new JMenu("\uC785\uCD9C\uAE08");
		menuBar.add(mnNewMenu_3);
		
		mntmNewMenuItem_3 = new JMenuItem("\uC785\uCD9C\uAE08");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInOut();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		mnNewMenu_4 = new JMenu("\uC608\uAE08");
		menuBar.add(mnNewMenu_4);
		
		mntmNewMenuItem_5 = new JMenuItem("\uC608\uAE08\uC885\uB958");
		mnNewMenu_4.add(mntmNewMenuItem_5);
		
		mntmNewMenuItem_4 = new JMenuItem("\uC608\uAE08\uC2E0\uCCAD");
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_2 = new JMenuItem("\uC608\uAE08\uC870\uD68C");
		mnNewMenu_4.add(mntmNewMenuItem_2);
		frame.getContentPane().setLayout(null);
		
		a= new JLabel("상태창");
		a.setBounds(0, 411, 548, 15);
		frame.getContentPane().add(a);
		
		itemexit.addActionListener(this);
		itemcustomer.addActionListener(this);
		itembranch.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itemcustomer)
			menuCustomer();
		if (e.getSource() == itemexit)
			menuExit();
		if(e.getSource()==itembranch)
			menuBranch();
	}
	
	public void menuLoanOrder() {
		
	}
	public void menuInOut() {
		
	}
	public void menuLoanKind() {
		
	}
	public void menuBranch() {
		ifrmBranch = new frmBranch("지점관리", conn, a);
		ifrmBranch.pack();
		ifrmBranch.setVisible(true);
		frame.getContentPane().add(ifrmBranch);
		try {
			ifrmBranch.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void menuCustomer() {
		ifCustomer = new fcustomer();
		ifCustomer.pack();
		ifCustomer.setVisible(true);
		frame.getContentPane().add(ifCustomer);
		try {
			ifCustomer.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void menuExit() {
		System.exit(0);
	}
}
