package Net;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Vector;


public class Server {
	Vector clientVector=new Vector();
	int clientNum=0;
	//여기에 db를 연결해서 서버가 db를 관리한다.		
	public void broadcast(String msg) throws IOException
	{
		synchronized(clientVector){
			for(int i=0;i<clientVector.size();i++) {
				ServerThread client=(ServerThread) clientVector.elementAt(i);//접속해 있는 모든 사람한테.
				synchronized(client) {
					client.sendMessage(msg);
				}
			}
		}
	}
	
	public void removeClient(ServerThread client) {
		synchronized(clientVector) {
			clientVector.removeElement(client);
			client=null;
			System.gc();//배열의 공간 재정렬.
		}
	} 
	
	public void addClinet(ServerThread client) {
		synchronized(clientVector) {
			clientVector.addElement(client);
		}
	}
	
	public static void main(String[] args) {
		ServerSocket myServerSocket=null;
		Server myServer=new Server();
		
		try{
			myServerSocket=new ServerSocket(2587);
		}catch(IOException e) {
			System.out.println(e.toString());
			System.exit(-1);
		}
		
		System.out.println("[서버 대기 상태]"+myServerSocket);
		
		try {
			while(true) {
				ServerThread client=new ServerThread(myServer,myServerSocket.accept());
				client.start();
				myServer.addClinet(client);
				
			}
		}catch(IOException e) {
			System.out.println(e.toString());
		}
		
		
		
	}

}
