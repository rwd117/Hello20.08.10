package java_�ǽ�_Kimjw;

public class test15 
{
public static void main(String[] args) 
{
	String num="11";
	
	try //try catch finally ��, try������ ���ܹ߻��Ͼ�� cathch�� finally�� �Ѵ� ���İ�.
	//try���� �̿��� ��Ȳ�� �߻��ϸ� catch�� �Ѿ
	{
		int bin= Integer.parseInt(num,2);//2������
		int oct= Integer.parseInt(num,8);//8������
		int dec= Integer.parseInt(num,10);//10����
		int hex= Integer.parseInt(num,16);//16����
		
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
