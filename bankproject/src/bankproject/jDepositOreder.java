package bankproject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class jDepositOreder implements ActionListener  {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTable jtAccountLi;
	
	JComboBox jcb1, jcb2, jcb3;
	JTable jtAccountList = null;
	JButton btnInsertItem, btnSaveItem, btnPrintItem, btnCloseWindow;
	JLabel lbStatusMessage;
	
	boolean bInsertFlag=true;
	static String customer_dis[]= {"개인고객", "기업고객"};
	Object columnName[] = {"계좌번호", "예금상품명", "고객번호", "고객명", "개설일"};
	Object dataTable[][] = null;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jDepositOreder window = new jDepositOreder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public jDepositOreder() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 642, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnInsertItem = new JButton("");
		btnInsertItem.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\INSERT.GIF"));
		btnInsertItem.setBounds(12, 10, 42, 23);
		frame.getContentPane().add(btnInsertItem);
		
		btnSaveItem = new JButton("");
		btnSaveItem.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\SAVE.GIF"));
		btnSaveItem.setBounds(66, 10, 47, 23);
		frame.getContentPane().add(btnSaveItem);
		
		btnPrintItem = new JButton("");
		btnPrintItem.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\PRINT.GIF"));
		btnPrintItem.setBounds(125, 10, 42, 23);
		frame.getContentPane().add(btnPrintItem);
		
		btnCloseWindow = new JButton("");
		btnCloseWindow.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\EXIT.GIF"));
		btnCloseWindow.setBounds(179, 10, 42, 23);
		frame.getContentPane().add(btnCloseWindow);
		
		JLabel lblNewLabel = new JLabel("\uC9C0\uC810");
		lblNewLabel.setBounds(12, 56, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uACE0\uAC1D\uAD6C\uBD84");
		label.setBounds(12, 83, 57, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uACC4\uC88C\uBC88\uD638");
		label_1.setBounds(12, 111, 57, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uC608\uAE08\uC885\uB958");
		label_2.setBounds(12, 142, 57, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uACC4\uC57D\uAE30\uAC04");
		label_3.setBounds(12, 172, 57, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uACE0\uAC1D\uBC88\uD638");
		label_4.setBounds(12, 208, 57, 15);
		frame.getContentPane().add(label_4);
		
		jcb1 = new JComboBox();
		jcb1.setBounds(81, 53, 97, 21);
		frame.getContentPane().add(jcb1);
		
		jcb2 = new JComboBox();
		jcb2.setBounds(81, 80, 97, 21);
		frame.getContentPane().add(jcb2);
		
		jcb3 = new JComboBox();
		jcb3.setBounds(81, 139, 97, 21);
		frame.getContentPane().add(jcb3);
		
		tf1 = new JTextField();
		tf1.setBounds(81, 108, 146, 21);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(81, 169, 116, 21);
		frame.getContentPane().add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(81, 205, 146, 21);
		frame.getContentPane().add(tf3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 422, 602, -166);
		frame.getContentPane().add(scrollPane);
		
		jtAccountLi = new JTable();
		jtAccountLi.setBounds(12, 254, 602, 161);
		frame.getContentPane().add(jtAccountLi);
		
		lbStatusMessage = new JLabel("\uC0C1\uD0DC \uCC3D");
		lbStatusMessage.setBounds(12, 422, 602, 15);
		frame.getContentPane().add(lbStatusMessage);
		
		btnInsertItem.addActionListener(this);
		btnSaveItem.addActionListener(this);
		btnPrintItem.addActionListener(this);
		btnCloseWindow.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnInsertItem)) {
			
		}else if(e.getSource().equals(btnSaveItem)) {
			
		}else if(e.getSource().equals(btnPrintItem)) {
			
		}else if(e.getSource().equals(btnCloseWindow)) {
			System.exit(0);
		}
	}
}
