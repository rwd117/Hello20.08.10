package a20_08_19applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class test extends Applet //init start//다른 작업들//stop destroy 순서로 실행
{
	@Override
	public void paint(Graphics g) {
		Color c=new Color(255,0,0); //빨,초,파, 빛의 3원색 전부다 최대면 흰색0~255
		Font f=new Font("궁서",Font.BOLD, 15); //글씨체, 굵기 유무, 크기
		g.setColor(c);
		g.setFont(f);
		g.drawString("한국", 100, 100);
		
		Color c2=Color.blue;
		Font f2=new Font("휴먼매직체",Font.BOLD, 30);
		g.setColor(c2);
		g.setFont(f2);
		g.drawString("연습", 100, 200);
	}
	
	@Override
	public void destroy() {
		System.out.println("d");
	}
	@Override
	public void init() {
		System.out.println("i");
	}
	@Override
	public void start() {
		System.out.println("s");
	}
	@Override
	public void stop() {
		System.out.println("t");
	}
}
