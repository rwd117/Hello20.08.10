package a20_09_22_chattest;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class chattest implements ActionListener {
   
	private JFrame frame;
	private JTextField name;
	private JTextField input;
	JTextArea memo;
	JButton btnca;
	private JButton btnco;

	Socket mySocket=null ;
	PrintWriter out=null ;
	BufferedReader in=null ;
	Thread clock;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chattest window = new chattest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public chattest() {
		initialize();
		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		memo = new JTextArea();
		memo.setBounds(12, 10, 559, 301);
		frame.getContentPane().add(memo);
		memo.append("연결을 눌러 주세요\n");
		
		name = new JTextField();
		name.setBounds(40, 354, 116, 21);
		frame.getContentPane().add(name);
		name.setColumns(10);

		input = new JTextField();
		input.setColumns(10);
		input.setBounds(177, 354, 394, 21);
		frame.getContentPane().add(input);

		btnca = new JButton("\uC5F0\uACB0 \uB04A\uAE30");
		btnca.setBounds(323, 385, 97, 23);
		frame.getContentPane().add(btnca);

		btnco = new JButton("\uC5F0\uACB0");
		btnco.setBounds(177, 385, 97, 23);
		frame.getContentPane().add(btnco);
		
		st();
		input.disable();
		name.disable();
		
		btnca.setVisible(false);
		
		
		btnca.addActionListener(this);
		btnco.addActionListener(this);
		input.addActionListener(this);
	}

	public void st() {
		try {
			while (true) {
				String msg = in.readLine();
				if (!msg.equals("") && !msg.equals(null)) {
					memo.append(msg + "\n");
				}
			}
		} catch (Exception e) {
			memo.append(e.toString() + "\n");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input) {
			String data = input.getText();
			input.setText("");
			out.println("TALK|" + name.getText() + ":" + data);
			memo.append("TALK|" + name.getText() + ":" + data + "\n");
			out.flush();
		} else if (e.getSource() == btnca) {
			if ((clock != null) && (clock.isAlive())) {
				clock = null;
			}
			out.println("LOGOUT|" + name.getText());
			memo.append("LOGOUT|" + name.getText()+"\n");
			out.flush();
			try {
				out.close();
				in.close();
				mySocket.close();
				
				name.disable();
				input.disable();
				btnca.disable();
				btnca.setVisible(false);
				btnco.setVisible(true);
			} catch (Exception a) {
				memo.append(a.toString() + "\n");
			}
			

		} else if (e.getSource().equals(btnco)) {
				
			try {
				mySocket = new Socket("127.0.0.1", 2587);// 127.0.0.1
				out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream(), "KSC5601"), true);
				in = new BufferedReader(new InputStreamReader(mySocket.getInputStream(), "KSC5601"), 1024);
				out.println("LOGIN|" + mySocket);
				memo.append("LOGIN|" + mySocket + "\n");
				memo.append("접속\n");
				
				input.enable();
				name.enable();
				btnco.disable();
				btnco.setVisible(false);
				btnca.setVisible(true);
				
				
			} catch (Exception c) {
				System.out.println(c.toString());
			}
			
		}
	}
}
