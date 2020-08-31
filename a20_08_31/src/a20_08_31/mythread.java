package a20_08_31;

class mythr extends Thread{
	int num=0;
	String name;
	public mythr(){};
	public mythr(String name){this.name=name;};
	public void run() {
		
		while(true) {
			System.out.println(name+"="+num);
			num++;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//1000이 1초
		}
	}
	
	
}

public class mythread {

	public static void main(String[] args) 
	{
		mythr kim=new mythr("김");
		kim.start();
		
		mythr lee=new mythr("이");
		lee.start();
		
		mythr park=new mythr("박");
		park.setPriority(10);//우선순위 1등,가능한한 
		park.start();
	}

}
