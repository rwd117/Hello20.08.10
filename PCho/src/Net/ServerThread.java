package Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import Db.UserDb;
import User.PCuser;

public class ServerThread extends Thread {
	Server myServer;
	Socket mySocket;

	PrintWriter out;
	BufferedReader in;

	// gui가 해당하는 command를 보내면 여기서 그 command를 잘라내서 하나하나 구분해서 서버에 보내서 서버가 처리 후 여기서
	// 읽어내서 그것을 표현해낸다

	public ServerThread() {
		super("ChatThread");
	}

	public ServerThread(Server server, Socket socket) {
		super("ChatThread");

		myServer = server;
		mySocket = socket;

		out = null;
		in = null;
	}

	public void sendMessage(String msg) throws IOException {
		out.println(msg);
		out.flush();
	}

	public void disconnect() {
		try {
			out.flush();
			in.close();
			out.close();
			mySocket.close();
			myServer.removeClient(this);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public void run() {
		try {
			out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream(), "KSC5601"), true);
			in = new BufferedReader(new InputStreamReader(mySocket.getInputStream(), "KSC5601"), 1024);

			while (true) {
				String inLine = in.readLine();
				if (!inLine.equals("") && !inLine.equals(null)) {
					messageProcess(inLine);
				}
			}
		} catch (Exception e) {
			disconnect();
		}

	}

	public void messageProcess(String msg) {
		System.out.println(msg);

		StringTokenizer st = new StringTokenizer(msg, "|");
		String command = st.nextToken();
		String Next = st.nextToken();

		if (command.equals("LOGIN")) {
			StringTokenizer st2 = new StringTokenizer(Next);
			String ID = st2.nextToken();

			out.println(myServer.UserTimeServerDb(ID));
			System.out.println("여기는 서버 쓰레드 : " + myServer.UserTimeServerDb(ID));
			out.flush();

		} else if (command.equals("LOGOUT")) {

			disconnect();
		} else if (command.equals("INSERTTIME")) {
			StringTokenizer st2 = new StringTokenizer(Next,",");
			String AllTime = st2.nextToken();//읽어온 모든시간
			String ID = st2.nextToken();
			String UserState=UserDb.UserLoginCheck(ID);//유저가 현재 로그인이냐 아니냐
			
			if(UserState.equals("로그인")) {
				String ReadId = myServer.UserTimeServerDb(ID);
				
				
				out.flush();
				
			}else if(UserState.equals("로그아웃")) {
				//보낼 이유가 없음.
			}
		}
	}
}
