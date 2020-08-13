package java_½Ç½À_Kimjw;

public class test12 
{
	public static void main(String[] args) 
	{
		int myint=5316;
		System.out.println(myint);
		
		String myString=new Integer(myint).toString();
		System.out.println(myString);
		
		myString=myString.replace('6','4');
		
		float myFloat=Float.valueOf(myString).floatValue();
		System.out.println(myFloat);
	}
}
