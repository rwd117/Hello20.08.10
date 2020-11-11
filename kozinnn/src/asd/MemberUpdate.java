package asd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import kozinnn.Model;

public class MemberUpdate extends JPanel implements ActionListener {
	// m_code,m_name,m_address,m_phone
	private JButton btnUp, btnCa, btnEx, btn1, btn2, btn3;

	private final static int A = 0;
	private final static int B = 1;
	private final static int C = 2;
	private final static int D = 3;
	int cmd = A;

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "system";
	String password = "123456";

	Connection con = null;
	PreparedStatement pst = null;
	PreparedStatement pstmtto, pstmttosc;

	Model model;

	String sqlTotal = "select * from member1 order by m_code asc";
	String sqlUpdaten = "update member1 set m_name=?  where m_code=?";	
	String sqlUpdatea = "update member1 set m_address=?  where m_code=?";	
	String sqlUpdatep = "update member1 set m_phone=?  where m_code=?";	
	
	private JTextField tf;
	private JTextField tf1;
	private JTextField tf2;
	private JTable table;
	private JLabel label;
	private JTextField tf3;

	public MemberUpdate() {
		initialize();
		dbcon();
		to();
		clear();
	}

	private void initialize() {
		this.setVisible(true);
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		lblNewLabel.setBounds(38, 46, 57, 15);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setBounds(303, 46, 57, 15);
		this.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_2.setBounds(38, 77, 57, 15);
		this.add(lblNewLabel_2);

		tf = new JTextField();
		tf.setBounds(105, 43, 104, 21);
		this.add(tf);
		tf.setColumns(10);

		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(399, 43, 185, 21);
		this.add(tf1);

		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(107, 74, 183, 21);
		this.add(tf2);

		btnUp = new JButton("\uC218\uC815");
		btnUp.setBounds(146, 152, 97, 23);
		this.add(btnUp);

		btnCa = new JButton("\uCDE8\uC18C");
		btnCa.setBounds(390, 152, 97, 23);
		this.add(btnCa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 196, 674, 250);
		this.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btnEx = new JButton("");
		btnEx.setIcon(new ImageIcon("C:\\kmv2\\gitbub\\rwd117\\20.08.10\\bankproject\\src\\TOOLBAR\\EXIT.GIF"));
		btnEx.setBounds(38, 10, 33, 23);
		this.add(btnEx);

		label = new JLabel("\uC8FC\uC18C");
		label.setBounds(38, 114, 57, 15);
		this.add(label);

		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(105, 111, 427, 21);
		this.add(tf3);

		btn1 = new JButton("\uD65C\uC131\uD654");
		btn1.setBounds(596, 42, 74, 23);
		this.add(btn1);

		btn2 = new JButton("\uD65C\uC131\uD654");
		btn2.setBounds(313, 73, 74, 23);
		this.add(btn2);

		btn3 = new JButton("\uD65C\uC131\uD654");
		btn3.setBounds(550, 110, 74, 23);
		this.add(btn3);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

		btnEx.addActionListener(this);
		btnUp.addActionListener(this);
		btnCa.addActionListener(this);
	}

	public void dbcon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void to() {
		try {
			pstmttosc = con.prepareStatement(sqlTotal, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmtto = con.prepareStatement(sqlTotal);

			ResultSet rsscroll = pstmttosc.executeQuery();
			ResultSet rs = pstmtto.executeQuery();

			if (model == null)
				model = new Model();
			model.getRowCount(rsscroll);
			model.setData(rs);
			table.setModel(model);
			table.updateUI();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmtto.close();
				pstmttosc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void clear() {
		tf1.setEnabled(false);
		tf2.setEnabled(false);
		tf3.setEnabled(false);
		tf.setText("");
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn1)) {
			if (cmd != B) {
				te1();
				cmd = B;
				return;
			}
			cmd = A;
			clear();
		} else if (e.getSource().equals(btn2)) {
			if (cmd != C) {
				te2();
				cmd = C;
				return;
			}
			cmd = A;
			clear();
		} else if (e.getSource().equals(btn3)) {
			if (cmd != D) {
				te3();
				cmd = D;
				return;
			}
			cmd = A;
			clear();
		} else if (e.getSource().equals(btnEx)) {
			subCloseWindow();
		} else if (e.getSource().equals(btnUp)) {
			goUpdate();
			clear();
		} else if (e.getSource().equals(btnCa)) {
			clear();
		}
	}

	public void te1() {
		tf1.setEnabled(true);
		tf2.setEnabled(false);
		tf3.setEnabled(false);
	}

	public void te2() {
		tf1.setEnabled(false);
		tf2.setEnabled(true);
		tf3.setEnabled(false);
	}

	public void te3() {
		tf1.setEnabled(false);
		tf2.setEnabled(false);
		tf3.setEnabled(true);
	}

	public void subCloseWindow() {
		this.setVisible(false);
	}

	public void goUpdate() {
		if (cmd == B) {
			cmdB();
			to();
		} else if (cmd == C) {
			cmdC();
			to();
		} else if (cmd == D) {
			cmdD();
			to();
		}
	}

	public void cmdB() {
		String code = tf.getText();
		String name = tf1.getText();
		
		try {

			pst = con.prepareStatement(sqlUpdaten);
			pst.setInt(2, Integer.valueOf(code));
			pst.setString(1, name);
			int res = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void cmdC() {
		String code = tf.getText();
		String address = tf2.getText();
		
		try {

			pst = con.prepareStatement(sqlUpdatea);
			pst.setInt(2, Integer.valueOf(code));
			pst.setString(1, address);
			int res = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void cmdD() {
		String code = tf.getText();
		String phone = tf3.getText();
		
		try {

			pst = con.prepareStatement(sqlUpdatep);
			pst.setInt(2, Integer.valueOf(code));
			pst.setString(1, phone);
			int res = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
