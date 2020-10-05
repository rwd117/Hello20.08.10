import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main implements ActionListener{

	private JFrame frame;
	
	private JMenuItem itemExit;
	private JMenuItem itemCustomer;
	private JMenuItem itemBranch;
	private JMenuItem itemDepositOrder;
	private JMenuItem itemInOut;
	private JMenuItem itemDepositStatement;
	private JMenuItem itemLoanApply;
	private JMenuItem itemLoanPayback;
	private JMenuItem itemDepositKind;
	private JMenuItem itemLoanKind;
	private Border internalFrameBorder;
	private Container container;
	
	private JPanel curPane;
	
	private Connection conn = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
		DBControler db = new DBControler();
		db.connect();
		db.executeQuery("select * from customer where c_no='-1'");
		db.disConnect();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("BankProject");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width / 2;
		int height = screenSize.height / 2;
		int x = screenSize.width / 4;
		int y = screenSize.height / 4;
		frame.setBounds(x, y, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				if(curPane != null) {
					curPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());	
				}
			}
		});
		
		container = frame.getContentPane();
		container.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("�ý���");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("��/��������");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("����");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("����");
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("��ǰ����");
		menuBar.add(mnNewMenu_4);
		
//		�ý���
		itemExit = new JMenuItem("����");
		mnNewMenu.add(itemExit);
		
//		��/��������
		itemCustomer = new JMenuItem("������");
		mnNewMenu_1.add(itemCustomer);
		
		itemBranch = new JMenuItem("��������");
		mnNewMenu_1.add(itemBranch);
		
//		����		
		itemDepositOrder = new JMenuItem("���ݰŷ���û");
		mnNewMenu_2.add(itemDepositOrder);
		
		itemInOut = new JMenuItem("��/���");
		mnNewMenu_2.add(itemInOut);
		
		itemDepositStatement = new JMenuItem("����ݳ���");
		mnNewMenu_2.add(itemDepositStatement);
		
//		����
		itemLoanApply = new JMenuItem("����ŷ���û");
		mnNewMenu_3.add(itemLoanApply);
		
		itemLoanPayback = new JMenuItem("�����ȯ");
		mnNewMenu_3.add(itemLoanPayback);
		
//		��ǰ����
		itemDepositKind = new JMenuItem("���ݻ�ǰ");
		mnNewMenu_4.add(itemDepositKind);
		
		itemLoanKind = new JMenuItem("�����ǰ");
		mnNewMenu_4.add(itemLoanKind);		
		
		itemExit.addActionListener(this);
		itemCustomer.addActionListener(this);
		itemBranch.addActionListener(this);
		itemDepositOrder.addActionListener(this);
		itemInOut.addActionListener(this);
		itemDepositStatement.addActionListener(this);
		itemLoanApply.addActionListener(this);
		itemLoanPayback.addActionListener(this);
		itemDepositKind.addActionListener(this);
		itemLoanKind.addActionListener(this);
	}
	
	public void clearContainer(){
		container.removeAll();
		container.setVisible(false);
		container.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		clearContainer();
		if(e.getSource() == itemExit){
			System.exit(0);
		}
		else if(e.getSource() == itemCustomer){
			curPane = new CustomerPane();
		}
		else if(e.getSource() == itemBranch) {
			curPane = new BranchPane();
		}
		else if(e.getSource() == itemDepositOrder){
			curPane = new DepositOrderPane();
		}
		else if(e.getSource() == itemDepositKind) {
			curPane = new DepositKindPane();
		}
		else if(e.getSource() == itemLoanKind) {
			curPane = new LoanKindPane();
		}
		else if(e.getSource() == itemDepositStatement){
			curPane = new DepositStatementPane();
		}
		else if(e.getSource() == itemInOut){
			curPane = new DepositInOutPane();
		}
		else if(e.getSource() == itemLoanApply) {
			curPane = new LoanApplyPane();
		}
		else if(e.getSource() == itemLoanPayback) {
			curPane = new LoanPaybackPane();
		}
		curPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(curPane);
	}
}