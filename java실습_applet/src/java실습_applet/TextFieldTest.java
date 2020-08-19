package java�ǽ�_applet;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

//���� �׸��� ���°Ŵ� ������(üũ�ڽ�, ����Ʈ) �׼��� ��ư, �ؽ�Ʈ�ʵ� 
public class TextFieldTest extends Applet implements ActionListener, TextListener 
{
	Label myLabel;
	TextField myTextField;
	
	public void init() {
		myTextField=new TextField();
		myTextField.addActionListener(this);
		myTextField.addTextListener(this);
		add(myTextField);
		
		myLabel=new Label();
		myLabel.setText("���� �Է����ּ���");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.YELLOW);
		add(myLabel);
	}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==myTextField) {myLabel.setText("�Է� �Ϸ�");}
	}	
// ���͸� ������ �Է¿Ϸ��� �޼����� ��.
public void textValueChanged(TextEvent e) {
	if(e.getSource()==myTextField) {myLabel.setText("�Է� :"+myTextField.getText());}
	}//�ؽ�Ʈ�ʵ忡 �Է��ϸ� �󺧿� �ڽ��� ġ���ִ� ������ "�Է�:" �ڿ� ��Ÿ��
}


