package sudo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackGround {
	
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	test2 gui;
	test3 gui2;
	String msg;
	private String nickName;
	
	public void setGui(test2 test2) {
		this.gui = test2;
	}

	public void connet() {
		try {
			socket = new Socket("127.0.0.1",7777);
			//������ ���� 
			out =new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF(nickName + "����"+"\n");
			//�������� �޽��� ������
			
			while(in!=null) {
				msg=in.readUTF();
				//�������� �°� ����
				gui2.appendMsg(msg);
				//Ŭ���̾�Ʈ gui��
				//�׷��� Ŭ���̾�Ʈ ���� ������ ���� ����
				//������� �װ� �ذ�
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
