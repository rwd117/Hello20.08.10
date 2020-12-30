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

public class PwdUpdate extends JFrame implements ActionListener{
	
	private JFrame frame= new JFrame();
	private JTextField tfid,tfname;
	private JButton btnok,btnno;
	
	public PwdUpdate() {
		init();
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
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(76, 76, 69, 15);
		lblNewLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setBounds(76, 127, 69, 15);
		lblNewLabel_1.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfid = new JTextField();
		tfid.setBounds(202, 73, 156, 21);
		frame.getContentPane().add(tfid);
		tfid.setColumns(10);
		
		tfname = new JTextField();
		tfname.setColumns(10);
		tfname.setBounds(202, 124, 156, 21);
		frame.getContentPane().add(tfname);
		
		btnok.addActionListener(this);
		btnno.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnok)) {
			String id=tfid.getText();
			String name=tfname.getText();
			int check=UserDb.UserCheck(id,name);
			if(check==1) {
				new PwdUpdate2(id);
				frame.dispose();
			}else {
				JOptionPane.showMessageDialog(null,"아이디와 이름을 확인 해 주세요!");
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
