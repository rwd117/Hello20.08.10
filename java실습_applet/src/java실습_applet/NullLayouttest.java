package java�ǽ�_applet;

import java.applet.*;
import java.awt.*;

public class NullLayouttest extends Applet
{
	Label myLabel;
	Button myButton;
	TextField myTextField;
	Checkbox myCheckbox;
	
	public void init() {
		setLayout(null);
		
		myButton = new Button("�� ��ư");
		myButton.setBounds(150,20,100,20);
		add(myButton);
		
		myLabel=new Label("�� ���̺�", Label.CENTER);
		myLabel.setBackground(Color.YELLOW);
		myLabel.setBounds(150,50,100,20);
		add(myLabel);
		
		myTextField=new TextField("�� �ؽ�Ʈ �ʵ�");
		myTextField.setBounds(150,80,100,20);
		add(myTextField);
		
		myCheckbox=new Checkbox("�� üũ�ڽ�", true);
		myCheckbox.setBounds(150,110,100,20);
		add(myCheckbox);
	}
}
