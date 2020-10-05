import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EnrollmentBranchFrame extends JFrame implements ActionListener{
	
	private BranchPane branchPane;
	private String no, name, addr, phone, assets;
	private JTextField txtNo, txtName, txtAddr, txtPhone, txtAssets;
	private JButton btnSave, btnCancel;
	
	public EnrollmentBranchFrame(BranchPane pane){
		branchPane = pane;
		initialize();
	}
	
	public void initialize(){
		this.setTitle("�������");
		
		this.setSize(350, 420);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		JLabel lbNo = new JLabel("������ȣ");
		lbNo.setBounds(50, 50, 70, 25);
		this.getContentPane().add(lbNo);
		
		JLabel lbName = new JLabel("������");
		lbName.setBounds(50, 100, 70, 25);
		this.getContentPane().add(lbName);
		
		JLabel lbAddr = new JLabel("�����ּ�");
		lbAddr.setBounds(50, 150, 70, 25);
		this.getContentPane().add(lbAddr);
		
		JLabel lbPhone = new JLabel("��ȭ��ȣ");
		lbPhone.setBounds(50, 200, 70, 25);
		this.getContentPane().add(lbPhone);
		
		JLabel lbAssets = new JLabel("�ڻ��Ѿ�");
		lbAssets.setBounds(50, 250, 70, 25);
		this.getContentPane().add(lbAssets);
		
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
		
		txtAssets = new JTextField("");
		txtAssets.setBounds(130, 250, 150, 25);
		this.getContentPane().add(txtAssets);
		
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
	}
	
	public boolean getInformation(){
		no = txtNo.getText().trim();
		if(no.equals("") || no.equals(null)) {
			msgBox("������ȣ�� �����Ǿ����ϴ�.");
			return false;
		}
		else if(!numCheck(no, false)) {
			msgBox("������ȣ�� ���ڸ� �����մϴ�.");
			return false;
		}
		else if(no.getBytes().length > 3) {
			msgBox("������ȣ�� 3�� ���ϸ� �����մϴ�.");
			return false;
		}
		else {
			String sql = "select * from branch where b_no='" + no + "'";
			DBControler db = new DBControler();
			db.connect();
			db.executeQuery(sql);
			ResultSet rs = db.getResultSet();
			try {
				rs.last();
				int count = rs.getRow();
				if(count > 0) {
					msgBox("�̹� �ִ� ������ȣ �Դϴ�.");
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
		if(addr.getBytes().length > 60) {
			msgBox("�ּҰ� �ʹ� ��ϴ�.");
			return false;
		}
		
		
		phone = txtPhone.getText().trim();
		if(!numCheck(phone, true) || phone.getBytes().length > 16) {
			msgBox("��ȭ��ȣ�� �߸��� �����Դϴ�.");
			return false;
		}
		
		
		assets = txtAssets.getText().trim();
		if(!numCheck(assets, false)) {
			msgBox("�ڻ��Ѿ��� ���ڸ� �Է� �����մϴ�.");
			return false;
		}
		else if(assets.getBytes().length > 13) {
			msgBox("�ڻ��� 1�������ϸ� �Է°����մϴ�.");
			return false;
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
		String sql = "insert into branch values('"+no+"', '"+name+"', '"+addr+"', '"+phone+"', "+assets+")";
		DBControler db = new DBControler();
		db.connect();
		db.executeQuery(sql);
		db.disConnect();
		branchPane.eventBtnSelect();
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