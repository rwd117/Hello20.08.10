package Net;
import java.util.Properties;
import java.util.Random;


public class SMTP {

	// SMTP ���� ������ �����Ѵ�.
	public int SendCode(String Email) {
		String user = "SoothingScent56@gmail.com"; // ���̹��� ��� ���̹� ����, gmail��� gmail ����
		String password = ""; // �н�����

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

			// �����ڸ����ּ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(Email));

			// Subject
			message.setSubject("������ȣ"); // ���� ������ �Է�

			// Text
			message.setText("������ȣ : " + Code); // ���� ������ �Է�

			// send the message
			Transport.send(message); //// ����
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
		String user = "SoothingScent56@gmail.com"; // ���̹��� ��� ���̹� ����, gmail��� gmail ����
		String password = ""; // �н�����

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

			// �����ڸ����ּ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(Email));

			// Subject
			message.setSubject("��й�ȣ �ȳ� ����"); // ���� ������ �Է�

			// Text
			message.setText("ȸ������ ��й�ȣ�� [ " + PW +" ] �Դϴ�."); // ���� ������ �Է�

			// send the message
			Transport.send(message); //// ����
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
