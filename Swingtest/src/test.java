import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class test {

	private JFrame frame;
	private JTextField textname;
	private JTextField textid;
	private JTextField textpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uB760\uB85C\uB9AC\uB9AC\uC774\uC774\uC774");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(12, 38, 125, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setBounds(12, 79, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setBounds(12, 126, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		textname = new JTextField();
		textname.setBounds(94, 35, 116, 21);
		frame.getContentPane().add(textname);
		textname.setColumns(10);
		
		textid = new JTextField();
		textid.setBounds(94, 76, 116, 21);
		frame.getContentPane().add(textid);
		textid.setColumns(10);
		
		textpwd = new JTextField();
		textpwd.setBounds(94, 123, 116, 21);
		frame.getContentPane().add(textpwd);
		textpwd.setColumns(10);
		
		JButton btnNewButton = new JButton("\uC804\uC1A1");
		btnNewButton.setBounds(12, 212, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBounds(149, 212, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC804\uCCB4\uBCF4\uAE30");
		btnNewButton_2.setBounds(300, 212, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
