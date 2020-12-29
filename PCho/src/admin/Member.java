package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
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

public class Member extends JPanel implements ActionListener, MouseListener {

	private JFrame jframe;
	private JTable table;
	private JPanel pan;
	private Vector<String> v = new Vector<String>();
	private DefaultTableModel model;
	private JButton BtnBack;
	private int col;
	private int row;
	private StringBuffer buff;

	public Member(JFrame frame) {
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
		// �÷� ����
		model = new DefaultTableModel(getColumn(), 0) {
			public boolean isCellEditable(int row, int column) {
				if (column < this.getColumnCount()) {
					return false;
				}
				return true;
			}
		};
		// ���� ä���
		setRow();

		table = new JTable(model);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);

		// ��� ����
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		JLabel lblNewLabel = new JLabel("ȸ�� ����");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(750, 47, 293, 45);
		this.add(lblNewLabel);
		this.setVisible(true);

		BtnBack = new JButton("Ȩ");
		BtnBack.setBounds(1501, 28, 75, 75);
		this.add(BtnBack);

		BtnBack.addActionListener(this);
		table.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(BtnBack)) {
			int result = JOptionPane.showConfirmDialog(null, "Ȩ ȭ������ ���ư��ðڽ��ϱ�?", "Ȯ�� �޽���", JOptionPane.YES_NO_OPTION);
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
			getRowCount();// ����Ŭ���ϸ� ���̵� ���� �޾Ƴ� �����ͺ��̽��� ������ Ȯ�� â ���� �� Ȯ���� ������ �������� ���ڰ� ������Ʈ �Ǹ鼭 �Ѵ�.
			int result = JOptionPane.showConfirmDialog(null, getRowCount() + "���� ��й�ȣ�� �ٲٽðڽ��ϱ�?", "Ȯ�� �޽���",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION) {

			} else if (result == JOptionPane.YES_OPTION) {
				// JOptionPane.INFORMATION_MESSAGE(null,)
				getPwd();
				System.out.println(buff);
			}
		}
	}

	
	public void getPwd() {
		Random ran = new Random();
		for (int i = 0; i < 10; i++) {
				buff.append((char)((int) (ran.nextInt(26)) + 97));
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
		vec.addElement("���̵�");
		vec.addElement("��й�ȣ");
		vec.addElement("ȸ�� �̸�");
		vec.addElement("ȸ�� ��ȭ��ȣ");
		vec.addElement("ȸ�� �ð�");
		vec.addElement("���� ����");

		return vec;
	}

	private void setRow() {
		v = AdminDb.MemSearchDb();
		for (int i = 0; i < v.size(); i = i + 6) {
			Vector<String> row = new Vector<String>(6);
			row.addElement(v.get(i));
			row.addElement(v.get(i + 1));
			row.addElement(v.get(i + 2));
			row.addElement(v.get(i + 3));
			row.addElement(v.get(i + 4));
			row.addElement(v.get(i + 5));
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
