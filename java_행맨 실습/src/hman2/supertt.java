package hman2;

public class supertt 
{
	public static void main(String[] args) 
	{
		sucl superclass=new sucl();
		System.out.println("sucl의 메소드");
		superclass.print();
		
		sbc subclass=new sbc();
		
		System.out.println("sub의 메소드");
		subclass.prtint();
		
		System.out.println("sub에서 super.this로 호출");
		subclass.callscl();
	}
}
