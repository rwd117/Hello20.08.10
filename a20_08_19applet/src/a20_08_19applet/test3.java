package a20_08_19applet;

import java.applet.Applet;
import java.awt.Label;
import java.awt.TextField;

public class test3 extends Applet 
{
	Label lbl1,lbl2;
	TextField txt1,txt2;
	
	public void init() {
		lbl1= new Label("이름");
		lbl2=new Label("아이디");	
		txt1=new TextField(10);
		txt2=new TextField(10);
		this.add(lbl1);
		this.add(txt1);
		this.add(lbl2);
		this.add(txt2);
		txt1.setText("홍길동");
		txt2.setText("rwd");
	}
	public void start() {
		txt1.setText("");
		txt2.setText("");
	}
	public void stop() 
	{
		
	}
	public void destory() 
	{}


}
