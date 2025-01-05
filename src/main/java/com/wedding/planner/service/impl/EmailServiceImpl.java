package com.wedding.planner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wedding.planner.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(String to, String subject, String body) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		message.setRecipients(jakarta.mail.Message.RecipientType.TO, to);
		message.setSubject(subject);
		message.setContent(body, "text/html; charset=utf-8");
		mailSender.send(message);
	}
}
