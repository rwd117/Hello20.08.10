package java_실습_Kimjw;

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
		System.out.print("하나 선택(가위=a,바위=b,보=c):");
		user=in.readLine();
		
		if(user.equals("a")) 
		{	if(computer==0) System.out.println("비김");
		    if(computer==1) System.out.println("컴터가 이김");
		    if(computer==2)	System.out.println("사람이 이김");
		}
		else if(user.equals("b")) 
		{
			if(computer==1) System.out.println("비김");
		    if(computer==2) System.out.println("컴터가 이김");
		    if(computer==0)	System.out.println("사람이 이김");
		}
		else if(user.equals("c"))
		{
			if(computer==2) System.out.println("비김");
		    if(computer==0) System.out.println("컴터가 이김");
		    if(computer==1)	System.out.println("사람이 이김");
		}
	
	}
}
