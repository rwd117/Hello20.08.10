package java실습_applet;

import java.applet.Applet;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//스크롤바(년도,월,일 고르는 거) 생겨서 거기서 하나 선택하는 것. 순서는 위에서 아래로. 단, 안나타나게 하는방법은 몰긋다?
public class Choicetest extends Applet implements ItemListener
{
	Label myLabel;
	Choice myChoice;
	
	public void init(){
		myChoice=new Choice();
		myChoice.addItem("c언어");
		myChoice.addItem("c++언어");
		myChoice.addItem("자바");
		myChoice.addItemListener(this);
		add(myChoice);
		
		myLabel=new Label();
		myLabel.setText("초이스 항목을 선택");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.yellow);
		add(myLabel);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==myChoice) {
			myLabel.setText("선택:"+myChoice.getSelectedItem());
		}
	}
}
