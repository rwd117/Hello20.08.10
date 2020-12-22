package Net;

import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Vector;

import Db.PCSeatDb;
import Db.UserDb;


public class Server {
	
	Vector clientVector=new Vector();
	int clientNum=0;
	
	//���⿡ db�� �����ؼ� ������ db�� �����Ѵ�.		
	public void broadcast(String msg) throws IOException
	{
		synchronized(clientVector){
			for(int i=0;i<clientVector.size();i++) {
				ServerThread client=(ServerThread) clientVector.elementAt(i);//������ �ִ� ��� �������.
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
			System.gc();//�迭�� ���� ������.
		}
	} 
	
	public void addClinet(ServerThread client) {
		synchronized(clientVector) {
			clientVector.addElement(client);
		}
	}
	
	public String UserTimeServerDb(String ID) {
		String Time = UserDb.UserTimeCheck(ID);
		System.out.println("����� ��� : "+Time);
		return Time;
	}
	
	public ArrayList<Integer> SeatCheckDb(){
		ArrayList<Integer> Seat=new ArrayList<Integer>();
		ArrayList<Integer> SeatCheck=new ArrayList<Integer>();
		
		Seat=PCSeatDb.PCSeatAll();
		SeatCheck=PCSeatDb.PCSeatCheck(Seat);
		
		return SeatCheck;
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
		
		System.out.println("[���� ��� ����]"+myServerSocket);
		
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
