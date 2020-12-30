package admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Adminmain extends JFrame implements ActionListener{
	private JFrame frame=new JFrame();
	private JMenuBar menuBar;
	private JMenu mnNewMenu, mnNewMenu_1;
	private JMenuItem Item,Item1,Item2,Item3;
	private JPanel pan;
	private Container container;
	
	public Adminmain() {
		set();
	}

	public void set() {
		frame = new JFrame();
		frame.setBounds(120, 150, 1600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(051, 051, 051));
		frame.setLayout(null);
		frame.setVisible(true);
		
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				if (pan != null) {
					pan.setBounds(0, 0, frame.getWidth(), frame.getHeight());
				}
			}
		});
		container = frame.getContentPane();
		container.setLayout(null);
		frame.setBackground(new Color(248,255,255));
		
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 164, 21);
		frame.getContentPane().add(menuBar);
		
		mnNewMenu = new JMenu("\uC88C\uC11D \uBC0F \uCE74\uB4DC");
		menuBar.add(mnNewMenu);
		
		Item = new JMenuItem("\uCE74\uB4DC \uBC88\uD638");
		mnNewMenu.add(Item);
		
		Item1 = new JMenuItem("\uC88C\uC11D \uBC88\uD638");
		mnNewMenu.add(Item1);
		
		mnNewMenu_1 = new JMenu("\uD68C\uC6D0 / \uBE44\uD68C\uC6D0");
		menuBar.add(mnNewMenu_1);
		
		Item2 = new JMenuItem("\uD68C\uC6D0");
		mnNewMenu_1.add(Item2);
		
		Item3 = new JMenuItem("\uBE44\uD68C\uC6D0");
		mnNewMenu_1.add(Item3);
		
		Item.addActionListener(this);
		Item1.addActionListener(this);
		Item2.addActionListener(this);
		Item3.addActionListener(this);
		
	}
	
	public void clear() {
		container.removeAll();
		container.setVisible(false);
		container.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		clear();
		//Ä«µå
		if(e.getSource().equals(Item)) {
			pan = new CardNum(frame);
		}else if(e.getSource().equals(Item1)) {
			pan = new SeatNum(frame);
		}else if(e.getSource().equals(Item2)) {
			pan = new Member(frame);
		}else if(e.getSource().equals(Item3)) {
			
		}
		pan.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(pan);
	}
}
