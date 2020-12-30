package User;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Db.UserDb;
import Main.MainPc;

public class PwdUpdate2 extends JFrame implements ActionListener{
	
	private JFrame frame= new JFrame();
	private JTextField tfpwd,tfpwdc;
	private JButton btnok,btnno;
	private String userid;
	
	public PwdUpdate2(String id) {
		init();
		this.userid=id;
	}
	
	private void init() {
		frame = new JFrame();
		frame.setBounds(800, 400, 476, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(051, 051, 051));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		 btnok = new JButton("\uD655\uC778");
		btnok.setBounds(114, 200, 97, 23);
		frame.getContentPane().add(btnok);
		
		 btnno = new JButton("\uCDE8\uC18C");
		btnno.setBounds(247, 200, 97, 23);
		frame.getContentPane().add(btnno);
		
		JLabel lblNewLabel = new JLabel("비밀번호");
		lblNewLabel.setBounds(76, 76, 69, 15);
		lblNewLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호 확인");
		lblNewLabel_1.setBounds(76, 127, 90, 15);
		lblNewLabel_1.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfpwd = new JTextField();
		tfpwd.setBounds(202, 73, 156, 21);
		frame.getContentPane().add(tfpwd);
		tfpwd.setColumns(10);
		
		tfpwdc = new JTextField();
		tfpwdc.setColumns(10);
		tfpwdc.setBounds(202, 124, 156, 21);
		frame.getContentPane().add(tfpwdc);
		
		btnok.addActionListener(this);
		btnno.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnok)) {
			String pwd=tfpwd.getText();
			String pwdc=tfpwdc.getText();
			if(!pwd.equals(pwdc)) {
				JOptionPane.showMessageDialog(null,"비밀번호를 다시 확인 해 주세요!");
				return;
			}else {
				UserDb.Pwdupdate(userid,pwd);
				JOptionPane.showMessageDialog(null,"비밀번호 변경 완료!");
				frame.dispose();
			}
		}else if(e.getSource().equals(btnno)) {
			int result = JOptionPane.showConfirmDialog(null, "홈 화면으로 돌아가시겠습니까?", "확인 메시지", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {

			} else if (result == JOptionPane.YES_OPTION) {
				frame.dispose();
				
			}
		}
	}
	
}
