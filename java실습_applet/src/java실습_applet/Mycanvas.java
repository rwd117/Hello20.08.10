package java�ǽ�_applet;

import java.awt.*;

public class Mycanvas extends Canvas
{
	public Mycanvas() {
		setBackground(Color.green);
		setSize(100,100);
	}//ĵ���� ũ�� 
	
	public void paint(Graphics e) {
		e.drawString("�� ĵ����", 10, 20);
		e.drawOval(40, 40, 50, 50);
		e.drawLine(30, 30, 60, 60);
		e.drawRect(0, 0, 99, 99);
	}
}
