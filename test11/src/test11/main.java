package test11;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class main {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 712, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
