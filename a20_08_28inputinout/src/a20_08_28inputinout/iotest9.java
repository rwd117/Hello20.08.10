package a20_08_28inputinout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class iotest9 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file=new File("iotext8.txt");
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		int ko=sc.nextInt();
		int ma=sc.nextInt();
		int en=sc.nextInt();
		
		oos.writeObject(name);
		oos.writeObject(ko);
		oos.writeObject(ma);
		oos.writeObject(en);
		oos.close();
		
		
	}

}
