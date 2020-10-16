package kozinnn;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
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
	private JMenuItem btin,btex,btup,btde,btsena,btsema,btnpublish,btnReturn,btnCheckout,addbtn,delbtn,updabtn;
	private JMenuItem McodeSe,MnameSe;

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
	MemberInsert Minsert;
	MemberDelete Mdelete;
	MemberUpdate Mupdate;
	MemberCode Mcode;
	MemberName Mname;
	BookCheckOut Bcheck;
	BookReturn Breturn;

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
		
		JMenu mnNewMenu = new JMenu("\uB300\uCD9C/\uBC18\uB0A9");
		menuBar.add(mnNewMenu);
		
		btnCheckout = new JMenuItem("\uB300\uCD9C");
		mnNewMenu.add(btnCheckout);
		
		btnReturn = new JMenuItem("\uBC18\uB0A9");
		mnNewMenu.add(btnReturn);
		
		btex = new JMenuItem("\uC885\uB8CC");
		mn.add(btex);
		
		JMenu mn1 = new JMenu("\uCC45 \uCD94\uAC00/\uC218\uC815/\uC0AD\uC81C");
		menuBar.add(mn1);
		
		btin = new JMenuItem("\uCD94\uAC00");
		mn1.add(btin);
		
		btup = new JMenuItem("\uC218\uC815");
		mn1.add(btup);
		
		btde = new JMenuItem("\uC0AD\uC81C");
		mn1.add(btde);
		
		JMenu mn2 = new JMenu("\uAC80\uC0C9");
		menuBar.add(mn2);
		
		btsena = new JMenuItem("\uCC45 \uC81C\uBAA9 \uAC80\uC0C9");
		mn2.add(btsena);
		
		btsema = new JMenuItem("\uC791\uAC00 \uAC80\uC0C9");
		mn2.add(btsema);
		
		btnpublish =new JMenuItem("출판사 검색");
		mn2.add(btnpublish);
		
		McodeSe = new JMenuItem("\uD68C\uC6D0 \uBC88\uD638 \uAC80\uC0C9");
		mn2.add(McodeSe);
		
		MnameSe = new JMenuItem("\uD68C\uC6D0 \uC774\uB984 \uAC80\uC0C9");
		mn2.add(MnameSe);
		
		JMenu mnNewMenu_1 = new JMenu("\uD68C\uC6D0 \uAD00\uB9AC");
		menuBar.add(mnNewMenu_1);
		
		addbtn = new JMenuItem("\uD68C\uC6D0 \uB4F1\uB85D");
		mnNewMenu_1.add(addbtn);
		
		delbtn = new JMenuItem("\uD68C\uC6D0 \uC0AD\uC81C");
		mnNewMenu_1.add(delbtn);
		
		updabtn =new JMenuItem("\uD68C\uC6D0 \uC218\uC815");
		mnNewMenu_1.add(updabtn);
		
		
		
		btex.addActionListener(this);
		
		btsena.addActionListener(this);
		btsema.addActionListener(this);
		btnpublish.addActionListener(this);
		McodeSe.addActionListener(this);
		MnameSe.addActionListener(this);
		
		btin.addActionListener(this);
		btup.addActionListener(this);
		btde.addActionListener(this);
		
		btnCheckout.addActionListener(this);
		btnReturn.addActionListener(this);
		
		addbtn.addActionListener(this);
		delbtn.addActionListener(this);
		updabtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btex)) {
			System.exit(0);
		}else if(e.getSource().equals(btin)) {
			goInsert();//책 추가
		}else if(e.getSource().equals(btup)) {
			goUpdate();//책 수정
		}else if(e.getSource().equals(btde)) {
			goDelete();//책 삭제
		}else if(e.getSource().equals(btsena)) {
			goTitle();//책 제목 검색
		}else if(e.getSource().equals(btsema)) {
			goMan();//작가 검색
		}else if(e.getSource().equals(btnpublish)) {
			goPublish();//출판사 검색
		}else if(e.getSource().equals(McodeSe)) {
			goMcode();//회원 번호 검색
		}else if(e.getSource().equals(MnameSe)) {
			goMname();//회원 이름 검색
		}else if(e.getSource().equals(btnReturn)) {
			goReturn();//책 반납
		}else if(e.getSource().equals(btnCheckout)) {
			goCheckout();//책 대출
		}else if(e.getSource().equals(addbtn)) {
			goMInsert();//회원 추가
		}else if(e.getSource().equals(delbtn)) {
			goMDelete();//회원 삭제
		}else if(e.getSource().equals(updabtn)) {
			goMUpdate();//회원 수정
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
	
	public void goMcode() {
		Mcode = new MemberCode();
		Mcode.pack();
		Mcode.setVisible(true);
		Mcode.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Mcode);
		try {
			Mcode.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void goMname() {
		Mname = new MemberName();
		Mname.pack();
		Mname.setVisible(true);
		Mname.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Mname);
		try {
			Mname.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goMInsert() {
		Minsert = new MemberInsert();
		Minsert.pack();
		Minsert.setVisible(true);
		Minsert.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Minsert);
		try {
			Minsert.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goMDelete() {
		Mdelete = new MemberDelete();
		Mdelete.pack();
		Mdelete.setVisible(true);
		Mdelete.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Mdelete);
		try {
			Mdelete.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void goMUpdate() {
		Mupdate = new MemberUpdate();
		Mupdate.pack();
		Mupdate.setVisible(true);
		Mupdate.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Mupdate);
		try {
			Mupdate.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void goCheckout() {
		Bcheck = new BookCheckOut();
		Bcheck.pack();
		Bcheck.setVisible(true);
		Bcheck.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Bcheck);
		try {
			Bcheck.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goReturn() {
		Breturn = new BookReturn();
		Breturn.pack();
		Breturn.setVisible(true);
		Breturn.setBounds(20, 20, 800, 486);
		frame.getContentPane().add(Breturn);
		try {
			Breturn.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
