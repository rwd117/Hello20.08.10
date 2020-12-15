package Chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends JFrame implements ActionListener {
	
	private JTextArea ta = new JTextArea(40, 25);
 
	private JTextField tf = new JTextField(25);
	
	private ClientBackGround2 client = new ClientBackGround2();
	
	private static String nickname;
	
	public ClientGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("클");
		
		add(ta,BorderLayout.CENTER);
		add(tf,BorderLayout.SOUTH);
		tf.addActionListener(this);
	
		client.setGui(this);
		client.setNickname(nickname);
		client.connet();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("너의 이름은");
		Scanner sc=new Scanner(System.in);
		nickname = sc.nextLine();
		sc.close();
		new ClientGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = nickname+ ":" + tf.getText() + "\n";
		tf.setText("");
		client.sendMessage(msg);
	}

	public void appendMsg(String msg) {
		// TODO Auto-generated method stub
		ta.append(msg);
	}

}
