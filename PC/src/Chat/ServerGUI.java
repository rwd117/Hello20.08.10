package Chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGUI extends JFrame implements ActionListener{
	
	JTextArea ta = new JTextArea(40,25);
	
	JTextField tf=new JTextField(25); 
	ServerBackGround2 server =new ServerBackGround2();
	//연동하기
	public ServerGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("서");
		
		
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);
		

		server.setGUI(this);
		server.setting();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerGUI();
	}
	
	public void appendMsg(String msg) {
		ta.append(msg);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg="관리자 : " + tf.getText()+"\n";
		ta.append(msg);
		tf.setText("");
		server.sendMessage(msg);//서버의 아웃으로
	}

}
