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
			// ������ ����
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			out.writeUTF(nickName + "����" + "\n");
			// �������� �޽��� ������,
			// �� sql���� �� ���� �½��ϱ�? �ϰ� ����

			while (in != null) {
				msg = in.readUTF();
				// �������� �°� ����
				gui.appendMsg(Client, msg);
				// Ŭ���̾�Ʈ gui��
				// �׷��� Ŭ���̾�Ʈ ���� ������ ���� ����
				// ������� �װ� �ذ�
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void NoUserconnet() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			// ������ ����
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			out.writeUTF(Number + "����" + "\n");
			// �������� �޽��� ������,
			// �� sql���� ���ϴ�~ �ϰ� ��

			while (in != null) {
				msg = in.readUTF();
				// �������� �°� ����
				gui.appendMsg(Client, msg);
				// Ŭ���̾�Ʈ gui��
				// �׷��� Ŭ���̾�Ʈ ���� ������ ���� ����
				// ������� �װ� �ذ�
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
