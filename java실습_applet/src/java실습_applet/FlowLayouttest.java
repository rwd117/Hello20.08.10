package java�ǽ�_applet;

import java.applet.*;
import java.awt.*;
import java.awt.FlowLayout;
//���ʿ��� ���������� ������Ʈ�� ���� ���� ������ �Ʒ���, flowlayout�� �װ�
public class FlowLayouttest extends Applet
{
	public void init() {
		
		setLayout(new FlowLayout());
		
		for(int i=1;i<10;i++) {
			add(new Button("��ư #"+i));//��ư Ű ����
		}
	}
}
