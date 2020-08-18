import java.io.*;
public class hmain {

	public static void main(String[] args) throws IOException
	{
		hangman hangman=new hangman();
		
		int result=hangman.playGame();
		System.out.println();
		if(result<=2) {System.out.println("국");}
		else if(result<=3) {System.out.println("구웃");}
		else if(result<=4) {System.out.println("보통");}
		else {System.out.println("이건 좀");}
	}

}
