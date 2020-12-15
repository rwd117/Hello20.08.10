package User;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class PCunuser implements ActionListener {

	private JFrame frame;
	private JLabel Cardnum;
	private JLabel TimeInsert;
	private JLabel Timer ;
	private JButton BtnExit;
	private JScrollPane sp,sp1,sp2;
	private JTextArea ta,ta1,ta2;
	
	public PCunuser(String combo,String name) {
		initialize();
		ta.setText(combo+"님이 사용중입니다.");
		
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 496, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		Cardnum = new JLabel("\uCE74\uB4DC \uBC88\uD638");
		Cardnum.setBounds(43, 47, 139, 40);
		frame.getContentPane().add(Cardnum);
		
		TimeInsert = new JLabel("\uCDA9\uC804\uD55C \uC2DC\uAC04");
		TimeInsert.setBounds(43, 97, 139, 36);
		frame.getContentPane().add(TimeInsert);
		
		Timer = new JLabel("\uD604\uC7AC \uC0AC\uC6A9\uD55C \uC2DC\uAC04");
		Timer.setBounds(43, 143, 139, 38);
		frame.getContentPane().add(Timer);
		
		BtnExit = new JButton("\uB85C\uADF8\uC544\uC6C3");
		BtnExit.setBounds(183, 214, 97, 23);
		frame.getContentPane().add(BtnExit);
		

		Border lineBorder = BorderFactory.createLineBorder(new Color(000, 153, 255), 3);

		Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);
		
		sp = new JScrollPane();
		sp.setBounds(204, 47, 200, 150);
		sp.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		frame.getContentPane().add(sp);
		
		ta = new JTextArea();
		ta.setBounds(204, 47, 200, 50);
		ta.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		sp.add(ta);
		
		ta1 = new JTextArea();
		ta1.setBounds(204, 97, 200, 50);
		ta1.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		sp.add(ta1);
		
		ta2 = new JTextArea();
		ta2.setBounds(204, 143, 200, 50);
		ta2.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));
		sp.add(ta2);
		
		BtnExit.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
