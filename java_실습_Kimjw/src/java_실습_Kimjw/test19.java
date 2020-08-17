package java_½Ç½À_Kimjw;

public class test19 
{
	public static void swap(Number z)
	{
		int temp=z.x;
		z.x=z.y;
		z.y=temp;
	}
	
	
	
	public static void main(String[] args) 
	{
		Number i=new Number();
		i.x=10;
		i.y=20;
		System.out.println(i.x+","+i.y);
		swap(i);
		System.out.println(i.x+","+i.y);
	}
	
}
	class Number
	{
		public int x;
		public int y;
	}

