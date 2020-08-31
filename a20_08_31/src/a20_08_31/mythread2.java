package a20_08_31;

class mythre implements Runnable {
//run은 스레드랑 관계 없는 것. 
	int num=0;
	String name;
	public mythre() {}
	public mythre(String name) {this.name=name;}
	public void run() {
		while(true) {
			System.out.println(name+"="+num);
			num++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}

public class mythread2 {

	public static void main(String[] args) 
	{
		mythre kim=new mythre("dk");
		Thread th=new Thread(kim);
		th.start();
		
		mythre lee=new mythre("tl");
		Thread th2=new Thread(lee);
		th2.start();
		
		mythre park=new mythre("qkf");
		Thread th3=new Thread(park);
		th3.start();
	}

}
