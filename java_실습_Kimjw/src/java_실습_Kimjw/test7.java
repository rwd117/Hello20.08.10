package java_�ǽ�_Kimjw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class test7 
{
	public static void main(String[] args) throws IOException 
	{
		Random r=new Random();
		int computer=Math.abs(r.nextInt()%3);
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		String user;
		System.out.print("�ϳ� ����(����=a,����=b,��=c):");
		user=in.readLine();
		
		if(user.equals("a")) 
		{	if(computer==0) System.out.println("���");
		    if(computer==1) System.out.println("���Ͱ� �̱�");
		    if(computer==2)	System.out.println("����� �̱�");
		}
		else if(user.equals("b")) 
		{
			if(computer==1) System.out.println("���");
		    if(computer==2) System.out.println("���Ͱ� �̱�");
		    if(computer==0)	System.out.println("����� �̱�");
		}
		else if(user.equals("c"))
		{
			if(computer==2) System.out.println("���");
		    if(computer==0) System.out.println("���Ͱ� �̱�");
		    if(computer==1)	System.out.println("����� �̱�");
		}
	
	}
}
