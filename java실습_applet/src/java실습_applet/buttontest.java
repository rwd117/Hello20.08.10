package java실습_applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//버튼을 구현해서 그 버튼을 누르면 라벨부분에 마지막에 누른 버튼의 이름이 나타남
public class buttontest  extends Applet implements ActionListener
{
	Label mylabel;
	Button mybutton1,mybutton2,mybutton3;
	
	public void init() {
		mybutton1=new Button();
		mybutton1.setLabel("c언어");
		mybutton1.addActionListener(this);//버튼을 누르면서 라벨에 텍스트가 나타난다.
		add(mybutton1);
		
		mybutton2=new Button("c++언어");
		mybutton2.addActionListener(this);
		add(mybutton2);
		
		mybutton3=new Button("자바");
		mybutton3.addActionListener(this);
		add(mybutton3);
		
		mylabel=new Label();
		mylabel.setText("버튼을 눌러보세요");
		mylabel.setAlignment(Label.CENTER);
		mylabel.setBackground(Color.yellow);
		add(mylabel);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==mybutton1) {
			mylabel.setText("선택:c언어");
			}
			else if(e.getSource()==mybutton2) 
			{
				mylabel.setText("선택:c++언어");
			}
			else {
				mylabel.setText("선택: 자바");
				}
			}
		
	}
	

