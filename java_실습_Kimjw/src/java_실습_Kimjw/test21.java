package java_½Ç½À_Kimjw;

public class test21 
{
	public static int power(int x, int y)
	{
		int sum=1;
		while(y>0) 
		{
			sum=sum*x;
			y--;
		}return sum;
	}
	public static void main(String[]args)
	{
		System.out.println(power(2,1));
		System.out.println(power(2,2));
		System.out.println(power(2,3));
		System.out.println(power(2,4));
		System.out.println(power(2,5));
		
	}
}
