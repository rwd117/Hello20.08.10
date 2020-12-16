package State;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Main.MainPc;
import Set.RoundedButton;

public class Seat extends JFrame implements ActionListener{
	private JFrame frame =new JFrame();
	private RoundedButton BtnEx,BtnEx2;
	private RoundedButton[] Btn= new RoundedButton[49];
	
	private JButton BtnBack;
	private String Text;
	/**
	 * Create the application.
	 */
	public Seat() {
		initialize();
	}
	
	public static void main(String[] args) {
		new Seat();
//		PCserver pc=new PCserver();
//		pc.setGui(Seat);
//		pc.setting();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(051, 051, 051));
		frame.setBounds(120, 150, 1600, 850);
		frame.setVisible(true);

		Btn[1] = new RoundedButton("1") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[1].setBounds(164, 163, 98, 98);
		Btn[1].setBackground(new Color(153, 204, 255));
		frame.add(Btn[1]);

		Btn[2] = new RoundedButton("2") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[2].setBounds(263, 163, 98, 98);
		Btn[2].setBackground(new Color(153, 204, 255));
		frame.add(Btn[2]);

		Btn[3] = new RoundedButton("3") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[3].setBounds(362, 163, 98, 98);
		Btn[3].setBackground(new Color(153, 204, 255));
		frame.add(Btn[3]);

		Btn[4] = new RoundedButton("4") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[4].setBounds(461, 163, 98, 98);
		Btn[4].setBackground(new Color(153, 204, 255));
		frame.add(Btn[4]);

		Btn[5] = new RoundedButton("5") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[5].setBounds(560, 163, 98, 98);
		Btn[5].setBackground(new Color(153, 204, 255));
		frame.add(Btn[5]);

		Btn[6] = new RoundedButton("6") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[6].setBounds(164, 270, 98, 98);
		Btn[6].setBackground(new Color(153, 204, 255));
		frame.add(Btn[6]);

		Btn[7] = new RoundedButton("7") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[7].setBounds(263, 270, 98, 98);
		Btn[7].setBackground(new Color(153, 204, 255));
		frame.add(Btn[7]);

		Btn[8] = new RoundedButton("8") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[8].setBounds(362, 270, 98, 98);
		Btn[8].setBackground(new Color(153, 204, 255));
		frame.add(Btn[8]);

		Btn[9] = new RoundedButton("9") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[9].setBounds(461, 270, 98, 98);
		Btn[9].setBackground(new Color(153, 204, 255));
		frame.add(Btn[9]);

		Btn[10] = new RoundedButton("10") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[10].setBounds(560, 270, 98, 98);
		Btn[10].setBackground(new Color(153, 204, 255));
		frame.add(Btn[10]);

		Btn[11] = new RoundedButton("11") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[11].setBounds(164, 468, 98, 98);
		Btn[11].setBackground(new Color(153, 204, 255));
		frame.add(Btn[11]);

		Btn[12] = new RoundedButton("12") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[12].setBounds(263, 468, 98, 98);
		Btn[12].setBackground(new Color(153, 204, 255));
		frame.add(Btn[12]);

		Btn[13] = new RoundedButton("13") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[13].setBounds(362, 468, 98, 98);
		Btn[13].setBackground(new Color(153, 204, 255));
		frame.add(Btn[13]);

		Btn[14] = new RoundedButton("14") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[14].setBounds(461, 468, 98, 98);
		Btn[14].setBackground(new Color(153, 204, 255));
		frame.add(Btn[14]);

		Btn[15] = new RoundedButton("15") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[15].setBounds(560, 468, 98, 98);
		Btn[15].setBackground(new Color(153, 204, 255));
		frame.add(Btn[15]);

		Btn[16] = new RoundedButton("16") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[16].setBounds(164, 575, 98, 98);
		Btn[16].setBackground(new Color(153, 204, 255));
		frame.add(Btn[16]);

		Btn[17] = new RoundedButton("17") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[17].setBounds(263, 575, 98, 98);
		Btn[17].setBackground(new Color(153, 204, 255));
		frame.add(Btn[17]);

		Btn[18] = new RoundedButton("18") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[18].setBounds(362, 575, 98, 98);
		Btn[18].setBackground(new Color(153, 204, 255));
		frame.add(Btn[18]);

		Btn[19] = new RoundedButton("19") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[19].setBounds(461, 575, 98, 98);
		Btn[19].setBackground(new Color(153, 204, 255));
		frame.add(Btn[19]);

		Btn[20] = new RoundedButton("20") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[20].setBounds(560, 575, 98, 98);
		Btn[20].setBackground(new Color(153, 204, 255));
		frame.add(Btn[20]);

		Btn[21] = new RoundedButton("21") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[21].setBounds(836, 60, 98, 98);
		Btn[21].setBackground(new Color(153, 204, 255));
		frame.add(Btn[21]);

		Btn[22] = new RoundedButton("22") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[22].setBounds(836, 160, 98, 98);
		Btn[22].setBackground(new Color(153, 204, 255));
		frame.add(Btn[22]);

		Btn[23] = new RoundedButton("23") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[23].setBounds(836, 260, 98, 98);

		Btn[23].setBackground(new Color(153, 204, 255));
		frame.add(Btn[23]);

		Btn[24] = new RoundedButton("24") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[24].setBounds(836, 360, 98, 98);

		Btn[24].setBackground(new Color(153, 204, 255));
		frame.add(Btn[24]);
		Btn[25] = new RoundedButton("25") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[25].setBounds(836, 460, 98, 98);

		Btn[25].setBackground(new Color(153, 204, 255));
		frame.add(Btn[25]);
		Btn[26] = new RoundedButton("26") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[26].setBounds(836, 560, 98, 98);

		Btn[26].setBackground(new Color(153, 204, 255));
		frame.add(Btn[26]);
		Btn[27] = new RoundedButton("27") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[27].setBounds(836, 660, 98, 98);

		Btn[27].setBackground(new Color(153, 204, 255));
		frame.add(Btn[27]);
		Btn[28] = new RoundedButton("28") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[28].setBounds(943, 60, 98, 98);

		Btn[28].setBackground(new Color(153, 204, 255));
		frame.add(Btn[28]);
		Btn[29] = new RoundedButton("29") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[29].setBounds(943, 160, 98, 98);

		Btn[29].setBackground(new Color(153, 204, 255));
		frame.add(Btn[29]);
		Btn[30] = new RoundedButton("30") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[30].setBounds(943, 260, 98, 98);

		Btn[30].setBackground(new Color(153, 204, 255));
		frame.add(Btn[30]);
		Btn[31] = new RoundedButton("31") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[31].setBounds(943, 360, 98, 98);

		Btn[31].setBackground(new Color(153, 204, 255));
		frame.add(Btn[31]);
		Btn[32] = new RoundedButton("32") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[32].setBounds(943, 460, 98, 98);

		Btn[32].setBackground(new Color(153, 204, 255));
		frame.add(Btn[32]);
		Btn[33] = new RoundedButton("33") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[33].setBounds(943, 560, 98, 98);

		Btn[33].setBackground(new Color(153, 204, 255));
		frame.add(Btn[33]);
		Btn[34] = new RoundedButton("34") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[34].setBounds(943, 660, 98, 98);

		Btn[34].setBackground(new Color(153, 204, 255));
		frame.add(Btn[34]);
		Btn[35] = new RoundedButton("35") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[35].setBounds(1169, 60, 98, 98);

		Btn[35].setBackground(new Color(153, 204, 255));
		frame.add(Btn[35]);
		Btn[36] = new RoundedButton("36") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[36].setBounds(1169, 160, 98, 98);

		Btn[36].setBackground(new Color(153, 204, 255));
		frame.add(Btn[36]);
		Btn[37] = new RoundedButton("37") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[37].setBounds(1169, 260, 98, 98);

		Btn[37].setBackground(new Color(153, 204, 255));
		frame.add(Btn[37]);
		Btn[38] = new RoundedButton("38") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[38].setBounds(1169, 360, 98, 98);

		Btn[38].setBackground(new Color(153, 204, 255));
		frame.add(Btn[38]);
		Btn[39] = new RoundedButton("39") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[39].setBounds(1169, 460, 98, 98);

		Btn[39].setBackground(new Color(153, 204, 255));
		frame.add(Btn[39]);
		Btn[40] = new RoundedButton("40") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[40].setBounds(1169, 560, 98, 98);

		Btn[40].setBackground(new Color(153, 204, 255));
		frame.add(Btn[40]);
		Btn[41] = new RoundedButton("41") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[41].setBounds(1169, 660, 98, 98);

		Btn[41].setBackground(new Color(153, 204, 255));
		frame.add(Btn[41]);
		Btn[42] = new RoundedButton("42") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[42].setBounds(1275, 60, 98, 98);

		Btn[42].setBackground(new Color(153, 204, 255));
		frame.add(Btn[42]);
		Btn[43] = new RoundedButton("43") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[43].setBounds(1275, 160, 98, 98);

		Btn[43].setBackground(new Color(153, 204, 255));
		frame.add(Btn[43]);
		Btn[44] = new RoundedButton("44") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[44].setBounds(1275, 260, 98, 98);

		Btn[44].setBackground(new Color(153, 204, 255));
		frame.add(Btn[44]);
		Btn[45] = new RoundedButton("45") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[45].setBounds(1275, 360, 98, 98);

		Btn[45].setBackground(new Color(153, 204, 255));
		frame.add(Btn[45]);
		Btn[46] = new RoundedButton("46") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[46].setBounds(1275, 460, 98, 98);

		Btn[46].setBackground(new Color(153, 204, 255));
		frame.add(Btn[46]);
		Btn[47] = new RoundedButton("47") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[47].setBounds(1275, 560, 98, 98);

		Btn[47].setBackground(new Color(153, 204, 255));
		frame.add(Btn[47]);
		Btn[48] = new RoundedButton("48") {
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				if (getModel().isArmed()) {
					graphics.setColor(getBackground().darker());
				} else if (getModel().isRollover()) {
					graphics.setColor(getBackground().brighter());
				} else {
					graphics.setColor(getBackground());
				}
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		Btn[48].setBounds(1275, 660, 98, 98);

		Btn[48].setBackground(new Color(153, 204, 255));
		frame.add(Btn[48]);
		
		BtnEx = new RoundedButton (""){
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				
				graphics.setColor(getBackground());
				
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		BtnEx.setBounds(14, 12, 50, 50);
		BtnEx.setBackground(new Color(153,204,255));
		frame.add(BtnEx);
		
		BtnEx2 = new RoundedButton (""){
			@Override
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				Graphics2D graphics = (Graphics2D) g;

				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				
				graphics.setColor(getBackground());
				
				graphics.fillRoundRect(0, 0, width, height, 10, 10);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent() * 3;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		BtnEx2.setBounds(14, 88, 50, 50);
		frame.add(BtnEx2);
		
		JLabel lblNewLabel = new JLabel("\uC0AC\uC6A9 \uAC00\uB2A5 ");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(110, 28, 127, 18);
		frame.add(lblNewLabel);
		
		JLabel label = new JLabel("\uC0AC\uC6A9 \uC911 \uD639\uC740 \uC0AC\uC6A9 \uBD88\uAC00");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		label.setForeground(Color.WHITE);
		label.setBounds(89, 106, 250, 18);
		frame.add(label);
		
		BtnBack = new JButton("È¨");
		BtnBack.setBounds(1501, 28, 75, 75);
		frame.add(BtnBack);
		
		BtnBack.addActionListener(this);
		Btn[1].addActionListener(this);
		Btn[2].addActionListener(this);
		Btn[4].addActionListener(this);
		Btn[5].addActionListener(this);
		Btn[6].addActionListener(this);
		Btn[7].addActionListener(this);
		Btn[8].addActionListener(this);
		Btn[9].addActionListener(this);
		Btn[10].addActionListener(this);
		Btn[11].addActionListener(this);
		Btn[12].addActionListener(this);
		Btn[13].addActionListener(this);
		Btn[14].addActionListener(this);
		Btn[15].addActionListener(this);
		Btn[16].addActionListener(this);
		Btn[17].addActionListener(this);
		Btn[18].addActionListener(this);
		Btn[19].addActionListener(this);
		Btn[20].addActionListener(this);
		Btn[21].addActionListener(this);
		Btn[22].addActionListener(this);
		Btn[23].addActionListener(this);
		Btn[24].addActionListener(this);
		Btn[25].addActionListener(this);
		Btn[26].addActionListener(this);
		Btn[27].addActionListener(this);
		Btn[28].addActionListener(this);
		Btn[29].addActionListener(this);
		Btn[30].addActionListener(this);
		Btn[31].addActionListener(this);
		Btn[32].addActionListener(this);
		Btn[33].addActionListener(this);
		Btn[34].addActionListener(this);
		Btn[35].addActionListener(this);
		Btn[36].addActionListener(this);
		Btn[37].addActionListener(this);
		Btn[38].addActionListener(this);
		Btn[39].addActionListener(this);
		Btn[40].addActionListener(this);
		Btn[41].addActionListener(this);
		Btn[42].addActionListener(this);
		Btn[43].addActionListener(this);
		Btn[44].addActionListener(this);
		Btn[45].addActionListener(this);
		Btn[46].addActionListener(this);
		Btn[47].addActionListener(this);
		Btn[48].addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			
		if(e.getActionCommand().equals("È¨")) {
			new MainPc();
			frame.dispose();
//		}else if(e.getSource().equals(Btn1)) {
//			Text=Btn1.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn2)) {
//			Text=Btn2.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn3)) {
//			Text=Btn3.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn4)) {
//			Text=Btn4.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn5)) {
//			Text=Btn5.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn6)) {
//			Text=Btn6.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn7)) {
//			Text=Btn7.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn8)) {
//			Text=Btn8.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn9)) {
//			Text=Btn9.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn10)) {
//			Text=Btn10.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn11)) {
//			Text=Btn11.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn12)) {
//			Text=Btn12.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn13)) {
//			Text=Btn13.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn14)) {
//			Text=Btn14.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn15)) {
//			Text=Btn15.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn16)) {
//			Text=Btn16.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn17)) {
//			Text=Btn17.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn18)) {
//			Text=Btn18.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn19)) {
//			Text=Btn19.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn20)) {
//			Text=Btn20.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn21)) {
//			Text=Btn21.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn22)) {
//			Text=Btn22.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn23)) {
//			Text=Btn23.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn24)) {
//			Text=Btn24.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn25)) {
//			Text=Btn25.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn26)) {
//			Text=Btn26.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn27)) {
//			Text=Btn27.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn28)) {
//			Text=Btn28.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn29)) {
//			Text=Btn29.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn30)) {
//			Text=Btn30.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn31)) {
//			Text=Btn31.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn32)) {
//			Text=Btn32.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn33)) {
//			Text=Btn33.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn34)) {
//			Text=Btn34.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn35)) {
//			Text=Btn35.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn36)) {
//			Text=Btn36.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn37)) {
//			Text=Btn37.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn38)) {
//			Text=Btn38.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn39)) {
//			Text=Btn39.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn40)) {
//			Text=Btn40.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn41)) {
//			Text=Btn41.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn42)) {
//			Text=Btn42.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn43)) {
//			Text=Btn43.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn44)) {
//			Text=Btn44.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn45)) {
//			Text=Btn45.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn46)) {
//			Text=Btn46.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn47)) {
//			Text=Btn47.getText();
//			new SeatState(Text);
//		}else if(e.getSource().equals(Btn48)) {
//			Text=Btn48.getText();
//			new SeatState(Text);
//		}
			}
	}
	
	public void connectClient() {
//		Btn[1].setBackground();
	}
	
}
