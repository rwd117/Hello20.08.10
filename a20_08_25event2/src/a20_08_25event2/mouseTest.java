package a20_08_25event2;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class mouseTest extends Applet implements MouseListener
{
	JLabel lbl1; 
	int num; //ī����
	int x[],y[]; //x��� y��
	
	public void init() {
		
		setLayout(new BorderLayout());
		
		lbl1=new JLabel("Ŭ���� ��");
		
		add("South",lbl1);
		
		num=0;
		x=new int[100];
		y=new int[100];
		this.addMouseListener(this);
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		for(int i=0;i<num;i++) {
			g.fillOval(x[i]-20, y[i]-20, 40, 40);	
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Ȯ��");
		System.out.println(e.getX());
		System.out.println(e.getY());
		if(num<100) {
			x[num]=e.getX();
			y[num]=e.getY();
			num++;
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
