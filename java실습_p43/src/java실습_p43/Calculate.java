package java실습_p43;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//패널,숫자판, 텍스트판, 입력한 값이 나타나도록, 각 사칙연산 계산 되도록

public class Calculate extends Applet implements ActionListener 
{
	Button[] btn=new Button[20];
	Panel pnl1;
	TextArea ta;	
	String str="";
	double num,result;
	char op;
	
	public void init() {
		
		setLayout(new BorderLayout());
		
		pnl1=new Panel();
		pnl1.setLayout(new GridLayout(6,3));
		
		btn[1]=new Button("1");
		pnl1.add(btn[1]);
		btn[2]=new Button("2");
		pnl1.add(btn[2]);
		btn[3]=new Button("3");
		pnl1.add(btn[3]);
		btn[4]=new Button("4");
		pnl1.add(btn[4]);
		btn[5]=new Button("5");
		pnl1.add(btn[5]);
		btn[6]=new Button("6");
		pnl1.add(btn[6]);
		btn[7]=new Button("7");
		pnl1.add(btn[7]);
		btn[8]=new Button("8");
		pnl1.add(btn[8]);
		btn[9]=new Button("9");
		pnl1.add(btn[9]);
		btn[10]=new Button("AC");
		pnl1.add(btn[10]);
		btn[0]=new Button("0");
		pnl1.add(btn[0]);
		btn[11]=new Button("");
		pnl1.add(btn[11]);
		btn[12]=new Button("+");
		pnl1.add(btn[12]);
		btn[13]=new Button("-");
		pnl1.add(btn[13]);
		btn[14]=new Button("×");
		pnl1.add(btn[14]);
		btn[15]=new Button("÷");
		pnl1.add(btn[15]);
		btn[16]=new Button("");
		pnl1.add(btn[16]);
		btn[17]=new Button("=");
		pnl1.add(btn[17]);
		
		add("Center",pnl1);
		
		ta=new TextArea(10,20);
		add("South",ta);
		
		for(int i=0;i<18;i++) {
			btn[i].addActionListener(this);
		}
	}
	//판은 만들었으니 입력한 값이 텍스트지역에 나타나도록 하고 그 것을 =실행했을때 실행 되도록.
	
	public void actionPerformed(ActionEvent e) 
	{	//9,ac
		//12,+,13,-,14,*,15,/,16,%,17,=
		// e.getsource()==변수과 e.getsource().equals(변수)는 같다
		for(int i=0;i<10;i++) {
			if(e.getSource()==btn[i]) {
				str=str+i;
				ta.setText(str);
			}
			}
		if(e.getSource()==btn[11]) 
		{
			str="꽝!";
			ta.setText(str);
		}else if (e.getSource()==btn[16]) {
			str="트릭쇼";
			ta.setText(str);
		}
		
		if(e.getSource()==btn[12]) {
			if(str!="") {
				op='+';
				ta.setText(str);
				num=Double.parseDouble(str);
				str="";
				}
		}else if(e.getSource()==btn[13]) {
			if(str!="") {
				op='-';
				ta.setText(str);
				num=Double.parseDouble(str);
				str="";
				}
		}if(e.getSource()==btn[14]) {
			if(str!="") {
				op='×';
				ta.setText(str);
				num=Double.parseDouble(str);
				str="";
				}
		}if(e.getSource()==btn[15]) {
			if(str!="") {
				op='÷';
				ta.setText(str);
				num=Double.parseDouble(str);
				str="";
				}
				}else if(e.getSource()==btn[17]) {
			if(str!="") {
				if(op=='+') {
					result=num+Double.parseDouble(str);
					ta.setText(Double.toString(result));
					str=Double.toString(result);
				}else if(op=='-') {
					result=num-Double.parseDouble(str);
					ta.setText(Double.toString(result));
					str=Double.toString(result);
				}else if(op=='×') {
					result=num*Double.parseDouble(str);
					ta.setText(Double.toString(result));
					str=Double.toString(result);
				}else if(op=='÷') {
					if(Double.parseDouble(str)==0){ 
					ta.setText("0으로는 나눌 수 없습니다.");
					str="";
					}else {
					result=num/Double.parseDouble(str);
					ta.setText(Double.toString(result));
					str=Double.toString(result);}
					}
				}
			
		}else if(e.getSource()==btn[10]) 
			{
			str="";
			ta.setText(str);
			}
	}
	
}
