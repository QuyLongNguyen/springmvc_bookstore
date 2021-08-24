package com.longnguyenquy.service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

public interface SenderService {

	boolean sendMessages(String address, String token) throws MessagingException;
	
	String generateToken(int length) ;
}
