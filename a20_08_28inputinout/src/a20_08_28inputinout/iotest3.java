package a20_08_28inputinout;

import java.io.File;

public class iotest3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file=new File("sample.txt");
		if(file.exists()) {
			System.out.println(file.getPath());
			System.out.println(file.isFile());
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length());
			System.out.println(file.lastModified());
			
		}
		else {
			file.createNewFile();
		System.out.println("?");}
	}

}
