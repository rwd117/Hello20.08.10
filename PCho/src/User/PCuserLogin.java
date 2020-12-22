package User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Db.PCSeatDb;
import Db.UserDb;
import Main.MainPc;
import Set.AllNum;

public class PCuserLogin extends JFrame implements ActionListener {

	private JFrame frame;
	private JTextField IDText;
	private JPasswordField PWDText;
	private JButton BtnLogin, BtnClear;
	private JLabel IDlb, PWDlb, pcseat;
	private JComboBox Jcom;
	private String Pccombo;
	private ArrayList<String> PCNum;
	private String PC[];
//	private ClientBackGround client=new ClientBackGround();
//	private PCServerBackGround server=new PCServerBackGround();

	public PCuserLogin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 100, 966, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(051, 051, 051));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		pcseat = new JLabel("pc방 자리");
		pcseat.setForeground(Color.WHITE);
		pcseat.setFont(new Font("굴림", Font.PLAIN, 20));
		pcseat.setBounds(244, 101, 89, 33);
		frame.getContentPane().add(pcseat);

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

		PCNum=AllNum.PCNum(PCNum);
		PC=PCNum.toArray(new String[PCNum.size()]);
		
		Jcom = new JComboBox(PC);
		Jcom.setBounds(442, 101, 246, 41);
		frame.getContentPane().add(Jcom);
		Jcom.setVisible(true);

		IDText = new JTextField();
		IDText.setBounds(442, 200, 246, 41);
		IDText.selectAll();
		frame.getContentPane().add(IDText);

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
		Jcom.addActionListener(this);

	}

	public void Clear() {
		IDText.setText("");
		PWDText.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = IDText.getText();
		String pwd = PWDText.getText();
		if (e.getSource().equals(BtnLogin)) {
			if (id.equals("") || id.equals(null)) {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인 해주세요", "알림 창", JOptionPane.WARNING_MESSAGE);
				return;
			} else if (pwd.equals("") || pwd.equals(null)) {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인 해주세요", "알림 창", JOptionPane.WARNING_MESSAGE);
				return;
			} else if(Pccombo.equals("")||Pccombo.equals(null)||Pccombo.equals("좌석을 골라주세요")) {
				JOptionPane.showMessageDialog(null, "좌석을 선택해주세요", "알림 창", JOptionPane.WARNING_MESSAGE);
				return;
			}else if ((!id.equals("")) && (!id.equals(null)) && (!pwd.equals("")) && (!pwd.equals(null))) {

				// 회원
				boolean Check = UserDb.UserLogin(id, pwd);
				if (Check) {
					JOptionPane.showMessageDialog(null, "확인되었습니다.", "알림 창", JOptionPane.WARNING_MESSAGE);
					PCSeatDb.PCSeatSub(Pccombo);
					UserDb.Useradd(id);
					new PCuser(Pccombo,id);
					frame.dispose();
					
				} else if (!Check) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인 해주세요", "알림 창", JOptionPane.WARNING_MESSAGE);
				}
			}
		} else if (e.getSource().equals(BtnClear)) {
			int result = JOptionPane.showConfirmDialog(null, "홈 화면으로 돌아 가시겠습니까?", "확인 메시지", JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
				Clear();
			} else if (result == JOptionPane.YES_OPTION) {
				new MainPc();
				frame.dispose();
			}

		} else if (e.getSource().equals(Jcom)) {
			Pccombo = Jcom.getSelectedItem().toString();

		}
	}

}
