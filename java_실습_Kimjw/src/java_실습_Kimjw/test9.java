package java_½Ç½À_Kimjw;

public class test9 
{
	public static void main(String[] args) 
	{
		int x,y,z;
		x=y=z=1;
		z+=x+y;//z=z+x+y
		System.out.println(x+","+y+","+z);
		
		x+=y-=z=5;//x=x+y y=y-z z=5  
		System.out.println(x+","+y+","+z);
	}
}
