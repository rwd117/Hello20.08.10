package a20_08_28inputinout;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class iotest5 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("�̸�");
		String name=sc.next();
		System.out.println("����");
		String tell=sc.next();
		System.out.println("�ּ�");
		String  ju=sc.next();
		
		System.out.println(name+"\t"+tell+"\t"+ju);
		
		
		File file=new File("iotest5.txt");//��ü
		FileWriter output=new FileWriter(file, true);//���� ����
		output.write(name);
		output.write(ju);
		output.write(tell);
		
		output.close();
	}
}
