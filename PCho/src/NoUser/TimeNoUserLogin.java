package NoUser;

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
import javax.swing.JTextField;

import Main.MainPc;
import Set.AllNum;

public class TimeNoUserLogin implements ActionListener {
	private JFrame frame;
	private JTextField NameText;
	private JButton BtnLogin, BtnClear;
	private JLabel IDlb, Namelb;
	private JComboBox JCom;
	private ArrayList<String> CardNum;
	private String Card[];
	private String Cardcombo="";

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
		
		CardNum=AllNum.CardNum(CardNum);
		Card=CardNum.toArray(new String[CardNum.size()]);
		
		JCom = new JComboBox(Card);
		JCom.setBounds(442, 200, 246, 41);
		frame.getContentPane().add(JCom);
		JCom.setVisible(true);

		NameText = new JTextField();
		NameText.setBounds(442, 307, 246, 41);
		NameText.selectAll();
		frame.getContentPane().add(NameText);

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
		String name=NameText.getText();
		
		if (e.getSource().equals(BtnLogin)) {
			if (Cardcombo.equals(null) || Cardcombo.equals("") || Cardcombo.equals("카드 번호를 골라주세요")) {
				JOptionPane.showMessageDialog(null, "카드번호 를 선택해 주세요", "알림 창", JOptionPane.WARNING_MESSAGE);
				return;
			}else if(name.equals("")||name.equals(null)) {
				JOptionPane.showMessageDialog(null, "이름을 적어주세요", "알림 창", JOptionPane.WARNING_MESSAGE);
				return;
			}else {
				new TimeNoUserInsert(Cardcombo,name);
				frame.dispose();	
			}
			
		} else if (e.getSource().equals(BtnClear)) {
			int result = JOptionPane.showConfirmDialog(null, "홈 화면으로 돌아 가시겠습니까?", "확인 메시지", JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {
				Clear();
			} else if (result == JOptionPane.YES_OPTION) {
				new MainPc();
				frame.dispose();
			}
		} else if (e.getSource().equals(JCom)) {
			Cardcombo = JCom.getSelectedItem().toString();
		}
	}

	public void Clear() {
		NameText.setText("");
	}
}
