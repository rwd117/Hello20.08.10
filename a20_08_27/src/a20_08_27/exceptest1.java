package a20_08_27;

public class exceptest1 
{
	public static void main(String[]args) {
		int a,res=0;
		try {
		a=10;
		res=a/0;
		}
		catch(Exception e) {
		e.printStackTrace();//¿¹¿Ü¸¦ ÃßÃ´ 
		};
		
		System.out.println(res);
	}
}
