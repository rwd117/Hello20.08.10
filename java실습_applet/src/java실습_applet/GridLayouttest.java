package java�ǽ�_applet;

import java.applet.*;
import java.awt.*;
//flow���� ��ư�� �� ŭ �� ä���� �ϳ���
public class GridLayouttest extends Applet
{
	public void init() {
		setLayout(new GridLayout(0,3));
		
		for(int i=0;i<10;i++) {
			add(new Button("��ư #"+i));
		}
	}
}
