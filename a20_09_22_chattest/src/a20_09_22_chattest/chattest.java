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

public class chattest implements ActionListener, Runnable{

	private JFrame frame;
	private JTextField name;
	private JTextField input;
	JTextArea memo;

	Socket mySocket=null;
	PrintWriter out=null;
	BufferedReader in=null;
	Thread clock;
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public chattest() {
		initialize();
		init();
	}
	
	public void init() {
		try {
			mySocket=new Socket("127.0.0.1",2587);//127.0.0.1
			out=new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream(),"KSC5601"),true);
			in=new BufferedReader(new InputStreamReader(mySocket.getInputStream(),"KSC5601"),1024);
			out.println("LOGIN|"+mySocket);
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		memo = new JTextArea();
		memo.setBounds(12, 10, 559, 301);
		frame.getContentPane().add(memo);
		
		name = new JTextField();
		name.setBounds(40, 354, 116, 21);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		input = new JTextField();
		input.setColumns(10);
		input.setBounds(177, 354, 394, 21);
		frame.getContentPane().add(input);
		
		try {
			while(true) {
				String msg=in.readLine();
				if(!msg.equals("")&&!msg.equals(null)) {
					memo.append(msg+"\n");
				} 
			}
		}catch(Exception e) {
			memo.append(e.toString()+"\n");
		}
		
		input.addActionListener(this);
	}

	@Override
	public void run() {
		
		

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==input) {
			String data=input.getText();
			input.setText("");
			out.println("TALK|"+name.getText()+":"+data);
			out.flush();
		}
	}

}
