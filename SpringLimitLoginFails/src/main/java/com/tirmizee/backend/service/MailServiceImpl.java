package com.tirmizee.backend.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.tirmizee.backend.service.data.SimpleMailInfo;

@Service("MailService")
public class MailServiceImpl implements MailService{
	
	public static final String ENCODE_UTF8 = "utf-8";
	
	@Autowired
	JavaMailSenderImpl mailSender;

	@Override
	public void send(SimpleMailInfo mailInfo)  {
		MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
		try {
			message.setSubject(mailInfo.getSubject());
			helper = new MimeMessageHelper(message, true ,ENCODE_UTF8);
			helper.setFrom(mailInfo.getFrom());
	        helper.setTo(mailInfo.getTo());
	        helper.setSubject(mailInfo.getSubject());
	        helper.setText(mailInfo.getContent() , true);
	        mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
