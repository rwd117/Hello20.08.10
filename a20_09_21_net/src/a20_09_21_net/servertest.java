package a20_09_21_net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class servertest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ServerSocket ss=new ServerSocket(9000);
		Socket socket=ss.accept();
		
		 
		BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		PrintWriter output=new PrintWriter(socket.getOutputStream());
		
		String str=input.readLine();
		
		output.println("³ª´Ù");
		output.flush();
		
		socket.close();
		ss.close();
		
	}

}
