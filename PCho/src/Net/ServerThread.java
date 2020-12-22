package Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Db.PCSeatDb;
import Db.UserDb;
import User.PCuser;

public class ServerThread extends Thread {
	Server myServer;
	Socket mySocket;

	PrintWriter out;
	BufferedReader in;

	// gui�� �ش��ϴ� command�� ������ ���⼭ �� command�� �߶󳻼� �ϳ��ϳ� �����ؼ� ������ ������ ������ ó�� �� ���⼭
	// �о�� �װ��� ǥ���س���

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
			System.out.println("����� ���� ������ : " + myServer.UserTimeServerDb(ID));
			out.flush();

		} else if (command.equals("LOGOUT")) {
			disconnect();
		} else if (command.equals("Seat")) {
			StringTokenizer st2 = new StringTokenizer(Next);
			String Seat = st2.nextToken();
			System.out.println(Seat);
//			ArrayList<Integer> Seat=new ArrayList<Integer>();
			ArrayList<Integer> SeatCheck=new ArrayList<Integer>();
			
			SeatCheck = myServer.SeatCheckDb();
			out.println(SeatCheck);
			out.flush();
		}
	}
}
