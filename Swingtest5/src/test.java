import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class test {

	private JFrame frame;
	JLabel lbl,lbl2;
	Thread thr;	
	Calendar now=Calendar.getInstance();
	int year=now.get(Calendar.YEAR);
	int month=now.get(Calendar.MONTH)+1;
	int date=now.get(Calendar.DATE);
	int hour=now.get(Calendar.HOUR);
	int min=now.get(Calendar.MINUTE);
	int sec=now.get(Calendar.SECOND);
	String str=year+"³â  "+month+"¿ù  "+date+"ÀÏ  "+hour+":"+min+":"+sec;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public test() {
		initialize();
		
	}
	
	/*if(thr==null) {
		thr=new Thread(this);
		thr.start();
	}
	if((thr!=null)&&(thr.isAlive())){
		thr=null;
	}*/
	
	public void run() {
		while(true) {
			try {
				thr.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl = new JLabel("\uC624\uB298\uC758 \uB0A0\uC9DC\uC640 \uC2DC\uAC04");
		lbl.setBounds(12, 10, 116, 28);
		frame.getContentPane().add(lbl);
		
		lbl2 = new JLabel();
		lbl2.setText(str);
		lbl2.setBounds(12, 76, 410, 175);
		frame.getContentPane().add(lbl2);
		
	}
}
