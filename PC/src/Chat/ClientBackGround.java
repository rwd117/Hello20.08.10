package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackGround {
	
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	ClientGUI gui;
	String msg;
	private String nickName;
	
	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}

	public void connet() {
		try {
			socket = new Socket("127.0.0.1",7777);
			//서버와 연결 
			out =new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF(nickName + "접속"+"\n");
			//서버에게 메시지 보내기
			
			while(in!=null) {
				msg=in.readUTF();
				//서버에서 온거 읽음
				gui.appendMsg(msg);
				//클라이언트 gui로
				//그런데 클라이언트 에서 서버로 말을 못검
				//쓰레드로 그걸 해결
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientBackGround clientbackground=new ClientBackGround();
		clientbackground.connet();
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

	public void setNickname(String nickname) {
		// TODO Auto-generated method stub
		this.nickName=nickname;
	}

}
