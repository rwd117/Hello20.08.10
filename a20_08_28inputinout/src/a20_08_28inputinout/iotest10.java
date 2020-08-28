package a20_08_28inputinout;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class iotest10 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file=new File("iotext8.txt");
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ops=new ObjectInputStream(fis);
		System.out.println(ops.readObject());
		System.out.println(ops.readObject());
		System.out.println(ops.readObject());
		System.out.println(ops.readObject());
		ops.close();
	}

}
