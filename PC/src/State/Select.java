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

import Graphics.RoundedButton;
import Main.MainPc;
import User.TimeInsert;
import User.UserLogin;

public class Select extends JFrame implements ActionListener{

	private RoundedButton BtnUser, BtnNoUser;
	private JFrame frame = new JFrame();
	private JButton BtnBack ;
	
	public static void main(String[] args) {
		new Select();
	}
	
	public Select() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(051, 051, 051));
		frame.setBounds(120, 150, 1600, 800);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		BtnUser = new RoundedButton("\uD68C\uC6D0"){
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
				graphics.fillRoundRect(0, 0, width, height, 30, 30);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 2 + fontMetrics.getAscent();
				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		BtnUser.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		BtnUser.setBounds(400, 249, 271, 249);
		BtnUser.setBackground(new Color(051, 102, 153));
		frame.getContentPane().add(BtnUser);
		
		BtnNoUser = new RoundedButton("\uBE44\uD68C\uC6D0"){
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
				graphics.fillRoundRect(0, 0, width, height, 30, 30);

				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

				int textX = (width - stringBounds.width) / 2;
				int textY = (width - stringBounds.width) / 5 + fontMetrics.getAscent() * 3 ;

				graphics.setColor(getForeground());

				graphics.setFont(getFont());

				graphics.drawString(getText(), textX, textY);
				graphics.dispose();

				super.paintComponent(g);
			}
		};
		BtnNoUser.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		BtnNoUser.setBounds(900, 249, 271, 249);
		BtnNoUser.setBackground(new Color(051, 102, 153));
		frame.getContentPane().add(BtnNoUser);
		
		BtnBack = new JButton("È¨");
		BtnBack.setBounds(1501, 28, 75, 75);
		frame.getContentPane().add(BtnBack);
		
		BtnBack.addActionListener(this);
		BtnUser.addActionListener(this);
		BtnNoUser.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(BtnUser)) {
			new UserLogin(true);
			frame.dispose();
		}else if(e.getSource().equals(BtnNoUser)) {
			new UserLogin(false);
			frame.dispose();
		}else if(e.getActionCommand().equals("È¨")) {
			new MainPc();
			frame.dispose();
		}
	}
}
