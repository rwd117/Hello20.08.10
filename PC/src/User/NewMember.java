package User;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Main.MainPc;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

import Main.MainPc;

public class NewMember extends JFrame implements ActionListener {

	private JFrame frame = new JFrame();
	private JTextField Tfid;
	private JPasswordField Tfpwd;
	private JPasswordField TfpwdCheck;
	private JTextField Tfname;
	private JTextField Tfphone;
	private JButton BtnOver, BtnNew, BtnCan;
	private JLabel LBCheck;
	private JCheckBox Check;
	JPanel TopPan, BottomPan;
	private int CheckPoint = 0;

	public NewMember() {
		initialize();
	}

	private void initialize() {
		frame.setBounds(700, 200, 550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		TopPan = new JPanel();
		TopPan.setBounds(0, 0, 534, 99);
		TopPan.setBackground(Color.white);
		frame.getContentPane().add(TopPan);

		BottomPan = new JPanel();
		BottomPan.setBounds(0, 425, 534, 86);
		BottomPan.setBackground(Color.white);
		frame.getContentPane().add(BottomPan);
		TopPan.setLayout(null);

		JLabel LbTitle = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		LbTitle.setForeground(Color.BLACK);
		LbTitle.setFont(new Font("굴림", Font.BOLD, 30));
		LbTitle.setBounds(200, 31, 128, 35);
		TopPan.add(LbTitle);

		JLabel LBid = new JLabel("ID");
		LBid.setFont(new Font("굴림", Font.BOLD, 18));
		LBid.setBounds(160, 130, 35, 29);
		frame.getContentPane().add(LBid);

		JLabel LBpwd = new JLabel("\uBE44\uBC00\uBC88\uD638");
		LBpwd.setFont(new Font("굴림", Font.BOLD, 18));
		LBpwd.setBounds(108, 180, 87, 29);
		frame.getContentPane().add(LBpwd);

		JLabel LBpwdCheck = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		LBpwdCheck.setFont(new Font("굴림", Font.BOLD, 18));
		LBpwdCheck.setBounds(69, 230, 143, 29);
		frame.getContentPane().add(LBpwdCheck);

		JLabel LBphone = new JLabel("\uD578\uB4DC\uD3F0 \uBC88\uD638");
		LBphone.setFont(new Font("굴림", Font.BOLD, 18));
		LBphone.setBounds(85, 330, 110, 29);
		frame.getContentPane().add(LBphone);

		JLabel LBName = new JLabel("\uC774\uB984");
		LBName.setFont(new Font("굴림", Font.BOLD, 18));
		LBName.setBounds(146, 280, 49, 29);
		frame.getContentPane().add(LBName);

		Tfid = new JTextField();
		Tfid.setBounds(223, 136, 143, 23);
		frame.getContentPane().add(Tfid);
		Tfid.setColumns(10);

		Tfpwd = new JPasswordField();
		Tfpwd.setBounds(224, 186, 142, 21);
		Tfpwd.setEchoChar('*');
		frame.getContentPane().add(Tfpwd);

		TfpwdCheck = new JPasswordField();
		TfpwdCheck.setBounds(224, 236, 142, 21);
		TfpwdCheck.setEchoChar('*');
		frame.getContentPane().add(TfpwdCheck);

		Tfname = new JTextField();
		Tfname.setColumns(10);
		Tfname.setBounds(223, 286, 143, 23);
		frame.getContentPane().add(Tfname);

		Tfphone = new JTextField();
		Tfphone.setColumns(10);
		Tfphone.setBounds(223, 336, 143, 23);
		frame.getContentPane().add(Tfphone);

		BtnOver = new JButton("\uC911\uBCF5\uD655\uC778");
		BtnOver.setBounds(393, 135, 87, 23);
		frame.getContentPane().add(BtnOver);

		JLabel lblNewLabel_2 = new JLabel(
				"\uAC1C\uC778\uC815\uBCF4 \uC218\uC9D1\uC5D0 \uB3D9\uC758 \uD558\uC2ED\uB2C8\uAE4C?");
		lblNewLabel_2.setBounds(95, 390, 208, 29);
		frame.getContentPane().add(lblNewLabel_2);
		BottomPan.setLayout(null);

		BtnNew = new JButton("\uD68C\uC6D0\uAC00\uC785");
		BtnNew.setBounds(141, 27, 81, 23);
		BottomPan.add(BtnNew);

		BtnCan = new JButton("\uCDE8\uC18C");
		BtnCan.setBounds(309, 27, 57, 23);
		BottomPan.add(BtnCan);

//		Check = new JButton("\uB0B4\uC6A9 \uD655\uC778");
//		Check.setBounds(291, 393, 97, 23);
//		frame.getContentPane().add(Check);

		LBCheck = new JLabel("");
		LBCheck.setBounds(414, 397, 57, 15);
		frame.getContentPane().add(LBCheck);

		Check = new JCheckBox("\uB3D9\uC758\uD569\uB2C8\uB2E4");
		Check.setBounds(301, 393, 115, 23);
		Check.setBackground(Color.white);
		frame.getContentPane().add(Check);

		BtnOver.addActionListener(this);
		BtnNew.addActionListener(this);
		BtnCan.addActionListener(this);
		Check.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String pwd=Tfpwd.getText();
		String pwdCheck=TfpwdCheck.getText();
		
		if (e.getSource().equals(Check)) {
			Check.setSelected(false);
			int result = JOptionPane.showConfirmDialog(null, "개인정보 수집에 동의 하시겠습니까?", "확인 메시지",
					JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
				Check.setSelected(false);
				CheckPoint = 0;
			} else if (result == JOptionPane.YES_OPTION) {
				Check.setSelected(true);
				CheckPoint = 1;
			}

		} else if (e.getSource().equals(BtnCan)) {
			int result = JOptionPane.showConfirmDialog(null, "홈 화면으로 돌아가시겠습니까?", "확인 메시지", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {

			} else if (result == JOptionPane.YES_OPTION) {
				new MainPc();
			}
		} else if (e.getSource().equals(BtnNew)) {
			if ((CheckPoint == 0) || (!pwdCheck.equals(pwd)) || (pwdCheck.equals("")) || (pwd.equals(""))) {
				if (CheckPoint == 0) {
					JOptionPane.showMessageDialog(null, "개인정보 수집에 동의 해주세요", "알림 창", JOptionPane.WARNING_MESSAGE);
					return;
				} else if ((!pwdCheck.equals(pwd)) || (pwdCheck.equals("")) || (pwd.equals(""))||(pwdCheck.equals(null))||(pwd.equals(null))) {
					if ((pwdCheck.equals("")) || pwdCheck.equals(null) || (pwd.equals(""))|| (pwd.equals(null))) {
						JOptionPane.showMessageDialog(null, "비밀번호에 공백이 있습니다.", "알림 창", JOptionPane.WARNING_MESSAGE);
						return;
					} else if (!pwdCheck.equals(pwd)) {
						JOptionPane.showMessageDialog(null, "비밀번호가 서로 다릅니다!", "알림 창", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "회원 가입 성공");
				frame.dispose();
				new MainPc();
			}
		} else if (e.getSource().equals(BtnOver)) {
			// 아이디 중복확인, BtnNew에서도 체크 해줘야함,데이터베이스 만든 
		}
	}
}
