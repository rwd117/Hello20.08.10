package java�ǽ�_applet;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// üũ�ϴ� â�� ���� �������� üũ�� �κ��� �󺧺κп� ǥ��.
//üũ �ڽ��� �׸� üũ�ڽ��׷��� ���׶��, ���̴� üũ�ڽ��� �������� ���� üũ�ڽ� �׷��� �׷��� �� 1
//itemlistener�� �׼ǰ� ������. ������ �󺧿� ��Ÿ��.
public class CheckboxTest extends Applet implements ItemListener
{
	Label myLabel;
	Checkbox myCheckbox1,myCheckbox2,myCheckbox3;
	
	public void init() {
		myCheckbox1=new Checkbox();
		myCheckbox1.setLabel("c���");
		myCheckbox1.addItemListener(this);
		add(myCheckbox1);
		
		myCheckbox2=new Checkbox("C++���");
		myCheckbox2.addItemListener(this);
		add(myCheckbox2);
		
		myCheckbox3=new Checkbox("�ڹ�",true);
		//true üũ�� �� ���·� 
		//�����ϸ� üũ �� ���·� ������.
		myCheckbox3.addItemListener(this);
		add(myCheckbox3);
		
		myLabel=new Label();
		myLabel.setText("üũ �ڽ��� ����");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.yellow);
		add(myLabel);
	}
	
	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource()==myCheckbox1) {
			myLabel.setText("����:C���");
		 }else if(e.getSource()==myCheckbox2) {
				myLabel.setText("����:C++���");
			}else {
				myLabel.setText("����:�ڹ�");
			}
	}
	
}
