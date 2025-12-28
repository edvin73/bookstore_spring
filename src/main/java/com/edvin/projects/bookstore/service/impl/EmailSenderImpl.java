package com.edvin.projects.bookstore.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.edvin.projects.bookstore.service.NotificationSender;

public class EmailSenderImpl implements NotificationSender {
	
	private Logger logger = LoggerFactory.getLogger(EmailSenderImpl.class);

	@Override
	public void send(String message) {
		// TODO Auto-generated method stub
		logger.info("Sending email with message: {}", message);
		
		// Method to send email via Google Mail API service
		
		
	}

}
