package java�ǽ�_applet;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class ScrollbarTest extends Applet implements AdjustmentListener 
{
	Label myLabel;
	Scrollbar myScrollbar;
	
	public void init() {
		setLayout(new BorderLayout());
		myScrollbar= new Scrollbar(Scrollbar.HORIZONTAL,50,0,1,100);
		//��ũ�� ù��ġ,???,���� ������, ���� ū ��
		myScrollbar.addAdjustmentListener(this);
		add("North", myScrollbar);
		
		myLabel=new Label();
		myLabel.setText("��ũ�ѹٸ� ����");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.yellow);
		add("Center", myLabel);
	}
		public void adjustmentValueChanged(AdjustmentEvent e) 
		{
			if(e.getSource()==myScrollbar) {
				myLabel.setText("��ġ :"+myScrollbar.getValue());
				}
		}
	}

