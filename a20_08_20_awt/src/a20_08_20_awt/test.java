package a20_08_20_awt;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Label;

public class test extends Applet 
{
	Label lbl1,lbl2,lbl3;//���� ����
	
	public void init() {//�޼ҵ�ȿ� �����ϸ� ��������
		lbl1=new Label("c���");
		lbl2=new Label();
		lbl3=new Label("jsp���",Label.RIGHT);
		
		lbl2.setText("�ڹ�");
		lbl1.setBackground(Color.blue);
		lbl2.setBackground(Color.red);
		lbl3.setBackground(Color.YELLOW);
		
		lbl1.setAlignment(Label.CENTER);
		lbl2.setAlignment(Label.LEFT);
		
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
	}
	
	public void start() {
		
	}
}
