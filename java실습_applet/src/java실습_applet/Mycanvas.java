package java실습_applet;

import java.awt.*;

public class Mycanvas extends Canvas
{
	public Mycanvas() {
		setBackground(Color.green);
		setSize(100,100);
	}//캔버스 크기 
	
	public void paint(Graphics e) {
		e.drawString("내 캔버스", 10, 20);
		e.drawOval(40, 40, 50, 50);
		e.drawLine(30, 30, 60, 60);
		e.drawRect(0, 0, 99, 99);
	}
}
