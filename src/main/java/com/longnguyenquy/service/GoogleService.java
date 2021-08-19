package com.longnguyenquy.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.security.core.userdetails.UserDetails;

import com.longnguyenquy.dto.GoogleAccount;

public interface GoogleService {
	
	 String getToken(final String code) throws ClientProtocolException, IOException;
	 GoogleAccount getUserInfo (final String accessToken) throws ClientProtocolException, IOException;
	 UserDetails buildUser(GoogleAccount googleAccount); 
		    
}
