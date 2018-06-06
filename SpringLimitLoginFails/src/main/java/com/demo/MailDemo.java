package com.demo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailDemo {

	public static void main(String[] args) throws AddressException, MessagingException {
        
//		  Properties props = new Properties();
//	      props.put("mail.smtp.host", "192.168.1.214");
//	      props.put("mail.smtp.port", "25");
//	      props.put("mail.debug", "true");
		  	Properties props = System.getProperties();
	        props.put("mail.smtp.host", "192.168.1.214");
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.port", "25");
	        
//	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getInstance(props, null);
	        Transport tr = session.getTransport("smtp");
	        tr.connect(session.getProperty("mail.smtp.host"), session.getProperty("mail.smtp.user"), session.getProperty("mail.smtp.password"));

	        Message msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress("generali@ddd.com"));
	        msg.setSentDate(new java.util.Date());
	        msg.addRecipient(Message.RecipientType.TO, new InternetAddress("pratyay@generali.co.th"));
	        msg.setSubject("Test sfs"); 
	        msg.setContent("<b>hello<b>", "text/html; charset=TIS-620");

	        msg.saveChanges();
	        tr.sendMessage(msg, msg.getAllRecipients());
	        tr.close();

//	        // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	        mailSender.setHost("192.168.1.214");
//	        mailSender.setPort(25);
//	         
//	        MimeMessage message = mailSender.createMimeMessage();
//	        
//	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//	        helper.setFrom("xxxxx@generali.co.th");
//	        helper.setTo("pratyay@generali.co.th");
//	        helper.setSubject("ssssssssssss");
//	        helper.setText("sssssssss");
//	        mailSender.send(message);
	        
	}

}
