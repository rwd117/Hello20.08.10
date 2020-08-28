package a20_08_28inputinout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class iotest5 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("捞抚");
		String name=sc.next();
		System.out.println("傈锅");
		String tell=sc.next();
		System.out.println("林家");
		String  ju=sc.next();
		
		System.out.println(name+"\t"+tell+"\t"+ju);
		
		
		File file=new File("iotest5.txt");//按眉
		FileWriter output=new FileWriter(file, true);//颇老 积己
		output.write(name);
		output.write(ju);
		output.write(tell);
		
		output.close();
	}
}
