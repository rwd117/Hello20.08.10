package java�ǽ�_applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Label;

public class labeltest extends Applet
{
	Label myLabel1,myLabel2,myLabel3;
	public void init() {
		myLabel1=new Label();
		myLabel1.setText("c���");
		myLabel1.setAlignment(Label.LEFT);
		myLabel1.setBackground(Color.CYAN);
		add(myLabel1);
		
		myLabel2=new Label("c++���");
		myLabel2.setAlignment(Label.CENTER);
		myLabel2.setBackground(Color.green);
		add(myLabel2);
		
		myLabel3=new Label("�ڹ�",Label.RIGHT);
		myLabel3.setBackground(Color.yellow);
		add(myLabel3);
	}
}
