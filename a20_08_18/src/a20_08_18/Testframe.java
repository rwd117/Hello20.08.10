package a20_08_18;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Testframe extends JFrame {

	JLabel lbl;
	JButton btn=null;
	JTextField txt=null;
	static Testframe frame;
	public static void main(String[] args) {
		
	frame=new Testframe();
	
	}
	
	public Testframe() 
	{	this.setVisible(true);
		this.setTitle("�츮��������");
		this.setBounds(10, 10, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*this.setLayout(new FlowLayout());
		btn=new JButton("��");
		lbl=new JLabel("???");
		this.add(lbl);
		this.add(btn);*/
		txt=new JTextField();
		this.add(txt);
	}//�� ��ư ������ ������ �Ѿ�� ���� ����

}
