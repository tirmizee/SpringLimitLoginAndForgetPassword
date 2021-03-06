package com.tirmizee.backend.service;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.tirmizee.backend.service.data.SimpleMailInfo;

@Service("MailService")
public class MailServiceImpl implements MailService{
	
	public static final String ENCODE_UTF8 = "utf-8";

	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Autowired
	private ExcelService excelService;

	@Override
	public void sendSimpleMail(SimpleMailInfo mailInfo)  {
		MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
		try {
			DataSource fds = new ByteArrayDataSource(excelService.test().toByteArray(), "application/vnd.ms-excel");
			
			helper = new MimeMessageHelper(message, true ,ENCODE_UTF8);
			helper.setFrom(mailInfo.getFrom());
	        helper.setTo(mailInfo.getTo());
	        helper.setSubject(mailInfo.getSubject());
	        helper.setText(mailInfo.getContent() , true);
	        helper.addInline("company-logo", new ClassPathResource("picture/logo.jpg"));
	        helper.addAttachment("test.xls", fds);
	        mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
