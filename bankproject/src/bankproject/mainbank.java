package bankproject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class mainbank implements ActionListener  {

	private JFrame frame;
	JMenuItem itemexit;
	JMenuItem itemcustomer;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainbank window = new mainbank();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mainbank() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 576, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uC2DC\uC2A4\uD15C");
		menuBar.add(mnNewMenu);
		
		itemexit = new JMenuItem("\uC885\uB8CC");
		mnNewMenu.add(itemexit);
		
		JMenu mnNewMenu_1 = new JMenu("\uACE0\uAC1D/\uC9C0\uC810\uAD00\uB9AC");
		menuBar.add(mnNewMenu_1);
		
		itemcustomer = new JMenuItem("\uACE0\uAC1D\uAD00\uB9AC");
		mnNewMenu_1.add(itemcustomer);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\uC9C0\uC810\uAD00\uB9AC");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		itemexit.addActionListener(this);
		itemcustomer.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(itemexit)) {
			System.exit(0);
		}else if(e.getSource().equals(itemcustomer)) {
			System.out.println("dd");
		}
	}

}
