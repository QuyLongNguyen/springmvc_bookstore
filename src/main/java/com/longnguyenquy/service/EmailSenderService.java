package com.longnguyenquy.service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import net.bytebuddy.utility.RandomString;

@Service
public class EmailSenderService implements SenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public boolean sendMessages(String address, String link) throws MessagingException{
		
		boolean success = false;
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message);
		
		messageHelper.setFrom("vutienthanh2xxx@gmail.com");
		messageHelper.setTo(address);
		messageHelper.setSubject("Reset password");	
		
		String content = "<p>Hello,</p>"
				+ "<p>You have requested to reset your password.</p>"
				+ "<p>Copy the link below to change your password:</p>"
				+ "<p><a href=\" " +link+ "\">"+link+"</a></p><br>"
				+ "<p>Ignore this email if you do remember your password, or you have not made the request.</p>";
		
		messageHelper.setText(content, true);
		
		mailSender.send(message);
		success = true;
		
		return success;
	}

	@Override
	public String generateToken(int length) {
		
		return RandomString.make(length);
	}
	
}
