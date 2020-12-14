package State;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PCserver {
	private ServerSocket serversocket;
	private Socket socket;
	private Seat gui;
	
	public void setGui(Seat gui) {
		this.gui = gui;
	}

	public void setting() {
		try {
			serversocket = new ServerSocket(7777);
			socket = serversocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	class Receiver extends Thread {
		
	}
	
}
