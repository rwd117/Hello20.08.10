import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnrollmentCustomerFrame extends JFrame implements ActionListener{
	
	private CustomerPane customerPane;
	
	private JTextField txtNo;
	private JTextField txtName;
	private JTextField txtAddr;
	private JTextField txtPhone;
	
	private JComboBox cbDist;
	private JButton btnSave;
	private JButton btnCancel;
	
	private String no = "", name = "", addr = "", phone = "", dist = "";
		
	public EnrollmentCustomerFrame(CustomerPane pane){
		customerPane = pane;
		initialize();
	}
	
	public void initialize(){
		this.setTitle("�����");
		this.setSize(350, 420);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		JLabel lbNo = new JLabel("����ȣ");
		lbNo.setBounds(50, 50, 70, 25);
		this.getContentPane().add(lbNo);
		
		JLabel lbName = new JLabel("���̸�");
		lbName.setBounds(50, 100, 70, 25);
		this.getContentPane().add(lbName);
		
		JLabel lbAddr = new JLabel("���ּ�");
		lbAddr.setBounds(50, 150, 70, 25);
		this.getContentPane().add(lbAddr);
		
		JLabel lbPhone = new JLabel("��ȭ��ȣ");
		lbPhone.setBounds(50, 200, 70, 25);
		this.getContentPane().add(lbPhone);
		
		JLabel lbDist = new JLabel("������");
		lbDist.setBounds(50, 250, 70, 25);
		this.getContentPane().add(lbDist);
		
		btnSave = new JButton("����");
		btnSave.setBounds(50, 320, 100, 25);
		this.getContentPane().add(btnSave);
		
		btnCancel = new JButton("���");
		btnCancel.setBounds(180, 320, 100, 25);
		this.getContentPane().add(btnCancel);
		
		txtNo = new JTextField("");
		txtNo.setBounds(130, 50, 150, 25);
		this.getContentPane().add(txtNo);
		
		txtName = new JTextField("");
		txtName.setBounds(130, 100, 150, 25);
		this.getContentPane().add(txtName);
		
		txtAddr = new JTextField("");
		txtAddr.setBounds(130, 150, 150, 25);
		this.getContentPane().add(txtAddr);
		
		txtPhone = new JTextField("");
		txtPhone.setBounds(130, 200, 150, 25);
		this.getContentPane().add(txtPhone);
		
		cbDist = new JComboBox();
		cbDist.setBounds(130, 250, 150, 25);
		this.getContentPane().add(cbDist);
		
		for(int i=0; i<CustomerPane.customer_dist.length; i++){
			cbDist.addItem(CustomerPane.customer_dist[i]);
		}
		cbDist.setSelectedIndex(0);
		cbDist.setEnabled(false);
		
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
	}
	
	public boolean getInformation(){
		no = txtNo.getText().trim();
		if(no.equals("") || no.equals(null)) {
			msgBox("����ȣ�� �����Ǿ����ϴ�.");
			return false;
		}
		else if(!numCheck(no, true)) {
			msgBox("����ȣ�� �߸��� �����Դϴ�.");
			return false;
		}
		else if(no.getBytes().length > 14) {
			msgBox("����ȣ�� 14�� ���ϸ� �Է°����մϴ�.");
			return false;
		}
		else {
			String sql = "select * from customer where c_no='" + no + "'";
			DBControler db = new DBControler();
			db.connect();
			db.executeQuery(sql);
			ResultSet rs = db.getResultSet();
			try {
				rs.last();
				int count = rs.getRow();
				if(count > 0) {
					msgBox("�̹� �ִ� ����ȣ �Դϴ�.");
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		
		name = txtName.getText().trim();
		if(name.equals("") || name.equals(null)) {
			msgBox("�������� �����Ǿ����ϴ�.");
			return false;
		}
		else if(name.getBytes().length > 20) {
			msgBox("�������� �ʹ� ��ϴ�.");
			return false;
		}
		
		
		addr = txtAddr.getText().trim();
		if(addr.getBytes().length > 40) {
			msgBox("�ּҰ� �ʹ� ��ϴ�.");
			return false;
		}
		
		phone = txtPhone.getText().trim();
		if(!numCheck(phone, true) || phone.getBytes().length > 16) {
			msgBox("��ȭ��ȣ�� �߸��� �����Դϴ�.");
			return false;
		}
		
		int idx = cbDist.getSelectedIndex();
		switch (idx) {
		case 0: dist = "00"; break;
		case 1: dist = "11"; break;
		default: break;
		}
		return true;
	}
	
	public boolean numCheck(String str, boolean bar) {
		char temp;
		for(int i=0; i<str.length(); i++) {
			temp = str.charAt(i);
			if(bar && temp == '-') continue;
			if(temp < '0' || temp > '9') {
				return false;
			}
		}
		return true;
	}
	
	public void msgBox(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
	public void eventBtnSave(){
		if(!getInformation()) return;
		String sql = "insert into customer values('"+no+"', '"+name+"', '"+addr+"', '"+phone+"', '"+dist+"')";
		DBControler db = new DBControler();
		db.connect();
		db.executeQuery(sql);
		db.disConnect();
		customerPane.eventBtnSearch();
		dispose();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCancel){
			dispose();
		}
		else if(e.getSource() == btnSave){
			eventBtnSave();
		}
	}
}