package a20_08_28inputinout;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class iotest6 {
	public static void main(String[]args) throws IOException {
		File file=new File("iotest4.txt");
		FileReader input=new FileReader(file);
		int data;
		while((data=input.read())!=-1) {
			System.out.println((char)data);
		}
	}
}
