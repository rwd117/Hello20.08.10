package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Db.AdminDb;
import Main.MainPc;

public class NoUser extends JPanel implements ActionListener, MouseListener {

	private JFrame jframe;
	private JTable table;
	private JPanel pan;
	private Vector<String> v = new Vector<String>();
	private DefaultTableModel model;
	private JButton BtnBack;
	private int col;
	private int row;

	public NoUser(JFrame frame) {
		initialize();
		this.jframe = frame;
	}

	private void initialize() {
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(new Color(051, 051, 051));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 134, 1560, 525);
		this.add(scrollPane);
		// 컬럼 설정
		model = new DefaultTableModel(getColumn(), 0) {
			public boolean isCellEditable(int row, int column) {
				if (column < this.getColumnCount()) {
					return false;
				}
				return true;
			}
		};
		// 내용 채우기
		setRow();

		table = new JTable(model);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);

		// 가운데 정렬
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		JLabel lblNewLabel = new JLabel("회원 정보");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(750, 47, 293, 45);
		this.add(lblNewLabel);
		this.setVisible(true);

		BtnBack = new JButton("홈");
		BtnBack.setBounds(1501, 28, 75, 75);
		this.add(BtnBack);

		BtnBack.addActionListener(this);
		table.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(BtnBack)) {
			int result = JOptionPane.showConfirmDialog(null, "홈 화면으로 돌아가시겠습니까?", "확인 메시지", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {

			} else if (result == JOptionPane.YES_OPTION) {
				jframe.dispose();
				new MainPc();
			}
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2) {
			
		}
	}
	
	public Object getRowCount() {
		col = 0;
		row = table.getSelectedRow();
		Object value = table.getValueAt(row, col);

		return value;
	}

	
	private Vector<String> getColumn() {
		Vector<String> vec = new Vector<String>();
		
		vec.addElement("코드");
		vec.addElement("카드 번호");
		vec.addElement("충전한 시간");
		vec.addElement("사용자 이름");

		return vec;
	}

	private void setRow() {
		v = AdminDb.NoUserSearchDb();
		for (int i = 0; i < v.size(); i = i + 4) {
			Vector<String> row = new Vector<String>(6);
			row.addElement(v.get(i));
			row.addElement(v.get(i + 1));
			row.addElement(v.get(i + 2));
			row.addElement(v.get(i + 3));
			model.addRow(row);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

