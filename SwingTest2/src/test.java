import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class test implements ActionListener {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JButton btntotal,btnadd,btndel,btnsearch,btncancel;
	private JTable jt;
	private JLabel lbl1,lbl2,lbl3,lbl4;
	private JScrollPane sp;
	
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
		frame.setBounds(100, 100, 542, 367);
		frame.setTitle("¶ì¸®·Õ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl1 = new JLabel("\uBC88\uD638");
		lbl1.setBounds(12, 35, 57, 15);
		frame.getContentPane().add(lbl1);
		
		lbl2 = new JLabel("\uC774\uB984");
		lbl2.setBounds(12, 79, 57, 15);
		frame.getContentPane().add(lbl2);
		
		lbl3 = new JLabel("\uC774\uBA54\uC77C");
		lbl3.setBounds(12, 126, 57, 15);
		frame.getContentPane().add(lbl3);
		
		lbl4 = new JLabel("\uC804\uD654\uBC88\uD638");
		lbl4.setBounds(12, 174, 57, 15);
		frame.getContentPane().add(lbl4);
		
		tf1 = new JTextField();
		tf1.setBounds(91, 32, 116, 21);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(91, 76, 116, 21);
		frame.getContentPane().add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(91, 123, 116, 21);
		frame.getContentPane().add(tf3);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(91, 168, 116, 21);
		frame.getContentPane().add(tf4);
		
		btntotal = new JButton("\uC804\uCCB4 \uBCF4\uAE30");
		btntotal.setBounds(0, 263, 97, 23);
		frame.getContentPane().add(btntotal);
		
		btnadd = new JButton("\uCD94\uAC00");
		btnadd.setBounds(110, 263, 97, 23);
		frame.getContentPane().add(btnadd);
		
		btndel = new JButton("\uC0AD\uC81C");
		btndel.setBounds(218, 263, 97, 23);
		frame.getContentPane().add(btndel);
		
		btnsearch = new JButton("\uAC80\uC0C9");
		btnsearch.setBounds(327, 263, 97, 23);
		frame.getContentPane().add(btnsearch);
		
		btncancel = new JButton("\uCDE8\uC18C");
		btncancel.setBounds(429, 263, 97, 23);
		frame.getContentPane().add(btncancel);
		
		sp = new JScrollPane();
		sp.setBounds(313, 10, 201, 199);
		frame.getContentPane().add(sp);
		
		jt = new JTable();
		sp.setViewportView(jt);
		
		btntotal.addActionListener(this);
		btnadd.addActionListener(this);
		btndel.addActionListener(this);
		btnsearch.addActionListener(this);
		btncancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btntotal) {
			System.out.print(tf1.getText()+"\t");
			System.out.print(tf2.getText()+"\t");
			System.out.print(tf3.getText()+"\t");
			System.out.println(tf4.getText()+"\t");
		}else if(e.getSource()==btnadd) {
			System.out.println("Ãß°¡");
		}else if(e.getSource()==btndel) {
			System.out.println("»èÁ¦");
		}else if(e.getSource()==btnsearch) {
			System.out.println("°Ë»ö");
		}else if(e.getSource()==btncancel) {
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
		}
		
	}
}
