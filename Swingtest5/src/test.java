import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class test implements Runnable {

	private JFrame frame;
	JLabel lbl,lbl2;
	Thread thr;	
	int year,month,date,hour,min,sec;
	String str;

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
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl = new JLabel("\uC624\uB298\uC758 \uB0A0\uC9DC\uC640 \uC2DC\uAC04");
		lbl.setBounds(12, 10, 116, 28);
		
		
		lbl2 = new JLabel();
		lbl2.setBounds(12, 76, 410, 175);

		Thread thr=new Thread(this);
		thr.start();
		
		frame.getContentPane().add(lbl);
		frame.getContentPane().add(lbl2);
	}
	
	
	
	public void run() {
		while(true) {
			Calendar now = Calendar.getInstance();
	        year=now.get(Calendar.YEAR);
			month=now.get(Calendar.MONTH)+1;
			date=now.get(Calendar.DATE);
			hour=now.get(Calendar.HOUR);
			min=now.get(Calendar.MINUTE);
			sec=now.get(Calendar.SECOND);
			
			str=year+"³â  "+month+"¿ù  "+date+"ÀÏ  "+hour+":"+min+":"+sec;
			lbl2.setText(str);
			try {
				thr.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
