package Net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Chat.ServerBackGround2;
import Chat.ServerGUI;
import User.UserLogin;

public class PCServerBackGround {
	
	private ServerSocket serversocket;
	private Socket socket;
	private String msg;
	private String nick;
	private UserLogin gui;
	private PCServerBackGround PCServer = new PCServerBackGround(); 
	
	private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();

	public void setGUI(UserLogin server) {
		this.gui = server;
	}

	public void setting() {
		try {

			Collections.synchronizedMap(clientMap);// ���� ��Ű�°� ���, ��������

			serversocket = new ServerSocket(7777);
			// �ش� ��Ʈ ������
			while (true) {

				socket = serversocket.accept();
				// getInetAddress��� ������ ����,1�� ����.
				// while�� �������� ����
				
				Receiver receiver= new Receiver(socket);
				//������� ��
				receiver.start();
			}

			// ������ Ŭ���̾�Ʈ ����,
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PCServerBackGround serverbackground = new PCServerBackGround();
		serverbackground.setting();
	}
	
	private void addClient(String nick, DataOutputStream out2) {
		// TODO Auto-generated method stub
		sendMessage(nick + "�� ����");
		clientMap.put(nick, out2);
		
	}
	//�ش��ϴ� ����� �̸��� ���� �� �α׾ƿ�
	public void removeClient(String nick) {
		sendMessage(nick + "�� �α׾ƿ� ");
		clientMap.remove(nick);
	}

	public void sendMessage(String msg) {
		// TODO Auto-generated method stub
		//sql���� üũ���ִ°�
		
		Iterator<String> it = clientMap.keySet().iterator();
		
		//it�� �г��ӿ� �ش��ϴ� ������� �������� ���ϴ� ����
		String key="";
		
		while(it.hasNext()) {
			try {
				key=it.next();
				clientMap.get(key).writeUTF(msg);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		
//		try {
//			
//			out.writeUTF(msg);
//			// Ŭ���̾�Ʈ ��׶����
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	class Receiver extends Thread {
		// ��� ���� ����
		DataInputStream in;
		DataOutputStream out;

		public Receiver(Socket socket) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				
				//�̸� �б�, �Ŀ� �����ͺ��̽���
				nick=in.readUTF();
				addClient(nick, out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//�г����� �޾Ƽ� �ش��ϴ� ��� ����
		

		public void run() {
			//�͸� ����δ� ����
			try {
					while (in != null) {
					msg = in.readUTF();
					sendMessage(msg);//�޽��� ����������
					gui.appendCheck(PCServer,msg); 
					//1�ο��϶� ������ 1:1
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//���� ����� ������ ��,�׷��Ƿ� ��������
				removeClient(nick);
			}

			super.run();
		}
	}

}
