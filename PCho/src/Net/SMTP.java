package Net;
import java.util.Properties;
import java.util.Random;


public class SMTP {

	// SMTP 서버 정보를 설정한다.
	public int SendCode(String Email) {
		String user = "SoothingScent56@gmail.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
		String password = ""; // 패스워드

		Random r = new Random();
		int Code = Math.abs(r.nextInt() % 8999) + 1000;

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));

			// 수신자메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(Email));

			// Subject
			message.setSubject("인증번호"); // 메일 제목을 입력

			// Text
			message.setText("인증번호 : " + Code); // 메일 내용을 입력

			// send the message
			Transport.send(message); //// 전송
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Code;
	}

	public void SendPassword(String Email, String PW) {
		String user = "SoothingScent56@gmail.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
		String password = ""; // 패스워드

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));

			// 수신자메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(Email));

			// Subject
			message.setSubject("비밀번호 안내 메일"); // 메일 제목을 입력

			// Text
			message.setText("회원님의 비밀번호는 [ " + PW +" ] 입니다."); // 메일 내용을 입력

			// send the message
			Transport.send(message); //// 전송
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
