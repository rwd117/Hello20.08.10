package java_½Ç½À_Kimjw;

public class test20 {
	public static int power(int x, int y) 
	{
		if(y<=0) 
		{return 1;}
		else {return x*power(x,y-1);}
	}
	public static void main(String[] args) 
	{
		System.out.println(power(2,1));
		System.out.println(power(2,2));
		System.out.println(power(2,3));
		System.out.println(power(2,4));
		System.out.println(power(2,5));
	}

}
