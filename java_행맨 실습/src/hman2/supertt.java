package hman2;

public class supertt 
{
	public static void main(String[] args) 
	{
		sucl superclass=new sucl();
		System.out.println("sucl�� �޼ҵ�");
		superclass.print();
		
		sbc subclass=new sbc();
		
		System.out.println("sub�� �޼ҵ�");
		subclass.prtint();
		
		System.out.println("sub���� super.this�� ȣ��");
		subclass.callscl();
	}
}
