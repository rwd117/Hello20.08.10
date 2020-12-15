package User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Db.MemberLoginDb;
import Net.ClientBackGround;
import Net.PCServerBackGround;
public class UserLogin implements ActionListener {

	private JFrame frame;
	private JTextField IDText;
	private JPasswordField PWDText;
//	private RoundedButton BtnLogin,BtnClear;
	private JButton BtnLogin,BtnClear;
	private JLabel IDlb,PWDlb;
	private JComboBox JCom;
	private int index;
	private boolean Check=true;
	private String Name="아무개";
//	private ClientBackGround client=new ClientBackGround();
//	private PCServerBackGround server=new PCServerBackGround();
	private String msg;
	/**
	 * Create the application.
	 */
	public UserLogin(boolean UserCheck) {
		this.Check = UserCheck;
		if(Check==true) {
			
			initialize();
			IDText.setVisible(true);
			
		}else if(Check==false) {
			
			initialize();
			IDlb.setText("비회원 카드 번호");
			IDlb.setBounds(200,202,200,33);
			JCom.setVisible(true);
			
			PWDlb.setText("회원 이름");
			IDText.setBounds(442, 307, 246, 41);
			
			PWDText.setVisible(false);
			frame.setResizable(false);
			frame.setVisible(true);
		}
	
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 100, 966, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(051, 051, 051));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		IDlb = new JLabel("ID");
		IDlb.setForeground(Color.WHITE);
		IDlb.setFont(new Font("굴림", Font.PLAIN, 20));
		IDlb.setBounds(244, 202, 89, 33);
		frame.getContentPane().add(IDlb);
		
		PWDlb = new JLabel("\uBE44\uBC00\uBC88\uD638");
		PWDlb.setForeground(Color.WHITE);
		PWDlb.setFont(new Font("굴림", Font.PLAIN, 20));
		PWDlb.setBounds(212, 303, 184, 33);
		frame.getContentPane().add(PWDlb);
		
		IDText = new JTextField();
		IDText.setBounds(442, 200, 246, 41);
		IDText.selectAll();
		frame.getContentPane().add(IDText);
		
		String[] Combo = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
		
		JCom= new JComboBox(Combo);
		JCom.setBounds(442, 200, 246, 41);
		frame.getContentPane().add(JCom);
		JCom.setVisible(false);
		
		PWDText = new JPasswordField();
		PWDText.setBounds(442, 307, 246, 41);
		PWDText.selectAll();
		PWDText.setEchoChar('*');
		frame.getContentPane().add(PWDText);
		
		BtnLogin = new JButton("로그인");
		BtnLogin.setFont(new Font("굴림", Font.PLAIN, 30));
		BtnLogin.setBounds(264, 396, 136, 41);
		BtnLogin.setBackground(new Color(153, 204, 255));
		frame.getContentPane().add(BtnLogin);
		
		BtnClear = new JButton("취소");
		BtnClear.setBounds(499, 396, 136, 41);
		BtnClear.setFont(new Font("굴림", Font.PLAIN, 30));
		BtnClear.setBackground(new Color(153, 204, 255));
		frame.getContentPane().add(BtnClear);
		
//		server.setGUI(this);
//		server.setting();
		
		BtnLogin.addActionListener(this);
		BtnClear.addActionListener(this);
		JCom.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(BtnLogin)) {
			if(Check==true) {
				//회원
				String id=IDText.getText();
				String pwd=PWDText.getText();
				
				
				boolean Check = MemberLoginDb.Setting(id , pwd);
				
				if (Check) {
					JOptionPane.showMessageDialog(null, "확인되었습니다.", "알림 창", JOptionPane.WARNING_MESSAGE);
					new TimeInsert(true,Name);
					frame.dispose();
				} else if (!Check) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인 해주세요", "알림 창", JOptionPane.WARNING_MESSAGE);
				}
//				client.setGui(this);
//				client.setCheckUser(id, pwd);
//				client.Userconnet();
			
			}else if(Check==false){
				//비회원
				String Number=JCom.getSelectedItem().toString();
				String Name=IDText.getText();
//				
//				client.setGui(this);
//				client.setCheckNoUser(Number ,Name);
//				client.NoUserconnet();
				
				new TimeInsert(false,index);
				frame.dispose();
			}
			
		}else if(e.getSource().equals(BtnClear)) {
			
		}else if(e.getSource().equals(JCom)) {
			index = JCom.getSelectedIndex();
		}
	}

	
	public void appendCheck(PCServerBackGround PCServer, String msg) {
		// TODO Auto-generated method stub
		//데이터 베이스가 있어야 실행 가능.
		
	}

	public void appendMsg(ClientBackGround Client , String msg2) {
		// TODO Auto-generated method stub
		
	}
	
}
