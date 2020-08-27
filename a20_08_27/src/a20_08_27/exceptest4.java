package a20_08_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class exceptest4 {

	public static void main(String[] args) throws IOException {
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
		String name=br.readLine();
		System.out.println("너의 이름은"+name);
		
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		System.out.println(str);
	}
}
