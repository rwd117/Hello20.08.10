package Graphics;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundedButton extends JButton {
	
		public RoundedButton() {
			super();
			decorate();
		}
		
		public RoundedButton(String text) {
			super(text);
			decorate();
		}
		public RoundedButton(Action aciton) {
			super(aciton);
			decorate();
		}
		public RoundedButton(Icon icon) {
			super(icon);
			decorate();
		}
		
		public RoundedButton(String text,Icon icon) {
			super(text,icon);
			decorate();
		}
		protected void decorate() {
			setBorderPainted(false);
			setOpaque(false);
		}
				
}
