package java_½Ç½À_Kimjw;

public class test25 {
	public static void main(String[] args)
	{
		int i,j;
		i=10;
		do 
		{
			j=0;
			do {
				System.out.print("*");
				j++;
			}while(j<i);
			System.out.println();
			i--;
		}while(i>0);
	}
}
