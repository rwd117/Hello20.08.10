import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class jdbcprostep1 implements ActionListener {

	private JFrame frame;
	private JTextField txtno;
	private JTextField txtna;
	private JTextField txtem;
	private JTextField txttel;
	private JTable table;
	JButton btnto,btnad,btnca,btnde,btnse;
	
	private static final int NONE=0;
	private static final int ADD=1;
	private static final int DELETE=2;
	private static final int SEARCH=3;
	private static final int TOTAL=4;
	int cmd=NONE;
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user="system";
	String password="123456";
	
	Connection con=null;
	PreparedStatement pst=null;
	
	String sqlTotal="select * from customer";
	String sqlInsert="insert into customer values(?,?,?,?)";
	String sqlDelete="delete from customer where name=?";
	String sqlUpdate="update customer set email? tel=? where code=?";
	String sqlSearch="select * from customer where name=?";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jdbcprostep1 window = new jdbcprostep1();
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
	public jdbcprostep1() throws Exception {
		initialize();
		init();
		dbcon();
	}
	public void dbcon() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uACE0\uAC1D\uAD00\uB9AC\uD504\uB85C\uADF8\uB7A8");
		frame.setBounds(100, 100, 529, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBC88\uD638");
		lblNewLabel.setBounds(28, 44, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uC774\uB984");
		label.setBounds(28, 106, 57, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uC774\uBA54\uC77C");
		label_1.setBounds(28, 169, 57, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_2.setBounds(28, 225, 57, 15);
		frame.getContentPane().add(label_2);
		
		txtno = new JTextField();
		txtno.setBounds(97, 41, 116, 21);
		frame.getContentPane().add(txtno);
		txtno.setColumns(10);
		
		txtna = new JTextField();
		txtna.setColumns(10);
		txtna.setBounds(97, 103, 116, 21);
		frame.getContentPane().add(txtna);
		
		txtem = new JTextField();
		txtem.setColumns(10);
		txtem.setBounds(97, 166, 116, 21);
		frame.getContentPane().add(txtem);
		
		txttel = new JTextField();
		txttel.setColumns(10);
		txttel.setBounds(97, 222, 116, 21);
		frame.getContentPane().add(txttel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 10, 275, 278);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnto = new JButton("\uC804\uCCB4\uBCF4\uAE30");
		btnto.setBounds(23, 381, 82, 23);
		frame.getContentPane().add(btnto);
		
		btnad = new JButton("\uCD94\uAC00");
		btnad.setBounds(117, 381, 82, 23);
		frame.getContentPane().add(btnad);
		
		btnde = new JButton("\uC0AD\uC81C");
		btnde.setBounds(211, 381, 82, 23);
		frame.getContentPane().add(btnde);
		
		btnse = new JButton("\uAC80\uC0C9");
		btnse.setBounds(305, 381, 82, 23);
		frame.getContentPane().add(btnse);
		
		btnca = new JButton("\uCDE8\uC18C");
		btnca.setBounds(399, 381, 82, 23);
		frame.getContentPane().add(btnca);
		
		btnto.addActionListener(this);
		btnad.addActionListener(this);
		btnca.addActionListener(this);
		btnde.addActionListener(this);
		btnse.addActionListener(this);
		
	}
	
	public void add() {
		//btnto,btnad,btnca,btnde,btnse;
		//txtno,txtna,txtem,txttel
		String no=txtno.getText();
		String na=txtna.getText();
		String em=txtem.getText();
		String tel=txttel.getText();
		
		try {
			pst=con.prepareStatement(sqlInsert);
			pst.setInt(1, Integer.valueOf(no));
			pst.setString(2, na);
			pst.setString(3, em);
			pst.setString(4, tel);
			int res=pst.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void del() {
		//btnto,btnad,btnca,btnde,btnse;
		//txtno,txtna,txtem,txttel
		String na=txtna.getText();
		try {
			pst=con.prepareStatement(sqlDelete);
			pst.setString(1, na);
			int res=pst.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void se() {
		//btnto,btnad,btnca,btnde,btnse;
		//txtno,txtna,txtem,txttel
		try {
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void to() {
		//btnto,btnad,btnca,btnde,btnse;
		//txtno,txtna,txtem,txttel
		try {
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void up() {
		//btnto,btnad,btnca,btnde,btnse;
		//txtno,txtna,txtem,txttel
		try {
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//btnto,btnad,btnca,btnde,btnse;
		//txtno,txtna,txtem,txttel
		
			if(e.getSource()==btnad) {
				if(cmd!=ADD) {
				call(ADD);	
				return;
				}
				add(); 
			}else if(e.getSource()==btnde) {
				if(cmd!=DELETE) {
				call(DELETE);
				return;
			}
				del();
			}else if(e.getSource()==btnse) {
				if(cmd!=SEARCH) {
				call(SEARCH);
				return;
			}	
				se();
			}else if(e.getSource()==btnto) {
				call(TOTAL);
				to();
			}	
				System.out.println("√Î");
				call(NONE);
				init();
	}
	public void init() {
		txtno.setText("");
		txtna.setText("");
		txtem.setText("");
		txttel.setText("");
		txtno.setEditable(false);
		txtna.setEditable(false);
		txtem.setEditable(false);
		txttel.setEditable(false);
		btnto.setEnabled(true);
		btnad.setEnabled(true);
		btnde.setEnabled(true);
		btnse.setEnabled(true);
		btnca.setEnabled(true);
	}
	public void call(int a) {
		//btnto,btnad,btnca,btnde,btnse;
		//txtno,txtna,txtem,txttel
		btnto.setEnabled(false);
		btnad.setEnabled(false);
		btnde.setEnabled(false);
		btnse.setEnabled(false);
		btnca.setEnabled(true);
		switch(a) {
			case ADD:	
				txtno.setEditable(true);
				txtna.setEditable(true);
				txtem.setEditable(true);
				txttel.setEditable(true);
				btnad.setEnabled(true);
				cmd=ADD;
				break;
		case DELETE:
				txtna.setEditable(true);
				btnde.setEnabled(true);
				cmd=DELETE;
				break;
		case SEARCH:
				txtna.setEditable(true);
				btnse.setEnabled(true);
				cmd=SEARCH;
				break;
		case TOTAL:
				cmd=TOTAL;
				break;
		case NONE:
				cmd=NONE;
				break;
		}
	}
}
