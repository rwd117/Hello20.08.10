package User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Graphics.RoundedButton;
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
			PWDlb.setText("회원 이름");
			IDText.setVisible(false);
			JCom.setVisible(true);
			
			frame.setResizable(false);
			frame.setVisible(true);
		}
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		BtnLogin.addActionListener(this);
		BtnClear.addActionListener(this);
		JCom.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(BtnLogin)) {
			if(Check==true) {
				new TimeInsert(true,Name);
				frame.dispose();
				
			}else if(Check==false){
				new TimeInsert(false,index);
				frame.dispose();
			}
			
		}else if(e.getSource().equals(BtnClear)) {
			
		}else if(e.getSource().equals(JCom)) {
			index = JCom.getSelectedIndex();
		}
	}
}
