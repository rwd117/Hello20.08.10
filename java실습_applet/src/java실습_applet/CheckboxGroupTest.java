package java�ǽ�_applet;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
//�̰͵� üũ�� ������. ���⼭�� ��� �ѱ׷쿡 3���� ���������� 3���߿� �ϳ��� ���϶� ��� �ǹ�
//üũ �ڽ��� �׸� üũ�ڽ��׷��� ���׶��, ���̴� üũ�ڽ��� �������� ���� üũ�ڽ� �׷��� �׷��� �� 1
public class CheckboxGroupTest extends Applet implements ItemListener 
{
	Label myLabel;
	Checkbox myCheckbox1,myCheckbox2,myCheckbox3;
	CheckboxGroup group;
	
	public void init() {
		
		group=new CheckboxGroup();
		
		myCheckbox1=new Checkbox("c���",false,group);
		myCheckbox1.addItemListener(this);
		add(myCheckbox1);
		
		myCheckbox2=new Checkbox("c++���",group,false);
		myCheckbox2.addItemListener(this);
		add(myCheckbox2);
		
		myCheckbox3=new Checkbox("�ڹ�",group,true);//true �� ���������� üũ �Ǿ��ִ� �κ�
		myCheckbox3.addItemListener(this);
		add(myCheckbox3);
	
		myLabel=new Label();
		myLabel.setText("üũ �ڽ� ����");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.yellow);
		add(myLabel);
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==myCheckbox1) {myLabel.setText("c��� ����");}
		else if(e.getSource()==myCheckbox2) {myLabel.setText("c++��� ����");}
		else if(e.getSource()==myCheckbox3) {myLabel.setText("�ڹ� ����");}
	}


}
