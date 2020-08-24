package a20_08_21_event;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttontest extends Applet implements ActionListener 
{
	Button btn1,btn2,btn3;
	TextArea ta;
	String str="";
	
	public	void init() {
		this.setLayout(null);
		
		btn1=new Button("java");
		btn1.setBounds(0,10,50,50);
		add(btn1);
		btn2=new Button("c++");
		btn2.setBounds(100,10,50,50);
		add(btn2);
		btn3=new Button("지우기");
		btn3.setBounds(200,10,50,50);
		add(btn3);
		
		ta=new TextArea(20,10);
		ta.setBackground(Color.yellow);
		ta.setBounds(2,100,200,100);
		add(ta);
		
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			btn1.disable();
			ta.append("자바 :");
			ta.append(btn1.getLabel()+"\n");
			btn2.enable();
			btn3.enable();//btn1을 누르면 1은 누를수 없고 btn2,3 만 선택가능.
		}
		else if(e.getSource()==btn2) {
			btn2.disable();
			ta.append("c++ :");
			ta.append(btn2.getLabel()+"\n");
			btn1.enable();
			btn3.enable();
		}else if(e.getSource()==btn3) {
			btn3.disable();
			str="";
			ta.setText(str);
			btn1.enable();
			btn2.enable();
		}
	}
}
