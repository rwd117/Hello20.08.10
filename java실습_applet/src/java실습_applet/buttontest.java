package java�ǽ�_applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//��ư�� �����ؼ� �� ��ư�� ������ �󺧺κп� �������� ���� ��ư�� �̸��� ��Ÿ��
public class buttontest  extends Applet implements ActionListener
{
	Label mylabel;
	Button mybutton1,mybutton2,mybutton3;
	
	public void init() {
		mybutton1=new Button();
		mybutton1.setLabel("c���");
		mybutton1.addActionListener(this);//��ư�� �����鼭 �󺧿� �ؽ�Ʈ�� ��Ÿ����.
		add(mybutton1);
		
		mybutton2=new Button("c++���");
		mybutton2.addActionListener(this);
		add(mybutton2);
		
		mybutton3=new Button("�ڹ�");
		mybutton3.addActionListener(this);
		add(mybutton3);
		
		mylabel=new Label();
		mylabel.setText("��ư�� ����������");
		mylabel.setAlignment(Label.CENTER);
		mylabel.setBackground(Color.yellow);
		add(mylabel);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==mybutton1) {
			mylabel.setText("����:c���");
			}
			else if(e.getSource()==mybutton2) 
			{
				mylabel.setText("����:c++���");
			}
			else {
				mylabel.setText("����: �ڹ�");
				}
			}
		
	}
	

