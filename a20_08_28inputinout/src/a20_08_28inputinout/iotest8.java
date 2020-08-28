package a20_08_28inputinout;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class iotest8 {

	public static void main(String[] args) throws Exception {
		File file=new File("iotest7.txt");
		FileInputStream fis=new FileInputStream(file);
		DataInputStream input=new DataInputStream(fis);
		
		String name=input.readUTF();
		int ko=input.readInt();
		int ma=input.readInt();
		int en=input.readInt();
		int tot=ko+ma+en;
		System.out.println(name+"\t"+tot);
		
		
	}

}
