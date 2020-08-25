package a20_08_25event2;

import javax.swing.JFrame;

class cheFrame extends JFrame{
	
	public cheFrame() {
		this.setVisible(true);
		this.setLocation(10,10);
		this.setSize(300,300);
		this.setTitle("µû¿ä¿À¿Ë");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class FrmaeTest3 {

	public static void main(String args[]) {
		cheFrame frame=new cheFrame();
	}
}
