import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test4 extends JPanel{

	private JFrame frame;
	JButton btnNewButton_3,btnNewButton_2,btnNewButton_1,btnNewButton;

	public test4() {
		this.setVisible(true);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(152, 160, 97, 23);
		this.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(349, 314, 97, 23);
		this.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(58, 296, 97, 23);
		this.add(btnNewButton_2);
		
	}
	
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		x=x+20;
		width = (width-60)/7;
		btnNewButton.setBounds(x, 20, width, 30);
		btnNewButton_1.setBounds(x=x+width+2, 20, width, 30);
		btnNewButton_2.setBounds(x=x+width+2, 20, width, 30);
		
	}

}
