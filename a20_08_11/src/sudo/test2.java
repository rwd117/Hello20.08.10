package sudo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class test2 extends JFrame implements ActionListener {
	JFrame frame=new JFrame();
	JButton btn;
	private ClientBackGround client = new ClientBackGround();
	ServerBackGround server =new ServerBackGround();
	private static String nickname="¥���� Ʈ����";
	
	public test2() {
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBounds(200,100,400,600);
		frame.setTitle("222222222222222222222");
		
		btn=new JButton("���� ����������");
		frame.add(btn,BorderLayout.CENTER);
		
		btn.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btn)) {
			server.setGUI(this);
			server.setting();
			client.setGui(this);
			client.setNickname(nickname);
			client.connet();
			//���� Ŭ���̾�Ʈ���� �̰Ÿ� �д´�!
		}
	}
	
	
}
