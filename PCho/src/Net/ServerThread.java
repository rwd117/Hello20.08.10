package Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.StringTokenizer;



public class ServerThread extends Thread {
	Server myServer;
	Socket mySocket;
	SMTP mySMTP;

	PrintWriter out;
	BufferedReader in;

	public ServerThread() {
		super("ServerThread");
	}

	public ServerThread(Server server, Socket socket) {
		super("ServerThread");

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
			in = new BufferedReader(new InputStreamReader(mySocket.getInputStream(), "KSC5601"), 2587);

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
		StringTokenizer st = new StringTokenizer(msg, "|");
		String command = st.nextToken();
		String Next = st.nextToken();

		if (command.equals(null)) {
		} else if (command.equals("LOGIN")) {
			StringTokenizer st2 = new StringTokenizer(Next, ",");
			String ID = st2.nextToken();
			String PW = st2.nextToken();
			out.println(myServer.Login(ID, PW));
			out.flush();
			/*
			 * try { } catch (IOException e) { System.out.println(e.toString()); }
			 */

		} else if (command.equals("IDCheck")) {
			int re = (myServer.IDCheck(Next));
			out.println(re);
			out.flush();

		} else if (command.equals("CodeCheck")) {
			int re = (myServer.Email(Next));
			out.println(re);
			out.flush();

		} else if (command.equals("SendCode")) {
			mySMTP = new SMTP();
			int re = (mySMTP.SendCode(Next));
			out.println(re);
			out.flush();

		} else if (command.equals("Register")) {
			StringTokenizer st2 = new StringTokenizer(Next, ",");
			String Name = st2.nextToken();
			String ID = st2.nextToken();
			String PW = st2.nextToken();
			String Email = st2.nextToken();
			myServer.Register(Name, ID, PW, Email);
		} else if (command.equals("FindID")) {
			String back="";
			StringTokenizer st2 = new StringTokenizer(Next, ",");
			String Name = st2.nextToken();
			String Email = st2.nextToken();
			String res = (myServer.FindID(Name,Email));
			if(res.equals("NOID")||res.equals("NOID")) {
				back = "NOID";
			}else {
				back = res;
			}
			out.println(back);
			out.flush();
		} else if (command.equals("FindPW")) {
			int res = 0;
			System.out.println(Next);
			StringTokenizer st2 = new StringTokenizer(Next, ",");
			String Name = st2.nextToken();
			String ID = st2.nextToken();
			String Email = st2.nextToken();
			String A = (myServer.FindPW(Name,ID,Email));
			if(A.equals("NOPW")) {
				res=1;
			}else {
				res=0;
			}
			out.println(res);
			out.flush();
			if(res==0) {
				StringTokenizer st3 = new StringTokenizer(A, "|");
				String Address = st3.nextToken();
				String Password = st3.nextToken();
				mySMTP = new SMTP();
				mySMTP.SendPassword(Address,Password);
			}
		} else if (command.equals("Add")) {
			myServer.AddShoe(Next);			
		} else if (command.equals("PWCheck")) {
			StringTokenizer st2 = new StringTokenizer(Next, ",");
			String ID = st2.nextToken();
			String Password = st2.nextToken();
			String A = myServer.PWCheck(ID, Password);
			out.println(A);
			out.flush();
		} else if (command.equals("EmailCheck")) {
			StringTokenizer st2 = new StringTokenizer(Next, ",");
			String ID = st2.nextToken();
			String Email = st2.nextToken();
			String A = myServer.EmailCheck(ID, Email);
			out.println(A);
			out.flush();
		} else if (command.equals("PWChange")) {
			StringTokenizer st2 = new StringTokenizer(Next, ",");
			String PW = st2.nextToken();
			String ID = st2.nextToken();
			myServer.Update(PW, ID);
		}else if (command.equals("EmailChange")) {
			StringTokenizer st2 = new StringTokenizer(Next, ",");
			String Email = st2.nextToken();
			String ID = st2.nextToken();
			myServer.UpdateEmail(Email, ID);
		}else {
			
		}
		
	}
}
