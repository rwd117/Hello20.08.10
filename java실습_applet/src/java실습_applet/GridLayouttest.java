package java실습_applet;

import java.applet.*;
import java.awt.*;
//flow보다 버튼이 좀 큼 꽉 채워서 하나씩
public class GridLayouttest extends Applet
{
	public void init() {
		setLayout(new GridLayout(0,3));
		
		for(int i=0;i<10;i++) {
			add(new Button("버튼 #"+i));
		}
	}
}
