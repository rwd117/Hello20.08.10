package a20_08_20_awt;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Label;

public class test extends Applet 
{
	Label lbl1,lbl2,lbl3;//전역 변수
	
	public void init() {//메소드안에 정의하면 지역변수
		lbl1=new Label("c언어");
		lbl2=new Label();
		lbl3=new Label("jsp언어",Label.RIGHT);
		
		lbl2.setText("자바");
		lbl1.setBackground(Color.blue);
		lbl2.setBackground(Color.red);
		lbl3.setBackground(Color.YELLOW);
		
		lbl1.setAlignment(Label.CENTER);
		lbl2.setAlignment(Label.LEFT);
		
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
	}
	
	public void start() {
		
	}
}
