package java_½Ç½À_Kimjw;

public class test18 
{
	static int a;
	static int b;
	public static void swap() 
	{
		int temp=a;
		a=b;
		b=temp;
	}
	
	public static void main(String[]args) 
	{
		a=10;
		b=20;
		
		System.out.println(a+","+b);
		swap();
		System.out.println(a+","+b);
	}
}
