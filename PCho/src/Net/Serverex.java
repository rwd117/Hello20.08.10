package Net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import java.util.Vector;

public class Serverex {
	Vector clientVector = new Vector();

	int clientNum = 0;
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.33:1521:xe";
	String user = "system";
	String password = "123456";
	String IDCheck = "select id from Test where id = ?";
	String FindID = "select id from Test where name = ? and Email =?";
	String LoginCheck = "select pw from Test where id = ?";
	String FindPW = "select pw from Test where name = ? and id = ? and Email = ?";
	String FindEmail = "select email from Test where email = ?";
	String Register = "insert into Test Values (TestCode_seq.nextval, ?, ?, ?, ?)";
	String AddItem = "insert into NikeShoe Values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String EmailCheck ="select email from Test where id = ?";
	String PWChange = "update Test set pw=? where id = ?";
	String EmailUpdate = "update Test set email=? where id = ?";
	PreparedStatement pstmtTotal, pstmtTotalScroll;

	Connection con = null;
	PreparedStatement pstmt = null;
	int count = 0;
	static int Code;

	public void dbconnect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Register(String Name, String ID, String PW, String Mail) {
		try {
			pstmt = con.prepareStatement(Register);
			pstmt.setString(1, Name);
			pstmt.setString(2, ID);
			pstmt.setString(3, PW);
			pstmt.setString(4, Mail);
			pstmt.executeUpdate();
			System.out.println("가입완료");
			// OK사인 보내기

		} catch (Exception e) {

		}

	}
	public void Update(String PW, String ID){
		try {
			pstmt = con.prepareStatement(PWChange);
			pstmt.setString(1, PW);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
		} catch (Exception e) {

		}
	}
	public void UpdateEmail(String Email, String ID){
		try {
			pstmt = con.prepareStatement(EmailUpdate);
			pstmt.setString(1, Email);
			pstmt.setString(2, ID);
			pstmt.executeUpdate();
		} catch (Exception e) {

		}
	}
	public String FindPW(String Name, String ID, String Email) {
		String res = "NOPW";
		String add = "";
		try {
			pstmt = con.prepareStatement(FindPW);
			pstmt.setString(1, Name);
			pstmt.setString(2, ID);
			pstmt.setString(3, Email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String PW = rs.getString(1);
				if (PW.equals(null) || PW.equals("")) {
					res = "NOPW";
				} else if (!PW.equals(null) || !PW.equals("")) {
					add = Email + "|" + PW;
					res = add;
				}
			}
		} catch (Exception e) {

		}
		return res;
	}

	public int Email(String Mail) {
		int Emailres = 10;
		try {
			pstmt = con.prepareStatement(FindEmail);
			pstmt.setString(1, Mail);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String ResultEmail = rs.getString(1);
				if (ResultEmail.equals(null) || ResultEmail.equals("")) {
					Emailres = 10;
				} else if (!ResultEmail.equals(null) || !ResultEmail.equals("")) {
					Emailres = 11;
				}
			}
		} catch (Exception e) {

		}
		return Emailres;
	}

	public void AddShoe(String Add) {
		StringTokenizer st = new StringTokenizer(Add, ",");
		try {
			pstmt = con.prepareStatement(AddItem);
			pstmt.setInt(1, Integer.parseInt(st.nextToken()));
			pstmt.setString(2, st.nextToken());
			pstmt.setString(3, st.nextToken());
			pstmt.setString(4, st.nextToken());
			pstmt.setString(5, st.nextToken());
			pstmt.setInt(6, Integer.parseInt(st.nextToken()));
			pstmt.setInt(7, Integer.parseInt(st.nextToken()));
			pstmt.setInt(8, Integer.parseInt(st.nextToken()));
			pstmt.setInt(9, Integer.parseInt(st.nextToken()));
			pstmt.setInt(10, Integer.parseInt(st.nextToken()));
			pstmt.setInt(11, Integer.parseInt(st.nextToken()));
			pstmt.setInt(12, Integer.parseInt(st.nextToken()));
			pstmt.setInt(13, Integer.parseInt(st.nextToken()));
			pstmt.setInt(14, Integer.parseInt(st.nextToken()));
			pstmt.setInt(15, Integer.parseInt(st.nextToken()));
			pstmt.setInt(16, Integer.parseInt(st.nextToken()));
			pstmt.setInt(17, Integer.parseInt(st.nextToken()));
			pstmt.setInt(18, Integer.parseInt(st.nextToken()));
			pstmt.setInt(19, Integer.parseInt(st.nextToken()));
			pstmt.setInt(20, Integer.parseInt(st.nextToken()));
			pstmt.setInt(21, Integer.parseInt(st.nextToken()));
			pstmt.setInt(22, Integer.parseInt(st.nextToken()));
			pstmt.setInt(23, Integer.parseInt(st.nextToken()));
			pstmt.setInt(24, Integer.parseInt(st.nextToken()));
			pstmt.setInt(25, Integer.parseInt(st.nextToken()));
			pstmt.setInt(26, Integer.parseInt(st.nextToken()));
			pstmt.setInt(27, Integer.parseInt(st.nextToken()));
			pstmt.setInt(28, Integer.parseInt(st.nextToken()));
			pstmt.executeUpdate();
		} catch (Exception e) {

		}

	}

	public int IDCheck(String ID) {
		int IDCheckRes = 0;
		try {
			pstmt = con.prepareStatement(IDCheck);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String ResultID = rs.getString(1);
				if (ResultID.equals(null) || ResultID.equals("")) {
					IDCheckRes = 0;
				} else if (!ResultID.equals(null) || !ResultID.equals("")) {
					IDCheckRes = 1;
				}
			}
		} catch (Exception e) {

		}
		return IDCheckRes;
	}

	public String Login(String ID, String PW) {
		String res = null;
		try {
			pstmt = con.prepareStatement(LoginCheck);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			count = 0;
			while (rs.next()) {
				count = 1;
				String Password = rs.getString(1);
				if (!Password.equals(PW)) {
					res = "비밀번호 에러";
				} else if (Password.equals(PW)) {
					res = password;
				}
			}

		} catch (Exception e) {

		}
		if (count == 0) {
			res = "아이디 에러";
		}
		return res;
	}
	public String PWCheck(String ID, String PW) {
		String res = null;
		try {
			pstmt = con.prepareStatement(LoginCheck);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String Password = rs.getString(1);
				if (!Password.equals(PW)) {
					res = "비밀번호 틀림";
				} else if (Password.equals(PW)) {
					res = "올바른 비밀번호";
				}
			}
		} catch (Exception e) {
		}
		return res;
	}
	public String EmailCheck(String ID, String TakenEmail) {
		String res = null;
		try {
			pstmt = con.prepareStatement(EmailCheck);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String Email = rs.getString(1);
				if (!Email.equals(TakenEmail)) {
					res = "이메일 틀림";
				} else if (Email.equals(TakenEmail)) {
					res = "올바른 이메일";
				}
			}
		} catch (Exception e) {
		}
		return res;
	}
	public String FindID(String Name, String Email) {
		String res = "NOID";
		try {
			pstmt = con.prepareStatement(FindID);
			pstmt.setString(1, Name);
			pstmt.setString(2, Email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String ID = rs.getString(1);
				if (ID.equals(null) || ID.equals("")) {
					res = "NOID";
				} else if (!ID.equals(null) || !ID.equals("")) {
					res = ID;
				}
			}

		} catch (Exception e) {

		}
		return res;
	}

	public void broadcast(String msg) throws IOException {
		synchronized (clientVector) {
			for (int i = 0; i < clientVector.size(); i++) {
				ServerexThread client = (ServerexThread) clientVector.elementAt(i);
				synchronized (client) {
					client.sendMessage(msg);
				}
			}
		}
	}

	/*
	 * public void onecast(String msg) throws IOException { client.sendMessage(msg);
	 * }
	 */
	public void removeClient(ServerexThread client) {
		synchronized (clientVector) {
			clientVector.removeElement(client);
			client = null;
			System.gc();
		}
	}

	public void addClient(ServerexThread client) {
		synchronized (clientVector) {
			clientVector.addElement(client);
		}
	}

	public static void main(String[] args) {
		ServerSocket myServerSocket = null;
		Serverex myServer = new Serverex();
		myServer.dbconnect();
		try {
			myServerSocket = new ServerSocket(2587);
		} catch (IOException e) {
			System.out.println(e.toString());
			System.exit(-1);
		}
		System.out.println("서버 가동 중");
		try {
			while (true) {
				ServerexThread client = new ServerexThread(myServer, myServerSocket.accept());
				client.start();
				myServer.addClient(client);
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}