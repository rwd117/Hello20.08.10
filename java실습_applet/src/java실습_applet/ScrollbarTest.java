package java실습_applet;

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
		//스크롤 첫위치,???,제일 작은수, 제일 큰 수
		myScrollbar.addAdjustmentListener(this);
		add("North", myScrollbar);
		
		myLabel=new Label();
		myLabel.setText("스크롤바를 조정");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.yellow);
		add("Center", myLabel);
	}
		public void adjustmentValueChanged(AdjustmentEvent e) 
		{
			if(e.getSource()==myScrollbar) {
				myLabel.setText("위치 :"+myScrollbar.getValue());
				}
		}
	}

