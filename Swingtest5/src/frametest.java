import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class frametest implements ActionListener{

	private JFrame frame;
	JMenuItem btn,btn2;
	JPanel pan;
	Dimension dim;
	Container container;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frametest window = new frametest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frametest() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Frame");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width / 2;
		int height = screenSize.height / 2;
		int x = screenSize.width / 4;
		int y = screenSize.height / 4;
		frame.setBounds(x, y, width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				if(pan != null) {
					pan.setBounds(0, 0, frame.getWidth(), frame.getHeight());	
				}
			}
		});
		
		container = frame.getContentPane();
		container.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		btn = new JMenuItem("New menu item");
		mnNewMenu.add(btn);
		
		btn2 = new JMenuItem("New menu item");
		mnNewMenu.add(btn2);
		
		btn.addActionListener(this);
		btn2.addActionListener(this);
	}
	
	public void clear() {
		pan=null;
		container.removeAll();
		container.setVisible(false);
		container.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		clear();
		if(e.getSource().equals(btn)) {
			pan=new test3();
		}else if(e.getSource().equals(btn2)) {
			pan=new test4();
		}
		pan.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(pan);
	}
}
