import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class test implements ActionListener 
{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton btnInsert,btnCancel;
	
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
		frame.setTitle("\uC9DC\uB77C\uB780");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("\uC774\uB984");
		lblName.setBounds(22, 32, 57, 15);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(106, 29, 116, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblID = new JLabel("\uC544\uC774\uB514");
		lblID.setBounds(22, 100, 57, 15);
		frame.getContentPane().add(lblID);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 97, 116, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPwd = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblPwd.setBounds(22, 190, 57, 15);
		frame.getContentPane().add(lblPwd);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 187, 116, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnInsert = new JButton("\uD655\uC778");
		btnInsert.setBounds(224, 141, 97, 23);
		frame.getContentPane().add(btnInsert);
		
		btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.setBounds(333, 141, 97, 23);
		frame.getContentPane().add(btnCancel);
		
		btnInsert.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnInsert) {
			
		}else if(e.getSource()==btnCancel) {
			
		}
	}
}
