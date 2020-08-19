package java�ǽ�_applet;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
//��ũ�� �׸� ��Ÿ���� ���߿��� �ϳ��� ���� �ϴ� ���ø�
public class ListTest extends Applet implements ActionListener, ItemListener 
{
	Label myLabel;
	List myList;
	
	public void init() {
		myList=new List(3, false);
		myList.add("c���");
		myList.add("c++���");
		myList.add("�ڹ�");
		myList.add("�Ľ�Į");
		myList.addActionListener(this);
		myList.addItemListener(this);
		add(myList);
		
		myLabel=new Label();
		myLabel.setText("����Ʈ �׸��� ����");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.YELLOW);
		add(myLabel);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==myList) {
			myLabel.setText("����Ŭ��:"+myList.getSelectedItem());
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==myList) {
			myLabel.setText("Ŭ��:"+myList.getSelectedItem());
		}
	}
}