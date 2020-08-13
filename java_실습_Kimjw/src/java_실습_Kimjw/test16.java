package java_실습_Kimjw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class test16 
{
public static void main(String[]args) throws IOException
{
	int x,y;
	Random r=new Random();
	
	if(args.length==1) {
		x=Integer.valueOf(args[0]).intValue();
	}else {
		x=Math.abs(r.nextInt()%9)+1;
	}
	
		y=Math.abs(r.nextInt()%9)+1;
		
		int num=x*y;
		System.out.println();
		System.out.println("구구단"+x+"단에 대한 문제");
		System.out.println();
		
		System.out.println(x+"*"+y+"=");
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		String user;
		user=in.readLine();
		
		int inputNum=new Integer(user).intValue();
		
		if(num==inputNum) 
		{
			System.out.println("o");
		}else {
			System.out.println("x"+"   "+"정답은"+num);
		}

	}
}
