import java.io.*;
public class hmain {

	public static void main(String[] args) throws IOException
	{
		hangman hangman=new hangman();
		
		int result=hangman.playGame();
		System.out.println();
		if(result<=2) {System.out.println("��");}
		else if(result<=3) {System.out.println("����");}
		else if(result<=4) {System.out.println("����");}
		else {System.out.println("�̰� ��");}
	}

}
