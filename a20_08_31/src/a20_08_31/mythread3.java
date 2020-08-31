package a20_08_31;




public class mythread3 {

	public static void main(String[] args) {
		
	
		
		Thread kim=new Thread(new Runnable() {//내부 인터페이스
			int num=0;
			
			@Override
			public void run() {
				while(true) {
					System.out.println(num);
					num++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		});
		
		
		
	}

}
