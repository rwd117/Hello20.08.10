package bankproject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class fcustomer implements ActionListener {
  
	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	JButton btnMoveFirst, btnMovePre, btnMoveNext, btnMoveLast;
	JButton btnInsertItem, btnDeleteItem, btnSaveItem, btnPrintItem, btnCloseWindow;
	JComboBox jcb1;
	JLabel lbl1, lbl2, lbl3, lbl4, lbl5;

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "system";
	String pwd = "123456";

	static Connection conn = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	static String strQuery = "Select c_no, c_name, c_addr, c_phone, c_dist from customer";

	String strCno, strCname, strCaddr, strCphone, strDist;
	static String customer_dist[] = { "���ΰ�", "�����" };
	boolean bInsertFlag = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fcustomer window = new fcustomer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public fcustomer() {
		initialize();
		dbConnect();
		initResultSet(strQuery);

	}

	private void dbConnect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initResultSet(String strQuery) {
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(strQuery);
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "SQLException");
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 724, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lbl1 = new JLabel("\uACE0\uAC1D\uBC88\uD638");
		lbl1.setBounds(12, 55, 54, 15);
		frame.getContentPane().add(lbl1);

		lbl2 = new JLabel("\uACE0\uAC1D\uC774\uB984");
		lbl2.setBounds(12, 97, 54, 15);
		frame.getContentPane().add(lbl2);

		lbl3 = new JLabel("\uC8FC\uC18C");
		lbl3.setBounds(12, 144, 54, 15);
		frame.getContentPane().add(lbl3);

		lbl4 = new JLabel("\uC804\uD654\uBC88\uD638");
		lbl4.setBounds(12, 189, 54, 15);
		frame.getContentPane().add(lbl4);

		lbl5 = new JLabel("\uACE0\uAC1D\uAD6C\uBD84");
		lbl5.setBounds(12, 237, 54, 15);
		frame.getContentPane().add(lbl5);

		tf1 = new JTextField();
		tf1.setText("");
		tf1.setBounds(78, 52, 116, 21);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);

		tf2 = new JTextField();
		tf2.setText("");
		tf2.setColumns(10);
		tf2.setBounds(78, 94, 116, 21);
		frame.getContentPane().add(tf2);

		tf3 = new JTextField();
		tf3.setText("");
		tf3.setColumns(10);
		tf3.setBounds(78, 141, 308, 21);
		frame.getContentPane().add(tf3);

		tf4 = new JTextField();
		tf4.setText("");
		tf4.setColumns(10);
		tf4.setBounds(78, 186, 116, 21);
		frame.getContentPane().add(tf4);

		jcb1 = new JComboBox();
		for (int i = 0; i < customer_dist.length; i++) {
			jcb1.addItem(customer_dist[i]);
		}
		jcb1.setBounds(78, 234, 116, 21);
		frame.getContentPane().add(jcb1);

		btnMoveFirst = new JButton("");
		btnMoveFirst.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\FIRST.GIF"));
		btnMoveFirst.setBounds(12, 10, 34, 23);
		frame.getContentPane().add(btnMoveFirst);

		btnMovePre = new JButton("");
		btnMovePre.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\PREV.GIF"));
		btnMovePre.setBounds(47, 10, 34, 23);
		frame.getContentPane().add(btnMovePre);

		btnMoveNext = new JButton("");
		btnMoveNext.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\NEXT.GIF"));
		btnMoveNext.setBounds(78, 10, 34, 23);
		frame.getContentPane().add(btnMoveNext);

		btnMoveLast = new JButton("");
		btnMoveLast.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\LAST.GIF"));
		btnMoveLast.setBounds(112, 10, 34, 23);
		frame.getContentPane().add(btnMoveLast);

		btnInsertItem = new JButton("");
		btnInsertItem
				.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\INSERT.GIF"));
		btnInsertItem.setBounds(196, 10, 34, 23);
		frame.getContentPane().add(btnInsertItem);

		btnDeleteItem = new JButton("");
		btnDeleteItem
				.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\DELETE.GIF"));
		btnDeleteItem.setBounds(229, 10, 34, 23);
		frame.getContentPane().add(btnDeleteItem);

		btnSaveItem = new JButton("");
		btnSaveItem.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\SAVE.GIF"));
		btnSaveItem.setBounds(263, 10, 34, 23);
		frame.getContentPane().add(btnSaveItem);

		btnPrintItem = new JButton("");
		btnPrintItem.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\PRINT.GIF"));
		btnPrintItem.setBounds(297, 10, 34, 23);
		frame.getContentPane().add(btnPrintItem);

		btnCloseWindow = new JButton("");
		btnCloseWindow
				.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\EXIT.GIF"));
		btnCloseWindow.setBounds(331, 10, 34, 23);
		frame.getContentPane().add(btnCloseWindow);

		btnMoveFirst.addActionListener(this);
		btnMovePre.addActionListener(this);
		btnMoveNext.addActionListener(this);
		btnMoveLast.addActionListener(this);
		btnInsertItem.addActionListener(this);
		btnDeleteItem.addActionListener(this);
		btnSaveItem.addActionListener(this);
		btnPrintItem.addActionListener(this);
		btnCloseWindow.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMoveFirst) {
			subMoveFirst();
		} else if (e.getSource() == btnMovePre) {
			subMovePre();
		} else if (e.getSource() == btnMoveNext) {
			subMoveNext();
		} else if (e.getSource() == btnMoveLast) {
			subMoveLast();
		} else if (e.getSource() == btnInsertItem) {
			subInsertItem();
		} else if (e.getSource() == btnDeleteItem) {
			subDeleteItem();
		} else if (e.getSource() == btnSaveItem) {
			subSaveItem();
		} else if (e.getSource() == btnPrintItem) {
			subPrintItem();
		} else if (e.getSource() == btnCloseWindow) {
			subCloseWindow();
		}
	}

	public void clearItems() {
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
	}

	public void setItems() {
		try {
			strCno = rs.getString(1).trim(); // c_no
			strCname = rs.getString(2).trim(); // c_name
			strCaddr = rs.getString(3); // c_addr
			strCphone = rs.getString(4); // c_phone
			strDist = rs.getString(5).trim(); // c_dist
			System.out.println(strCno + "," + strCname + "," + strCaddr + "," + strCphone + "," + strDist);
			tf1.setText(strCno);
			tf2.setText(strCname);
			tf3.setText(strCaddr);
			tf4.setText(strCphone);
			/*
			 * �������ڵ��� ���� ���� setting 00 : ���ΰ� , 11 : �����
			 */
			if (strDist.equals("00")) {
				jcb1.setSelectedIndex(0);
			} else if (strDist.equals("11")) {
				jcb1.setSelectedIndex(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean getItems() {
		int intIndex;
		strCno = tf1.getText().trim();//trim, �� �� ��������
		strCname = tf2.getText().trim();
		strCaddr = tf3.getText().trim();
		strCphone = tf4.getText().trim();
		intIndex = jcb1.getSelectedIndex();
		if (strCno == null) {
			JOptionPane.showMessageDialog(null, "����ȣ�� �����Ǿ����ϴ�.");
			return false;
		}
		if (strCno.length() < 12) {
			JOptionPane.showMessageDialog(null, "�߸��� ����ȣ�Դϴ�.");
			return false;
		}
		if (strCname == null) {
			JOptionPane.showMessageDialog(null, "�������� �����Ǿ����ϴ�.");
			return false;
		}
		switch (intIndex) {
		case 0:
			strDist = "00";
		case 1:
			strDist = "11";
		}
		return true;
	}

	public void subMoveFirst() {
		try {
			if (!rs.isFirst()) {
				rs.first();
				setItems();
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, se);
		}

	}

	public void subMovePre() {
		try {
			if (!rs.isFirst()) {
				rs.previous();
				setItems();
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, se);
		}
	}

	public void subMoveNext() {
		try {
			if (!rs.isLast()) {
				rs.next();
				setItems();
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, se);
		}
	}

	public void subMoveLast() {
		try {
			if (!rs.isLast()) {
				rs.last();
				setItems();
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, se);
		}
	}

	public void subInsertItem() {
		clearItems();
		bInsertFlag = true;

	}

	public void subDeleteItem() {
		int rtnValue;
		rtnValue = JOptionPane.showConfirmDialog(null, "���� �����͸� ���� �մϴ�.", "Ȯ��", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		try {
			if (rtnValue == 0) {
				rs.deleteRow();
				subMoveNext(); // ���������� �̵�
				conn.commit();
			}
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, se);
		}
	}

	public void subSaveItem() {
		if (bInsertFlag == true) { // Insert��ư�� ���ȴٸ�..
			if (getItems()) {
				try {
					rs.moveToInsertRow(); // cursor�� ��ġ�� insert buffer�� �̵�
					rs.updateString(1, strCno.trim()); // cursor�� ������ Ŭ���� ������ setting
					rs.updateString(2, strCname.trim());
					rs.updateString(3, strCaddr.trim());
					rs.updateString(4, strCphone.trim());
					rs.updateString(5, strDist.trim());
					rs.insertRow(); // setting�� insert buffer������ �����ͺ��̽��� �ݿ�
					bInsertFlag = false;
					conn.commit();
					rs.moveToCurrentRow();
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(null, se);
				}
			}
		} else { // insert ��ư�� ������ �ʾҴٸ�
			if (getItems()) {
				try {
					rs.updateString(1, strCno.trim()); // Ŭ���� ������ ������ cursor�� �ݿ�
					rs.updateString(2, strCname.trim());
					rs.updateString(3, strCaddr.trim());
					rs.updateString(4, strCphone.trim());
					rs.updateString(5, strDist.trim());
					rs.updateRow(); // cursor�� ��������� �����ͺ��̽��� �ݿ�
					conn.commit();
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(null, se);
					se.printStackTrace();
				}
			}
		}
	}

	public void subPrintItem() {

	}

	public void subCloseWindow() {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		frame.dispose();
	}
}
