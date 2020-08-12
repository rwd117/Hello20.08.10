package java_실습_Kimjw;

public class test8 
{
	public static void main(String[] args) 
	{
		int x,y;
		
		x=8;
		y=~x;
		System.out.println(x+","+y);
		
		System.out.println(x+"a"+y+"="+(x&y));
		System.out.println(x+"o"+y+"="+(x|y));
		System.out.println(x+"xo"+y+"="+(x^y));
		System.out.println("--------------");
		//<<,>>는 오른쪽 시프트 왼쪽 시프트를 의미
		x=x<<2;//4를 곱했다
		y=y<<2;
		System.out.println(x+","+y);
		System.out.println("--------------");
		x=x>>2;//4를 나눔
		y=y>>2;
		System.out.println(x+","+y);
		System.out.println("--------------");
		x=y>>2;//서로 바꾸고 4를 나눔?
		y=y>>>2;
		System.out.println(x+","+y);
		System.out.println("--------------");
		
		int z=10;
		
		z=z>>>2;//4로
		System.out.println(z);
		System.out.println("--------------");
		z=z<<2;
		System.out.println(z);
		
	
	}
}
