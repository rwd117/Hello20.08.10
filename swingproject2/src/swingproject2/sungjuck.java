package swingproject2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class sungjuck {

	private JFrame frame;
	private JTextField txtno;
	private JTextField txtna;
	private JTextField txtko;
	private JTextField txtma;
	private JTextField txten;
	private JTextField txtto;
	private JTextField txtav;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sungjuck window = new sungjuck();
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
	public sungjuck() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 618, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD559\uBC88");
		lblNewLabel.setBounds(12, 43, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uC774\uB984");
		label.setBounds(12, 88, 57, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uAD6D\uC5B4");
		label_1.setBounds(12, 133, 57, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uC218\uD559");
		label_2.setBounds(12, 181, 57, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uC601\uC5B4");
		label_3.setBounds(12, 227, 57, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uCD1D\uC810");
		label_4.setBounds(12, 279, 57, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\uD3C9\uADE0");
		label_5.setBounds(12, 326, 57, 15);
		frame.getContentPane().add(label_5);
		
		txtno = new JTextField();
		txtno.setBounds(93, 40, 116, 21);
		frame.getContentPane().add(txtno);
		txtno.setColumns(10);
		
		txtna = new JTextField();
		txtna.setColumns(10);
		txtna.setBounds(93, 85, 116, 21);
		frame.getContentPane().add(txtna);
		
		txtko = new JTextField();
		txtko.setColumns(10);
		txtko.setBounds(93, 130, 116, 21);
		frame.getContentPane().add(txtko);
		
		txtma = new JTextField();
		txtma.setColumns(10);
		txtma.setBounds(93, 178, 116, 21);
		frame.getContentPane().add(txtma);
		
		txten = new JTextField();
		txten.setColumns(10);
		txten.setBounds(93, 224, 116, 21);
		frame.getContentPane().add(txten);
		
		txtto = new JTextField();
		txtto.setEditable(false);
		txtto.setColumns(10);
		txtto.setBounds(93, 276, 116, 21);
		frame.getContentPane().add(txtto);
		
		txtav = new JTextField();
		txtav.setEditable(false);
		txtav.setColumns(10);
		txtav.setBounds(93, 323, 116, 21);
		frame.getContentPane().add(txtav);
		
		JButton btncal = new JButton("\uACC4\uC0B0");
		btncal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kor=txtko.getText();
				String eng=txten.getText();
				String mat=txtma.getText();
				
				int kors=Integer.valueOf(kor);
				int engs=Integer.valueOf(eng);
				int mats=Integer.valueOf(mat);
				int tot=kors+engs+mats;
				double avg=tot/3.0;
				
				String tots=String.valueOf(tot);
				String avgs=String.valueOf(avg);
				
				txtto.setText(tots);
				txtav.setText(avgs);
				
			}
		});
		btncal.setBounds(12, 427, 97, 23);
		frame.getContentPane().add(btncal);
		
		JButton btnin = new JButton("\uCD94\uAC00");
		btnin.setBounds(121, 427, 97, 23);
		frame.getContentPane().add(btnin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(265, 24, 325, 320);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnde = new JButton("\uC0AD\uC81C");
		btnde.setBounds(230, 427, 97, 23);
		frame.getContentPane().add(btnde);
		
		JButton btnup = new JButton("\uC218\uC815");
		btnup.setBounds(339, 427, 97, 23);
		frame.getContentPane().add(btnup);
		
		JButton btnto = new JButton("\uC804\uCCB4\uBCF4\uAE30");
		btnto.setBounds(448, 427, 97, 23);
		frame.getContentPane().add(btnto);
		
		JButton btnfi = new JButton("");
		btnfi.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\TOOLBAR\\FIRST.GIF"));
		btnfi.setBounds(12, 378, 97, 23);
		frame.getContentPane().add(btnfi);
		
		JButton btnpr = new JButton("");
		btnpr.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\TOOLBAR\\PREV.GIF"));
		btnpr.setBounds(121, 378, 97, 23);
		frame.getContentPane().add(btnpr);
		
		JButton btnla = new JButton("");
		btnla.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\TOOLBAR\\LAST.GIF"));
		btnla.setBounds(339, 378, 97, 23);
		frame.getContentPane().add(btnla);
		
		JButton btnne = new JButton("");
		btnne.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\TOOLBAR\\NEXT.GIF"));
		btnne.setBounds(230, 378, 97, 23);
		frame.getContentPane().add(btnne);
	}
}
