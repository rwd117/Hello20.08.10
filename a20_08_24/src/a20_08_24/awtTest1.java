package a20_08_24;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Label;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class awtTest1 extends Applet implements TextListener,
												ActionListener,
												ItemListener,
												AdjustmentListener    
{
	Label lbl;
	Button btn1,btn2;
	TextField txt1,txt2;
	TextArea ta;
	Checkbox chk1,chk2,chk3,chk4;
	CheckboxGroup cg;
	Choice ch;
	List list;
	Scrollbar sc;
	
	public void init() {
		this.setLayout(null);
		lbl=new Label("이름");
		lbl.setBounds(10,10,50,20);
		add(lbl);
		btn1=new Button("저장");
		btn2=new Button("취소");
		btn1.setBounds(70,40,100,20);
		add(btn1);
		btn2.setBounds(200,40,100,20);
		add(btn2);
		
		txt1=new TextField(10);
		txt1.setBounds(70,10,100,20);
		add(txt1);
		
		
		cg=new CheckboxGroup();
		chk1=new Checkbox("c++");
		chk2=new Checkbox("java");
		chk2.setBounds(80,60,50,20);
		chk1.setBounds(10,60,50,20);
		add(chk1);
		add(chk2);
		
		chk3=new Checkbox("남",cg,true);
		chk4=new Checkbox("여",cg,false);
		chk3.setBounds(150,60,50,20);
		chk4.setBounds(220,60,50,20);
		add(chk3);
		add(chk4);
		
		sc=new Scrollbar(Scrollbar.VERTICAL, 50, 0, 1,101);//버블사이즈는 0
		sc.setBounds(300,75,20,200);
		add(sc);
		
		ta=new TextArea(50,100);
		ta.setBounds(10,120,200,100);
		add(ta);
		
		ch=new Choice();
		
		ch.setBounds(10,90,100,20);
		ch.addItem("청소부");
		ch.addItem("작업부");
		ch.addItem("의사");
		add(ch);
		
		list=new List();
		list.add("잠");
		list.add("책 읽기");
		list.add("게임");
		list.setBounds(150,90,80,30);
		add(list);
		
	/*	txt1.addTextListener(this);*/
		txt1.addActionListener(this);
		chk1.addItemListener(this);
		chk2.addItemListener(this);
		chk3.addItemListener(this);
		chk4.addItemListener(this);
		ch.addItemListener(this);
		list.addItemListener(this);
		sc.addAdjustmentListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}

	
	public void textValueChanged(TextEvent e) {
		if(e.getSource()==txt1) {
			ta.append(txt1.getText()+"\n");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==txt1) {
			ta.append(txt1.getText()+"\n");
		}
		
		if(e.getSource()==btn1) {
			ta.append(txt1.getText()+"\n");
			
			
		}else if(e.getSource()==btn2) {
			txt1.setText("");
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==chk1&&chk1.getState()==true) {
			ta.append(chk1.getLabel()+"\n");
		}else if(e.getSource()==chk2&&chk2.getState()==true) {
			ta.append(chk2.getLabel()+"\n");
		}
		
		if(e.getSource()==chk3 ) {
			ta.append(chk3.getLabel()+"\n");
		}else if(e.getSource()==chk4 ) {
			ta.append(chk4.getLabel()+"\n"); 
		}
		
		if(e.getSource()==ch) {
			ta.append(ch.getSelectedItem()+"\n");
		}
		
		if(e.getSource()==list) {
			ta.append(list.getSelectedItems()+"\n");
		}
	}


	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		if(e.getSource()==sc) {
			ta.append(sc.getValue()+"\n");
		}
	
	}
	
}
