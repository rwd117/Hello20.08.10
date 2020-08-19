package java실습_applet;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

//뭔가 항목중 고르는거는 아이템(체크박스, 리스트) 액션은 버튼, 텍스트필드 
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
		myLabel.setText("글을 입력해주세요");
		myLabel.setAlignment(Label.CENTER);
		myLabel.setBackground(Color.YELLOW);
		add(myLabel);
	}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==myTextField) {myLabel.setText("입력 완료");}
	}	
// 엔터를 누르면 입력완료라는 메세지가 뜸.
public void textValueChanged(TextEvent e) {
	if(e.getSource()==myTextField) {myLabel.setText("입력 :"+myTextField.getText());}
	}//텍스트필드에 입력하면 라벨에 자신이 치고있는 문장이 "입력:" 뒤에 나타남
}


