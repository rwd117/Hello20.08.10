package java실습_applet;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
//이것도 체크가 구현됨. 여기서의 경우 한그룹에 3개의 예가있으니 3개중에 하나를 택하라 라는 의미
//체크 박스는 네모 체크박스그룹은 동그라미, 차이는 체크박스는 복수선택 가능 체크박스 그룹은 그룸중 택 1
public class CheckboxGroupTest extends Applet implements ItemListener 
{
	Label myLabel;
	Checkbox myCheckbox1,myCheckbox2,myCheckbox3;
	CheckboxGroup group;
	
	public void init() {
		
		group=new CheckboxGroup();
		
		myCheckbox1=new Checkbox("c언어",false,group);
		myCheckbox1.addItemListener(this);
		add(myCheckbox1);
		
		myCheckbox2=new Checkbox("c++언어",group,false);
		myCheckbox2.addItemListener(this);
		add(myCheckbox2);
		
		myCheckbox3=new Checkbox("자바",group,true);//true 는 실행했으시 체크 되어있는 부분
		myCheckbox3.addItemListener(this);
		add(myCheckbox3);
	
		myLabel=new Label();
		myLabel.setText("체크 박스 선택");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.yellow);
		add(myLabel);
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==myCheckbox1) {myLabel.setText("c언어 선택");}
		else if(e.getSource()==myCheckbox2) {myLabel.setText("c++언어 선택");}
		else if(e.getSource()==myCheckbox3) {myLabel.setText("자바 선택");}
	}


}
