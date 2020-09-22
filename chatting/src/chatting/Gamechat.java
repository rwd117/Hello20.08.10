package chatting;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Gamechat extends Applet implements ActionListener, Runnable
{
	Socket mySocket=null;
	PrintWriter out=null;
	BufferedReader in=null;
	Thread clock;
	
	TextArea memo;
	TextField name;
	TextField input;
	Panel myPanel;
	
	public void init() {
		try {
			mySocket=new Socket("192.168.0.6",2587);//127.0.0.1
			out=new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream(),"KSC5601"),true);
			in=new BufferedReader(new InputStreamReader(mySocket.getInputStream(),"KSC5601"),1024);
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	setLayout(new BorderLayout());
	memo=new TextArea(10,55);
	add("Center",memo);
	
	myPanel=new Panel();
	name=new TextField(8);
	name.setText("대화명");
	myPanel.add(name);
	input=new TextField(40);
	input.addActionListener(this);
	myPanel.add(input);
	add("South",myPanel);
	}
	
	public void start() {
		if(clock==null) {
			clock=new Thread(this);
			clock.start();
		}
	}
	
	public void run() {
		out.println("LOGIN|"+mySocket);
		memo.append("[접속]"+getCodeBase().toString()+"\n");
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
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==input) {
			String data=input.getText();
			input.setText("");
			out.println("TALK|"+name.getText()+":"+data);
			out.flush();
		}
	}
	
	public void stop() {
		if((clock!=null)&&(clock.isAlive())) {
			clock=null;
		}
		
		out.println("LOGOUT|"+name.getText());
		out.flush();
		try {
			out.close();
			in.close();
			mySocket.close();
		}catch(Exception e) {
			memo.append(e.toString()+"\n");
		}
	}
}
