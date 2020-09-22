package a20_09_22_chattest;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;

public class ChatServer {
	Vector clientVector=new Vector();
	int clientNum=0;
			
	public void broadcast(String msg) throws IOException
	{
		synchronized(clientVector){
			for(int i=0;i<clientVector.size();i++) {
				ChatThread client=(ChatThread) clientVector.elementAt(i);//������ �ִ� ��� �������.
				synchronized(client) {
					client.sendMessage(msg);
				}
			}
		}
	}
	
	public void removeClient(ChatThread client) {
		synchronized(clientVector) {
			clientVector.removeElement(client);
			client=null;
			System.gc();//�迭�� ���� ������.
		}
	} 
	
	public void addClinet(ChatThread client) {
		synchronized(clientVector) {
			clientVector.addElement(client);
		}
	}
	
	public static void main(String[] args) {
		ServerSocket myServerSocket=null;
		ChatServer myServer=new ChatServer();
		
		try{
			myServerSocket=new ServerSocket(2587);
		}catch(IOException e) {
			System.out.println(e.toString());
			System.exit(-1);
		}
		
		System.out.println("[���� ��� ����]"+myServerSocket);
		
		try {
			while(true) {
				ChatThread client=new ChatThread(myServer,myServerSocket.accept());
				client.start();
				myServer.addClinet(client);
				
				myServer.clientNum++;
				System.out.println("[���� ������ ��]"+myServer.clientNum+"��");
			}
		}catch(IOException e) {
			System.out.println(e.toString());
		}
		
		
		
		
		
	}

}
