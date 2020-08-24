import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CalTest implements ActionListener {

	private JFrame frame;
	JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,
	btn12,btn13,btn14,btn15,btn16,btn17;
	JTextArea ta;
	String str="";
	double num,result;
	char op;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalTest window = new CalTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 371, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btn0 = new JButton("0");
		btn0.setBounds(120, 150, 121, 52);
		frame.getContentPane().add(btn0);
		
		btn1 = new JButton("1");
		btn1.setBounds(0, 0, 121, 52);
		frame.getContentPane().add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBounds(120, 0, 121, 52);
		frame.getContentPane().add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBounds(240, 0, 121, 52);
		frame.getContentPane().add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBounds(0, 50, 121, 52);
		frame.getContentPane().add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBounds(120, 50, 121, 52);
		frame.getContentPane().add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBounds(240, 50, 121, 52);
		frame.getContentPane().add(btn6);
		
		btn7 = new JButton("7");
		btn7.setBounds(0, 100, 121, 52);
		frame.getContentPane().add(btn7);
			
		
		btn8 = new JButton("8");
		btn8.setBounds(120, 100, 121, 52);
		frame.getContentPane().add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBounds(240, 100, 121, 52);
		frame.getContentPane().add(btn9);
		
		btn10 = new JButton("+");
		btn10.setBounds(0, 200, 121, 52);
		frame.getContentPane().add(btn10);
		
		btn11 = new JButton("-");
		btn11.setBounds(120, 200, 121, 52);
		frame.getContentPane().add(btn11);
		
		btn12 = new JButton("\u00D7");
		btn12.setBounds(240, 200, 121, 52);
		frame.getContentPane().add(btn12);
		
		btn13 = new JButton("\u00F7");
		btn13.setBounds(0, 252, 121, 52);
		frame.getContentPane().add(btn13);
		
		btn14 = new JButton("=");
		btn14.setBounds(240, 252, 121, 52);
		frame.getContentPane().add(btn14);
		
		btn15 = new JButton("AC");
		btn15.setBounds(0, 150, 121, 52);
		frame.getContentPane().add(btn15);
		
		btn16 = new JButton("");
		btn16.setBounds(240, 150, 121, 52);
		frame.getContentPane().add(btn16);
		
		btn17 = new JButton("");
		btn17.setBounds(120, 252, 121, 52);
		frame.getContentPane().add(btn17);
		
		ta= new JTextArea();
		ta.setBounds(0, 306, 355, 152);
		frame.getContentPane().add(ta);
		
		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		btn12.addActionListener(this);
		btn13.addActionListener(this);
		btn14.addActionListener(this);
		btn15.addActionListener(this);
		btn16.addActionListener(this);
		btn17.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn0) {
			str=str+""+0;
			ta.setText(str);
		}else if(e.getSource()==btn1) {
			str=str+""+1;
			ta.setText(str);
		}
		else if(e.getSource()==btn2) {
			str=str+""+2;
			ta.setText(str);
		}
		else if(e.getSource()==btn3) {
			str=str+""+3;
			ta.setText(str);
		}
		else if(e.getSource()==btn4) {
			str=str+""+4;
			ta.setText(str);
		}
		else if(e.getSource()==btn5) {
			str=str+""+5;
			ta.setText(str);
		}
		else if(e.getSource()==btn6) {
			str=str+""+6;
			ta.setText(str);
		}
		else if(e.getSource()==btn7) {
			str=str+""+7;
			ta.setText(str);
		}
		else if(e.getSource()==btn8) {
			str=str+""+8;
			ta.setText(str);
		}
		else if(e.getSource()==btn9) {
			str=str+""+9;
			ta.setText(str);
		}
		
		else if(e.getSource()==btn17) 
		{
			str="꽝!";
			ta.setText(str);
		}else if (e.getSource()==btn16) {
			str="트릭쇼";
			ta.setText(str);
		}
		//10 +,11 -, 12"\u00D7",13"\u00F7",14 =,15 AC,16,17
		if(e.getSource()==btn10) {
			if(str!="") {
				op='+';
				ta.setText(str);
				num=Double.parseDouble(str);
				str="";
				}
		}else if(e.getSource()==btn11) {
			if(str!="") {
				op='-';
				ta.setText(str);
				num=Double.parseDouble(str);
				str="";
				}
		}else if(e.getSource()==btn12) {
			if(str!="") {
				op='\u00D7';
				ta.setText(str);
				num=Double.parseDouble(str);
				str="";
				}
		}else if(e.getSource()==btn13) {
			if(str!="") {
				op='\u00F7';
				ta.setText(str);
				num=Double.parseDouble(str);
				str="";
				}
				}else if(e.getSource()==btn14) {
			if(str!="") {
				//10 +,11 -, 12"\u00D7",13"\u00F7",14 =,15 AC,16,17
				if(op=='+') {
					result=num+Double.parseDouble(str);
					ta.setText(Double.toString(result));
					str=Double.toString(result);
				}else if(op=='-') {
					result=num-Double.parseDouble(str);
					ta.setText(Double.toString(result));
					str=Double.toString(result);
				}else if(op=='\u00D7') {
					result=num*Double.parseDouble(str);
					ta.setText(Double.toString(result));
					str=Double.toString(result);
				}else if(op=='\u00F7') {
					if(Double.parseDouble(str)==0){ 
					ta.setText("0으로는 나눌 수 없습니다.");
					str="";
					}else {
					result=num/Double.parseDouble(str);
					ta.setText(Double.toString(result));
					str=Double.toString(result);}
					}
				}
			
		}else if(e.getSource()==btn15) 
			{
			str="";
			ta.setText(str);
			}
	}
}
