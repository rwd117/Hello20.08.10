package Net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Chat.ClientBackGround2;
import Chat.ClientGUI;
import User.TimeUserLogin;

public class ClientBackGround {
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private TimeUserLogin gui;

	private String Number;
	private String Name;
	private String nickName;
	private String PWD;
	private String msg;

	private ClientBackGround Client = new ClientBackGround();

	public void setGui(TimeUserLogin gui) {
		this.gui = gui;
	}

	public void setCheckUser(String id, String pwd) {
		// TODO Auto-generated method stub
		this.nickName = id;
		this.PWD = pwd;

	}

	public void setCheckNoUser(String num, String name) {
		// TODO Auto-generated method stub
		this.Number = num;
		this.Name = name;

	}

	public void Userconnet() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			// 서버와 연결
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			out.writeUTF(nickName + "접속" + "\n");
			// 서버에게 메시지 보내기,
			// 이 sql문이 들어간 것이 맞습니까? 하고 보냄

			while (in != null) {
				msg = in.readUTF();
				// 서버에서 온거 읽음
				gui.appendMsg(Client, msg);
				// 클라이언트 gui로
				// 그런데 클라이언트 에서 서버로 말을 못검
				// 쓰레드로 그걸 해결
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void NoUserconnet() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			// 서버와 연결
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			out.writeUTF(Number + "접속" + "\n");
			// 서버에게 메시지 보내기,
			// 이 sql문이 들어갑니다~ 하고 들어감

			while (in != null) {
				msg = in.readUTF();
				// 서버에서 온거 읽음
				gui.appendMsg(Client, msg);
				// 클라이언트 gui로
				// 그런데 클라이언트 에서 서버로 말을 못검
				// 쓰레드로 그걸 해결
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(String msg2) {
		// TODO Auto-generated method stub
		try {
			out.writeUTF(msg2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
