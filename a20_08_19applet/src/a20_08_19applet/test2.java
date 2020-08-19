package a20_08_19applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class test2 extends Applet 
{
	public void paint(Graphics g) 
	{
		g.setColor(Color.GRAY);
		g.drawLine(50,100,150,100);// 좌표 앞 2개 뒤2개 
		g.drawRect(250, 100, 100, 100);//앞 좌표 2개는 시작점, 가로, 세로, 사각형
		g.fillRect(250, 300, 100, 100);//색채운 사각형 
		g.drawOval(450, 100, 100, 100);//도옹그라아아미이이 , 앞2개의 좌표는 시작점,가로,세로
	
		int x[]= {650,600,800};
		int y[]= {100,200,200};
		
		g.drawPolygon(x,y,3);//650,100 600,200 800,300 이 세트 삼각형,3개의 꼭지
	}
	
}
