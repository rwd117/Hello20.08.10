package a20_08_19applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class test extends Applet //init start//�ٸ� �۾���//stop destroy ������ ����
{
	@Override
	public void paint(Graphics g) {
		Color c=new Color(255,0,0); //��,��,��, ���� 3���� ���δ� �ִ�� ���0~255
		Font f=new Font("�ü�",Font.BOLD, 15); //�۾�ü, ���� ����, ũ��
		g.setColor(c);
		g.setFont(f);
		g.drawString("�ѱ�", 100, 100);
		
		Color c2=Color.blue;
		Font f2=new Font("�޸ո���ü",Font.BOLD, 30);
		g.setColor(c2);
		g.setFont(f2);
		g.drawString("����", 100, 200);
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
