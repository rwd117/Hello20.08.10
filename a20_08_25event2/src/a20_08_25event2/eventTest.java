package a20_08_25event2;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class eventTest extends Applet implements ActionListener, ItemListener 
{	
	JButton btn1,btn2;
	JTextField tf1,tf2;
	JLabel lbl1,lbl2; 
	
	
	public void init() {
		this.setLayout(null);
		lbl1=new JLabel("이름");
		lbl2=new JLabel("전화번호");
		tf1=new JTextField();
		tf2=new JTextField();
		btn1=new JButton("전송");
		btn2=new JButton("취소");
		
		lbl1.setBounds(10,20,70,20);
		add(lbl1);
		lbl2.setBounds(10,50,70,20);
		add(lbl2);
		
		tf1.setBounds(90,20,100,20);
		add(tf1);
		tf2.setBounds(90,50,100,20);
		add(tf2);
		
		btn1.setBounds(10,90,70,20);
		add(btn1);
		btn2.setBounds(90,90,70,20);
		add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			System.out.println(tf1.getText());
			System.out.println(tf2.getText());
		}else if(e.getSource()==btn2) {
			tf1.setText("");
			tf2.setText("");
		}
	}

	
}
