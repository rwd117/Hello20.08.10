package hman2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class hman2 extends hman
{
	String[] words= {"influenza",
					"fever",
					"cancer",
					"poison",
					"physician",
					"clinic","sympton","medicine","drug","hygiene"};
	String[] meaning = {"독감","열","암","독","환자","내과의사","진료소","징후","의학",
						"약","위생학"};

 public hman2() throws IOException
 {
	 Random r= new Random();
	 int randomNum=Math.abs(r.nextInt()%words.length);
	 
	 hiddenString= words[randomNum];
	 
	 System.out.println("\n 의미"+meaning[randomNum]);
 }
 public char readChar() throws IOException
 {
	 BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
	 String user;
	 
	 do {
		 System.out.println("1 문자를 입력하세요. 힌트를 원하면 ? 입력");
		 user=in.readLine();
		 
		 if(user.charAt(0)=='?') 
		 {
			 boolean givehint=false;
			 int i=0;
			 while(!givehint) 
			 {
				 if(outputString.charAt(i)=='-')
				 {
					 System.out.println();
					 System.out.println("힌트->"+hiddenString.charAt(i));
					 System.out.println();
					 failed++;
					 givehint=true;
				 }
				 i++;
			 }
		 }
	 }while(user.charAt(0)=='?');
	 return user.charAt(0);
 }
}
