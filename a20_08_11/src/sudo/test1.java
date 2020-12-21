package sudo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class test1	extends JFrame implements ActionListener {
	JButton btn,btn1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test1();
	}
	
	public test1() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);
		setTitle("서");
		
		btn=new JButton("2를 불러옵니다");
		add(btn,BorderLayout.NORTH);
		btn1=new JButton("3를 불러오죠?");
		add(btn1,BorderLayout.SOUTH);
		
		btn.addActionListener(this);
		btn1.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btn)) {
			new test2();
		
		}else if(e.getSource().equals(btn1)) {
			new test3();
				}
	}

}
