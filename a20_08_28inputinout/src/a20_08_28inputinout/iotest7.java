package a20_08_28inputinout;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class iotest7 {

	public static void main(String[] args) throws IOException {
		File file=new File("iotest7.txt");//°´Ã¼
		FileOutputStream fos=new FileOutputStream(file);
		DataOutputStream output=new DataOutputStream(fos);
		
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		int ko=sc.nextInt();
		int ma=sc.nextInt();
		int en=sc.nextInt();
		
		System.out.println(name+"\t"+ko+"\t"+ma+"\t"+en);
		
		output.writeUTF(name);
		output.writeInt(ko);
		output.writeInt(ma);
		output.writeInt(en);
		
		output.close();
	}

}
