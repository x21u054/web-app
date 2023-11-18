package bo;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entity.EmailVerify;
import entity.ForgetPassword;

public class SendEmail {
	public void execute(EmailVerify emailVerify) {
		final String username = "mail.campuscraft@gmail.com";
		final String password = "ybqm edqz plrh hmcp";
		String recipientEmail = emailVerify.getEmail(); // 送信先のメールアドレス

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		String baseUrl = "http://localhost:8080/test-4/confirm?token=";
		String url = baseUrl + emailVerify.getToken();

		System.out.println(url);

		String text = "ご利用ありがとうございます\r\n"
				+ "CampusCraftアカウント認証サービスです。\r\n"
				+ " \r\n"
				+ "本メールを受信した段階では、まだ登録は完了しておりません。\r\n"
				+ " \r\n"
				+ url
				+ "\r\n"
				+ " \r\n"
				+ "このURLはあなた専用のURLです。\r\n"
				+ "上記のURLをクリックし、アカウントの本登録を完了してください。\r\n"
				+ "送信から2時間が経過すると上記URLへはアクセスできなくなりますので、ご注意ください。\r\n"
				+ " \r\n"
				+ "※身に覚えのないメールの場合、本メールは無視・破棄してください。\r\n"
				+ "※本メールは送信専用のため、ご返事いただけません。\r\n"
				+ " \r\n"
				+ "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\r\n"
				+ "発行：CampusCraft運用管理システム\r\n"
				+ "このメールの再配信および掲載記事の無断転載は禁止しております。\r\n"
				+ "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username)); // 送信元のメールアドレスを設定
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // 送信先のメールアドレスを設定
			message.setSubject("メールアドレスの認証");
			message.setText(text);

			Transport.send(message);

			System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public void execute(ForgetPassword forgetPassword) {
		final String username = "mail.campuscraft@gmail.com";
		final String password = "ybqm edqz plrh hmcp";
		String recipientEmail = forgetPassword.getEmail(); // 送信先のメールアドレス

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		String baseUrl = "http://localhost:8080/test-4//forget-password-confirm?token=";
		String url = baseUrl + forgetPassword.getToken();

		System.out.println(url);

		String text = "ご利用ありがとうございます\r\n"
				+ "CampusCraftアカウント認証サービスです。\r\n"
				+ " \r\n"
				+ "本メールを受信した段階では、まだ再設定は完了しておりません。\r\n"
				+ " \r\n"
				+ url
				+ "\r\n"
				+ " \r\n"
				+ "このURLはあなた専用のURLです。\r\n"
				+ "上記のURLをクリックし、パスワードの再設定を完了してください。\r\n"
				+ "送信から2時間が経過すると上記URLへはアクセスできなくなりますので、ご注意ください。\r\n"
				+ " \r\n"
				+ "※身に覚えのないメールの場合、本メールは無視・破棄してください。\r\n"
				+ "※本メールは送信専用のため、ご返事いただけません。\r\n"
				+ " \r\n"
				+ "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\r\n"
				+ "発行：CampusCraft運用管理システム\r\n"
				+ "このメールの再配信および掲載記事の無断転載は禁止しております。\r\n"
				+ "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username)); // 送信元のメールアドレスを設定
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // 送信先のメールアドレスを設定
			message.setSubject("パスワードの再設定");
			message.setText(text);

			Transport.send(message);

			System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
