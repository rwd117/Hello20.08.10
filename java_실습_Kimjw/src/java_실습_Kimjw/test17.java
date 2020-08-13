package java_½Ç½À_Kimjw;

public class test17
{
	public static void swap(int x, int y)
	{
		int temp;
		temp=x;
		   x=y;
		   y=temp;
	}
	
	
	public static void main(String[]args)
	{
		int a=10;
		int b=20;
		
		System.out.println(a+","+b);
		
		swap(a, b);
		
		System.out.println(a+","+b);



	}
}
