package java�ǽ�_applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ī�����ó�� ���� ������ �������� �������� �ѹ� Ŭ���ϸ� ���� ��ȣ�� ��ư�� ����
public class CardLayouttest extends Applet implements ActionListener
{
	CardLayout card=new CardLayout();
	
	public void init() {
		setLayout(card);
		
		for(int i=1;i<5;i++) {
			Button b=new Button("��ư # "+i);
			b.addActionListener(this);
			add("BUTTON-"+i,b);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		card.next(this);
	}
}
