package java�ǽ�_applet;

import java.applet.Applet;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//��ũ�ѹ�(�⵵,��,�� ���� ��) ���ܼ� �ű⼭ �ϳ� �����ϴ� ��. ������ ������ �Ʒ���. ��, �ȳ�Ÿ���� �ϴ¹���� ���ߴ�?
public class Choicetest extends Applet implements ItemListener
{
	Label myLabel;
	Choice myChoice;
	
	public void init(){
		myChoice=new Choice();
		myChoice.addItem("c���");
		myChoice.addItem("c++���");
		myChoice.addItem("�ڹ�");
		myChoice.addItemListener(this);
		add(myChoice);
		
		myLabel=new Label();
		myLabel.setText("���̽� �׸��� ����");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.yellow);
		add(myLabel);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==myChoice) {
			myLabel.setText("����:"+myChoice.getSelectedItem());
		}
	}
}
