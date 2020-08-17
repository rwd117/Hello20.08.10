package java_½Ç½À_Kimjw;

public class test28 {
	public static void main(String[]args) 
	{
		int[] a1= {1,3,5,7,9};
		int[] a2;
		a2=new int[a1.length];
		for(int i=0;i<a1.length;i++) 
		{
			a2[i]=a1[i];
		}
		for(int i=0;i<a1.length;i++)
		{
			System.out.print(a1[i]+"  ");
		}
		System.out.println();
		for(int i=0;i<a2.length;i++)
		{
			System.out.print(a2[i]+"  ");
		}
		
	}
}
