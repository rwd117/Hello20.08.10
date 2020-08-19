package java실습_applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class TextAreaTest extends Applet implements TextListener
{
	Label myLabel;
	TextArea myTextArea;
	
	public void init() {
		myTextArea=new TextArea(20,10);
		myTextArea.addTextListener(this);
		add("Center",myTextArea);
		
		myLabel=new Label();
		myLabel.setText("글 입력");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.YELLOW);
		add("SOUTH",myLabel);
	}
	public void textValueChanged(TextEvent e) {
		if(e.getSource()==myTextArea) {
			myLabel.setText("입력 :"+myTextArea.getText());}
	}
}
