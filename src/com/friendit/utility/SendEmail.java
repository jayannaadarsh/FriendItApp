package com.friendit.utility;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.friendit.vo.EmailObject;

@Component
public class SendEmail {

	public Session getEmailSession() {
		final String username = "adarsh.individual@gmail.com";
		final String password = "vspcsekdjbxdxwkf";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		return session;

	}

	public void sendKey(String toEmail) {
		Session session = getEmailSession();
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("adarsh.individual@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject("Confirm Registration");
			message.setText("<br/><br/>We are excited to tell you that your account is"
					+ " successfully created. Please click on the below link to verify your account"
					+ " <br/><br/><a href='http://localhost:8080/FriendItApp/" + toEmail + "'></a> ");// body
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public void sendNewPassword(EmailObject eo) {
		Session session = getEmailSession();

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("adarsh.individual@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(eo.getToEmail()));
			message.setSubject(eo.getSubject());
			message.setText(eo.getMessage());// body
			Transport.send(message);
		}
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
}
