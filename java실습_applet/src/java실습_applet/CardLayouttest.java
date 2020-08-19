package java실습_applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//카드게임처렁 한장 뽑으면 다음장이 나오듯이 한번 클릭하면 다음 번호의 버튼이 나옴
public class CardLayouttest extends Applet implements ActionListener
{
	CardLayout card=new CardLayout();
	
	public void init() {
		setLayout(card);
		
		for(int i=1;i<5;i++) {
			Button b=new Button("버튼 # "+i);
			b.addActionListener(this);
			add("BUTTON-"+i,b);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		card.next(this);
	}
}
