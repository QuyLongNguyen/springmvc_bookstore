package com.longnguyenquy.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;


import com.longnguyenquy.dto.GoogleAccount;
import com.longnguyenquy.entity.User;

public interface GoogleService {
	
	 String getToken(final String code) throws ClientProtocolException, IOException;
	 GoogleAccount getUserInfo (final String accessToken) throws ClientProtocolException, IOException;
	 User buildUser(GoogleAccount googleAccount);
		    
}
