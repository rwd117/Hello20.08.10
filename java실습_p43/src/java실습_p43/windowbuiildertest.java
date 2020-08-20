package java½Ç½À_p43;

import java.awt.EventQueue;

import javax.swing.JFrame;

//?????????????
public class windowbuiildertest {
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				windowbuiildertest window= new windowbuiildertest();
				window.frame.setVisible(true);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	});
}
	public windowbuiildertest() {
		initialize();
		}
	private void initialize() {
		frame=new JFrame();
		frame.setBounds(100,100,450,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

