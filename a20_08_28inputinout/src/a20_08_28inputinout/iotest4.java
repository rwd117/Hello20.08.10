package a20_08_28inputinout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class iotest4 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String name=br.readLine();
		String id=br.readLine();
		String pwd=br.readLine();
		String age=br.readLine();
		String tell=br.readLine();
		
		System.out.println(name+"\t"+id+"\t"+pwd+"\t"+age+"\t"+tell);
		
		File file=new File("iotest4.txt");//按眉
		FileWriter output=new FileWriter(file, true);//颇老 积己
		output.write(name);
		output.write(id);
		output.write(pwd);
		output.write(age);
		output.write(tell);
		
		output.close();
	
	}

}
