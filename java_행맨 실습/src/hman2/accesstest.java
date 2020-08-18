package hman2;

public class accesstest 
{
	public static void main(String[] args) 
	{
		d dd=new d();
		e ee=new e();
		f ff=new f();
		
		dd.a=500;
		
		dd.method_A();
		dd.method_D();
		
		ee.method_E();
		ff.method_F();
		
		System.out.println(dd.a);
		System.out.println(ee.b);
		System.out.println(ff.c);
	}
}
