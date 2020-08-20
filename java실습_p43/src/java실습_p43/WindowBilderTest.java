package java½Ç½À_p43;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class WindowBilderTest extends JFrame{

	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBilderTest window=new WindowBilderTest();
					window.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public WindowBilderTest() {
		initialize();
	}
	
	private void initialize() {
		this.setBounds(100,100,450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
