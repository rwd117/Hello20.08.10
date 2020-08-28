package a20_08_28inputinout;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class bytetest {

	public static void main(String[]args) throws IOException {
		int data;
		while((data=System.in.read())!=-1) {
		System.out.println((char)data);
		InputStream input=System.in;
		OutputStream output=System.out;
		
		while((data=input.read())!=-1) {
			output.write((char)data);
		}
		
		}
	}
}
