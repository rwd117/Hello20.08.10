package java실습_applet;

import java.applet.*;
import java.awt.*;

//동서 남북 중간에 버튼이 생김, 동 서 남 북 중간 이런 순서로

public class BorderLayouttest extends Applet
{
	String[] area= {"East","West","South","North","Center"};
	public void init() {
		setLayout(new BorderLayout(0,3));
		for(int i=0;i<5;i++) {
			add(area[i], new Button(area[i]));
		}
	}
}
