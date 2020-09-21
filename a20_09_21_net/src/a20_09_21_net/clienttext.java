package a20_09_21_net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clienttext {
 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Socket socket =new Socket("192.168.0.6",9000);
		
		BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		PrintWriter output=new PrintWriter(socket.getOutputStream());
		
		output.println("¤¾¤·");
		output.flush();
		
		String str=input.readLine();
		System.out.println(str);

	}

}
