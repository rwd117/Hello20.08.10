package java_실습_Kimjw;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class test30 
{
	public static int playGame() throws IOException
	{
		int x,y,z;
		Random r=new Random();
		x=Math.abs(r.nextInt()%9)+1;
		
		do 
		{
			y=Math.abs(r.nextInt()%9)+1;
		}while(y==x);
		do {
			z=Math.abs(r.nextInt()%9)+1;
		}while((z==x)||(z==y));
		
		System.out.println(x+","+y+","+z);
		
		return playGame(x,y,z);
	}
	
	public static int playGame(int x, int y, int z) throws IOException
	{
		int count;
		int strike, ball;
		
		int[] usr=new int[3];
		int[] com= {x,y,z};
		
		System.out.println("숫자 야구 시작");
		
		count=0;
		
		do 
		{
			count++;
			do
			{
				System.out.println("카운트 :"+count);
				BufferedReader in=new BufferedReader
						(new InputStreamReader(System.in));
				
				String user;
			
				System.out.println("1번째 숫자");
				user=in.readLine();
				usr[0]=new Integer(user).intValue();
			
				System.out.println("2번째	 숫자");
				user=in.readLine();
				usr[1]=new Integer(user).intValue();
			
				System.out.println("3번째 숫자");
				user=in.readLine();
				usr[2]=new Integer(user).intValue();
			
				if((usr[0]==0)||(usr[1]==0)||(usr[2]==0)) 
				{
					System.out.println("0입력 불가. 다시 입력");
				}else if((usr[0]>9)||(usr[1]>9)||(usr[2]>9))
				{
					System.out.println("1~9사이의 숫자 입력. 다시 입력");
				}else if((usr[0]==usr[1])||(usr[1]==usr[2])||(usr[0]==usr[2]))
				{
					System.out.println("서로 다른 숫자 입력. 다시 입력");
				}
			}while((usr[0]==0)||(usr[1]==0)||(usr[2]==0)||
					(usr[0]>9)||(usr[1]>9)||(usr[2]>9)||
					(usr[0]==usr[1])||(usr[1]==usr[2])||(usr[0]==usr[2]));
		
		
		strike = ball = 0;
		
		if(usr[0]==com[0]) strike++;
		if(usr[1]==com[1]) strike++;
		if(usr[2]==com[2]) strike++;
		
		if(usr[0]==com[1]) ball++;
		if(usr[0]==com[2]) ball++;
		if(usr[1]==com[0]) ball++;
		if(usr[1]==com[2]) ball++;
		if(usr[2]==com[0]) ball++;
		if(usr[2]==com[1]) ball++;
		
		System.out.println("스트라이크:"+strike+"볼:"+ball);
		
		}while((strike<3)&&(count<11));
		return count;
	}
	public static void main(String[] args) throws IOException 
	{
		int result;
		
		if(args.length==3) 
		{
			int x=Integer.valueOf(args[0]).intValue();
			int y=Integer.valueOf(args[1]).intValue();
			int z=Integer.valueOf(args[2]).intValue();
			
			result=playGame(x,y,z);
		}else 
		{
			result=playGame();
		}
		
		System.out.println();
		
		if(result<=2) 
		{
			System.out.println("굿");
		}else if(result<=5) 
		{
			System.out.println("이열");
		}else if(result<=9) 
		{
			System.out.println("보통");
		}else 
		{
			System.out.println("분발");
		}
		
	}

}
