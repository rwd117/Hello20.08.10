package java_½Ç½À_Kimjw;

public class test22 
{
	public static int max(int x, int y)
	{
		if(x>y) {return x;}
		else {return y;}
	}
	
	public static double max(double x, double y) 
	{
		if(x>y) {return x;}
		else {return y;}
	}
	public static void main(String[]args) 
	{
		int a=10;
		int b=20;
		System.out.println(max(a,b));
		
		double c=10.5;
		double d=20.5;
		System.out.println(max(c,d));
		
		
		
	}
}
