package java½Ç½À_applet;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class TexttFieldtest2 extends Applet implements ActionListener
{
	Button button;
	TextField textfield;
	
	public void init() {
		textfield=new TextField("",20);
		button=new Button("¡ç");
		
		add(textfield);
		add(button);
		button.addActionListener(this);
		button.setBounds(100, 200, 122, 30);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			String name=textfield.getText();
		int len=name.length();
		textfield.setText("");
		if(len>0) {
			for(int i=0;i<len-1;i++) {
				textfield.setText(textfield.getText()+name.charAt(i));
			}
		}
		}
	}
}
