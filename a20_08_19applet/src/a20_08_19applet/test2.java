package a20_08_19applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class test2 extends Applet 
{
	public void paint(Graphics g) 
	{
		g.setColor(Color.GRAY);
		g.drawLine(50,100,150,100);// ��ǥ �� 2�� ��2�� 
		g.drawRect(250, 100, 100, 100);//�� ��ǥ 2���� ������, ����, ����, �簢��
		g.fillRect(250, 300, 100, 100);//��ä�� �簢�� 
		g.drawOval(450, 100, 100, 100);//���˱׶�ƾƹ����� , ��2���� ��ǥ�� ������,����,����
	
		int x[]= {650,600,800};
		int y[]= {100,200,200};
		
		g.drawPolygon(x,y,3);//650,100 600,200 800,300 �� ��Ʈ �ﰢ��,3���� ����
	}
	
}
