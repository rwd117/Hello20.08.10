package hman2;

import java.io.IOException;

public class hman2test
{
	public static void main(String[] args)throws IOException
	{
		hman2 hangman=new hman2();
		
		int result=hangman.playGame();
		
		System.out.println();
		if(result<=2) {System.out.println("국");}
		else if(result<=3) {System.out.println("굿");}
		else if(result<=4) {System.out.println("보통");}
		else {System.out.println("분발");}
	}
}
