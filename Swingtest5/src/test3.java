import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test3 extends JPanel {

	private JFrame frame;
	private JPanel jpa;
	JButton btnNewButton_3,btnNewButton_2,btnNewButton_1,btnNewButton;
	
	public test3() {
		this.setVisible(true);
		this.setLayout(null);
		
		btnNewButton = new JButton("New button");
		this.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		this.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		this.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		this.add(btnNewButton_3);
	}

	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		x=x+20;
		width = (width-60)/7;
		btnNewButton.setBounds(x, 20, width, 30);
		btnNewButton_1.setBounds(x=x+width+2, 20, width, 30);
		btnNewButton_2.setBounds(x=x+width+2, 20, width, 30);
		btnNewButton_3.setBounds(x=x+width+2, 20, width, 30);
		
	}
}
