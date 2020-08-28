package a20_08_28inputinout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
	
public class iotest2 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("one.txt");
		int data;
		while((data=fis.read())!=-1) {
			
		System.out.println((char) data);
		}
		fis.close();
		}
	
}	
