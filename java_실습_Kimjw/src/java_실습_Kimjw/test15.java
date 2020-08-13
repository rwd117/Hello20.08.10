package java_실습_Kimjw;

public class test15 
{
public static void main(String[] args) 
{
	String num="11";
	
	try //try catch finally 순, try실행중 예외발생일어나면 cathch로 finally는 둘다 거쳐감.
	//try에서 이외의 상황이 발생하면 catch로 넘어감
	{
		int bin= Integer.parseInt(num,2);//2진수로
		int oct= Integer.parseInt(num,8);//8진수로
		int dec= Integer.parseInt(num,10);//10진수
		int hex= Integer.parseInt(num,16);//16진수
		
		System.out.println(num);
		System.out.println(bin);
		System.out.println(oct);
		System.out.println(dec);
		System.out.println(hex);
		
		
	}catch(NumberFormatException e) 
	{
		System.out.println("Error"+e);
	}






}
}
