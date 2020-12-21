package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerBackGround2 {

	private ServerSocket serversocket;
	private Socket socket;
	private ServerGUI gui;
	private String msg;
	private String nick;
	//사용자들 정보 저장
	private Map<String, DataOutputStream> clientMap = new HashMap<String, DataOutputStream>();

	public void setGUI(ServerGUI server) {
		this.gui = server;
	}

	public void setting() {
		try {

			Collections.synchronizedMap(clientMap);// 서로 엉키는것 대비, 정리해줌

			serversocket = new ServerSocket(7777);
			// 해당 포트 열었다
			while (true) {

				socket = serversocket.accept();
				// getInetAddress라는 곳에서 접속,1명만 받음.
				// while로 여러명을 받음
				
				Receiver receiver= new Receiver(socket);
				//쓰레드로 ㄱ
				receiver.start();
			}

			// 들어오는 클라이언트 관리,
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerBackGround2 serverbackground = new ServerBackGround2();
		serverbackground.setting();
	}
	
	private void addClient(String nick, DataOutputStream out2) {
		// TODO Auto-generated method stub
		sendMessage(nick + "가 접속");
		clientMap.put(nick, out2);
		
	}
	//해당하는 사람의 이름을 제거 즉 로그아웃
	public void removeClient(String nick) {
		sendMessage(nick + "가 로그아웃 ");
		clientMap.remove(nick);
	}

	public void sendMessage(String msg) {
		// TODO Auto-generated method stub
		
		Iterator<String> it = clientMap.keySet().iterator();
		
		//it이 닉네임에 해당하는 사람한테서버에서 말하는 역할
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
//			// 클라이언트 백그라운드로
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	class Receiver extends Thread {
		// 듣는 역할 다함
		DataInputStream in;
		DataOutputStream out;

		public Receiver(Socket socket) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				
				//이름 읽기, 후에 데이터베이스로
				nick=in.readUTF();
				addClient(nick, out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//닉네임을 받아서 해당하는 사람 생성
		

		public void run() {
			//귀만 열어두는 상태
			try {
					while (in != null) {
					msg = in.readUTF();
					sendMessage(msg);//메시지 보내버리기
					gui.appendMsg(msg); 
					//1인용일때 쓰던거 1:1
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//접속 종료시 에러가 남,그러므로 제거해줌
				removeClient(nick);
			}

			super.run();
		}
	}

}
