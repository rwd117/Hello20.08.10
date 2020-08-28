package a20_08_28inputinout;


import java.io.FileOutputStream;
import java.io.IOException;

public class iotest {

	public static void main(String[]args) throws Exception {
		FileOutputStream fos=new FileOutputStream("sample.txt");
		
		for(int i='A';i<='Z';i++) {
			fos.write(i);
		}
		fos.close();
		
		
	}
}
