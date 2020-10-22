package kozinnn;

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

public class MemberDelete extends JPanel implements ActionListener {
	private JButton btnDe, btnCa, btnEx, btn;
	private JTextField tf;
	private JTable table;

	private final static int A = 0;
	private final static int B = 1;
	private final static int C = 2;
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
	String sqlDeletec = "delete from member1 where m_code=?";
	String sqlDeleten = "delete from member1 where m_name=?";
	private JLabel lbll;

	public MemberDelete() {
		initialize();
		dbcon();
		to();
		set();
		
	}

	private void initialize() {
		this.setVisible(true);
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		lblNewLabel.setBounds(146, 79, 57, 15);
		this.add(lblNewLabel);

		tf = new JTextField();
		tf.setBounds(233, 76, 104, 21);
		this.add(tf);
		tf.setColumns(10);

		btnDe = new JButton("\uC0AD\uC81C");
		btnDe.setBounds(146, 152, 97, 23);
		this.add(btnDe);

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

		btn = new JButton("\uD65C\uC131\uD654");
		btn.setBounds(390, 75, 97, 23);
		this.add(btn);
		
		lbll = new JLabel("\uD65C\uC131\uD654 \uBC84\uD2BC\uC744 \uB20C\uB7EC\uC8FC\uC138\uC694.");
		lbll.setBounds(174, 10, 214, 34);
		this.add(lbll);

		btn.addActionListener(this);

		btnEx.addActionListener(this);
		btnDe.addActionListener(this);
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

	public void set() {
		tf.setEnabled(false);
		tf.setText("");
		cmd=A;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn)) {
			if (cmd != B) {
				ta1();
				cmd = B;
				return;
			}
			cmd = A;
			set();
		
		} else if (e.getSource().equals(btnEx)) {
			subCloseWindow();
		} else if (e.getSource().equals(btnDe)) {
			goDelete();
			to();
			set();
		} else if (e.getSource().equals(btnCa)) {
			set();
		}
	}
	
	public void ta1() {
		tf.setEnabled(true);
		
		
	}
	
	public void ta2() {
		tf.setEnabled(false);
		
	}
	
	public void goDelete() {
		if (cmd == B) {
			cmdB();
		} 
		}
	
	public void cmdB() {
		String code = tf.getText();
		try {

			pst = con.prepareStatement(sqlDeletec);
			pst.setInt(1, Integer.valueOf(code));
			pst.executeUpdate();

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

	public void subCloseWindow() {
		this.setVisible(false);
	}
}
