package a20_08_24;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class awttest2 extends Applet implements AdjustmentListener   
{
	Label lbl1, lbl2, lbl3;
	Scrollbar sc1,sc2,sc3; 
	TextField tf; 
	
	int ir,ig,ib;
	
	public void init() 
	{	this.setLayout(null);
		
		
	
		tf=new TextField();
		tf.setBounds(10,600,100,20);
		add("South", tf);
		
		lbl1=new Label("Red");
		lbl1.setBounds(85,10,50,20);
		add(lbl1);
		
		lbl2=new Label("Green");
		lbl2.setBounds(235,10,50,20);
		add(lbl2);
		
		lbl3=new Label("Blue");
		lbl3.setBounds(385,10,50,20);
		add(lbl3);
		
		sc1=new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,256);
		sc2=new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,256);
		sc3=new Scrollbar(Scrollbar.HORIZONTAL,0,0,0,256);
		
		sc1.setBounds(50,50,100,20);
		sc2.setBounds(200,50,100,20);
		sc3.setBounds(350,50,100,20);
		
		add(sc1);
		add(sc2);
		add(sc3);
		
		sc1.addAdjustmentListener(this);
		sc2.addAdjustmentListener(this);
		sc3.addAdjustmentListener(this);
		
	}
	
	public void paint(Graphics g) {
		g.setColor(new Color(ir,ig,ib));
		g.fillOval(235, 200, 200, 200);
		
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		  
			if(e.getSource()==sc1) {
			tf.setText("Red :"+sc1.getValue());
			ir=sc1.getValue();
			
			}else if(e.getSource()==sc2) {
			tf.setText("Green :"+sc2.getValue());
			ig=sc2.getValue();
			
			}else if (e.getSource()==sc3) {
			tf.setText("Blue :"+sc3.getValue());
			ib=sc3.getValue();
		}
	repaint();
	}

}
