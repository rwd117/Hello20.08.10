package java실습_applet;

import java.applet.*;
import java.awt.*;
import java.awt.FlowLayout;
//왼쪽에서 오른쪽으로 컴포넌트를 생성 공간 부족시 아래로, flowlayout임 그게
public class FlowLayouttest extends Applet
{
	public void init() {
		
		setLayout(new FlowLayout());
		
		for(int i=1;i<10;i++) {
			add(new Button("버튼 #"+i));//버튼 키 생서
		}
	}
}
