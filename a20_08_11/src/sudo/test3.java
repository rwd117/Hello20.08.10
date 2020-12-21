package sudo;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class test3 extends JFrame{
	JFrame frame=new JFrame();
	JLabel lbl;
	
	public test3() {
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBounds(200,100,400,600);
		frame.setTitle("222222222222222222222");
		
		lbl=new JLabel("여기가 라벨임돠~");
		frame.add(lbl,BorderLayout.CENTER);
		
	}

	public void appendMsg(String msg) {
		// TODO Auto-generated method stub
		lbl.setText(msg);
	}
}
