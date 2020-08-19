package java실습_applet;

import java.applet.*;
import java.awt.*;

public class ContainerTest extends Applet 
{
	Button myButton1, myButton2;
	Label myLabel;
	Panel p1,p2;
	
	public void init() {
		p1=new Panel();
		p1.setBackground(Color.cyan);
		myButton1=new Button("버튼#1");
		p1.add(myButton1);
		myButton2=new Button("버튼#2");
		p1.add(myButton2);
		add(p1);
		
		p2=new Panel();
		p2.setBackground(Color.red);
		myLabel=new Label("레이블",Label.CENTER);
		myLabel.setBackground(Color.yellow);
		p2.add(myLabel);
		add(p2);
		
		
	}
}
