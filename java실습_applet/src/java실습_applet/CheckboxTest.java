package java실습_applet;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// 체크하는 창을 만들어서 마지막에 체크한 부분을 라벨부분에 표시.
//체크 박스는 네모 체크박스그룹은 동그라미, 차이는 체크박스는 복수선택 가능 체크박스 그룹은 그룸중 택 1
//itemlistener도 액션과 유사함. 누르면 라벨에 나타남.
public class CheckboxTest extends Applet implements ItemListener
{
	Label myLabel;
	Checkbox myCheckbox1,myCheckbox2,myCheckbox3;
	
	public void init() {
		myCheckbox1=new Checkbox();
		myCheckbox1.setLabel("c언어");
		myCheckbox1.addItemListener(this);
		add(myCheckbox1);
		
		myCheckbox2=new Checkbox("C++언어");
		myCheckbox2.addItemListener(this);
		add(myCheckbox2);
		
		myCheckbox3=new Checkbox("자바",true);
		//true 체크를 한 상태로 
		//구현하면 체크 된 상태로 구현됨.
		myCheckbox3.addItemListener(this);
		add(myCheckbox3);
		
		myLabel=new Label();
		myLabel.setText("체크 박스를 선택");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.yellow);
		add(myLabel);
	}
	
	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource()==myCheckbox1) {
			myLabel.setText("선택:C언어");
		 }else if(e.getSource()==myCheckbox2) {
				myLabel.setText("선택:C++언어");
			}else {
				myLabel.setText("선택:자바");
			}
	}
	
}
