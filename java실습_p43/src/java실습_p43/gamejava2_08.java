package java�ǽ�_p43;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//���� ���߱� ����
public class gamejava2_08 extends Applet implements ActionListener 
{
	
	int count;//Ǭ Ƚ��
	int key;
	int strike, ball;
	
	int[] usr= new int[3]; //����ڰ� ���� ����
	int[] com=new int[3]; //��ǻ�Ͱ� �� ����
	
	boolean gameover=false;
	
	Label display;
	TextArea history;
	
	Panel numPanel;
	Button[] buttons=new Button[12];
	
	public void init() {
		Random r=new Random();
		com[0]=Math.abs(r.nextInt()%9+1);
		
		do {
			com[1]=Math.abs(r.nextInt()%9)+1;
		}while(com[1]==com[0]);
		
		do {
			com[2]=Math.abs(r.nextInt()%9)+1;
		}while((com[2]==com[0])||(com[2]==com[1]));
		
		System.out.println(com[0]+","+com[1]+","+com[2]);
			
		count=0;
		key=0;
		usr[0]=usr[1]=usr[2]=0;
		
		/*GUI*/
		setLayout(new BorderLayout());
		
		display=new Label();
		display.setAlignment(Label.RIGHT);
		add("North",display);
		
		numPanel=new Panel();
		numPanel.setLayout(new GridLayout(4,3));//������ ���� 4ĭ ���� 3ĭ
		
		for(int i=7;i>0;i-=3) {
			for(int j=0;j<3;j++) {
				buttons[i+j]=new Button(String.valueOf(i+j));
				numPanel.add(buttons[i+j]);
			}
		}
		buttons[0]=new Button("��");
		numPanel.add(buttons[0]);
		
		buttons[10]=new Button("�ٽ� �Է�");
		numPanel.add(buttons[10]);
		
		buttons[11]=new Button("�Է� �Ϸ�");
		numPanel.add(buttons[11]);
		
		add("Center", numPanel);
		
		history=new TextArea(10,20);
		add("South", history);
		
		for(int i=0;i<12;i++) {
			buttons[i].addActionListener(this);
		}
	}
	public void actionPerformed(ActionEvent e) {
		
		if(gameover) return;
		
		if(e.getSource()==buttons[0]) {
			if(key>0) {
				key--;
				display.setText("");
				for(int i=0;i<key;i++) {
					display.setText(display.getText()+usr[i]);
				}
			}
		}else if(e.getSource()==buttons[10]) {
			key=0;
			usr[0]=usr[1]=usr[2]=0;
			display.setText("");
		}else if(e.getSource()==buttons[11]) {
			if(key==3) {
				strike=ball=0;
				
				if(usr[0]==com[0]) strike++;
				if(usr[1]==com[1]) strike++;
				if(usr[2]==com[2]) strike++;
				
				if(usr[0]==com[1]) ball++;
				if(usr[0]==com[2]) ball++;
				if(usr[1]==com[0]) ball++;
				if(usr[1]==com[2]) ball++;
				if(usr[2]==com[0]) ball++;
				if(usr[2]==com[1]) ball++;
				
				history.append(usr[0]+","+usr[1]+","+usr[2]+"�� strike:"+strike+"ball:"+ball+"\n");
			
				count++;
				key=0;
				usr[0]=usr[1]=usr[2]=0;
				display.setText("");
				
				if((strike==3)||(count==11)) {
					if(count<=2) {history.append("\n�� : ��");}
					else if(count<=5) {history.append("\n�� : ��");}
					else if(count<=9) {history.append("\n�� : ����");}
					else {history.append("\n�� : �й�");}
				
				gameover=true;
				display.setText("game over!");
				history.append("\n\n<<<���� ��>>>");
				}
			}else 
			{
				}
			}
			else{ if(key<3) {
				char butVal=((Button)e.getSource()).getLabel().charAt(0);
				usr[key]=Integer.valueOf(String.valueOf(butVal)).intValue();
				
				boolean same=false;
				switch(key) {
				
				case 2:if(usr[key]==usr[1]) same=true;
				
				case 1:if(usr[key]==usr[0]) same=true;
				
				}
				
				if(same) {	}
				else {
					display.setText(display.getText()+butVal);
					key++;
				}
			}else {}
		}
	}	
}

