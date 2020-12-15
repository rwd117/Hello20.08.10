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
import Main.MainPc;

public class TimeNoUserLogin implements ActionListener{
	private JFrame frame;
	private JTextField PWDText;
	private JButton BtnLogin, BtnClear;
	private JLabel IDlb, Namelb;
	private JComboBox JCom;
	private int index;
	private boolean Check = true;
	private String Name = "아무개";
//	private ClientBackGround client=new ClientBackGround();
//	private PCServerBackGround server=new PCServerBackGround();
	private String msg;

	
	
	public TimeNoUserLogin() {
			initialize();
		}

	

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 100, 966, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(051, 051, 051));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		IDlb = new JLabel("카드 번호");
		IDlb.setForeground(Color.WHITE);
		IDlb.setFont(new Font("굴림", Font.PLAIN, 20));
		IDlb.setBounds(212, 202, 150, 33);
		frame.getContentPane().add(IDlb);

		Namelb = new JLabel("회원 이름");
		Namelb.setForeground(Color.WHITE);
		Namelb.setFont(new Font("굴림", Font.PLAIN, 20));
		Namelb.setBounds(212, 303, 184, 33);
		frame.getContentPane().add(Namelb);

		String[] Combo = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20" };

		JCom = new JComboBox(Combo);
		JCom.setBounds(442, 200, 246, 41);
		frame.getContentPane().add(JCom);
		JCom.setVisible(true);
		
		PWDText = new JTextField();
		PWDText.setBounds(442, 307, 246, 41);
		PWDText.selectAll();
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

		if (e.getSource().equals(BtnLogin)) {
				
//				client.setGui(this);
//				client.setCheckUser(id, pwd);
//				client.Userconnet();
				frame.dispose();
		} else if (e.getSource().equals(BtnClear)) {
			int result = JOptionPane.showConfirmDialog(null, "홈 화면으로 돌아 가시겠습니까?", "확인 메시지",
					JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
					Clear();
			} else if (result == JOptionPane.YES_OPTION) {
					new MainPc();
					frame.dispose();
			}
		} else if (e.getSource().equals(JCom)) {
		
		}
	}
	
	public void Clear() {
		PWDText.setText("");
	}
}
