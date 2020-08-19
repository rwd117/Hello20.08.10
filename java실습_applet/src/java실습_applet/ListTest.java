package java실습_applet;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
//스크롤 항목 나타나서 그중에서 하나를 선택 하는 에플릿
public class ListTest extends Applet implements ActionListener, ItemListener 
{
	Label myLabel;
	List myList;
	
	public void init() {
		myList=new List(3, false);
		myList.add("c언어");
		myList.add("c++언어");
		myList.add("자바");
		myList.add("파스칼");
		myList.addActionListener(this);
		myList.addItemListener(this);
		add(myList);
		
		myLabel=new Label();
		myLabel.setText("리스트 항목을 선택");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.YELLOW);
		add(myLabel);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myList) {
			myLabel.setText("더블클릭:"+myList.getSelectedItem());
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==myList) {
			myLabel.setText("클릭:"+myList.getSelectedItem());
		}
	}
}