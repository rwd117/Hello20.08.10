package java_�ǽ�_Kimjw;

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
		//<<,>>�� ������ ����Ʈ ���� ����Ʈ�� �ǹ�
		x=x<<2;//4�� ���ߴ�
		y=y<<2;
		System.out.println(x+","+y);
		System.out.println("--------------");
		x=x>>2;//4�� ����
		y=y>>2;
		System.out.println(x+","+y);
		System.out.println("--------------");
		x=y>>2;//���� �ٲٰ� 4�� ����?
		y=y>>>2;
		System.out.println(x+","+y);
		System.out.println("--------------");
		
		int z=10;
		
		z=z>>>2;//4��
		System.out.println(z);
		System.out.println("--------------");
		z=z<<2;
		System.out.println(z);
		
	
	}
}
