package a20_08_20_awt;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buttontest extends Applet implements ActionListener  
{
	Button btn1,btn2,btn3;
	public void init() {
		btn1=new Button();
		btn2=new Button();
		btn3=new Button("파이썬");
		btn1.setLabel("자바");
		btn2.setLabel("c++");
		
		btn1.setBackground(Color.yellow);
		btn2.setBackground(Color.yellow);
		btn3.setBackground(Color.yellow);
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼1");
		
	}
}
