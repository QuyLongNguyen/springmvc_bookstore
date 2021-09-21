package com.longnguyenquy.service;

import java.io.IOException;

import java.util.Optional;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.longnguyenquy.dto.GoogleAccount;
import com.longnguyenquy.entity.User;

import net.bytebuddy.utility.RandomString;

@Component
public class GoogleServiceImpl implements GoogleService {

	@Autowired
	private Environment env;
	
	@Autowired
	private UserService userSevice;
	
	@Autowired
	private CartService cartService;
	
	@Override
	public String getToken(String code) throws ClientProtocolException,  IOException {
		
		String link = env.getProperty("google.link.get.token");
		System.out.println("before post");
		String response = Request.Post(link)
							.bodyForm(Form.form()
								.add("client_id",env.getProperty("google.app.id"))
								.add("client_secret",env.getProperty("google.app.secret"))
								.add("redirect_uri"	, env.getProperty("google.redirect.uri"))
								.add("code", code)
								.add("grant_type","authorization_code")
								.build()).execute().returnContent().asString();
		
		System.out.println("after post");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response).get("access_token");
				
		return node.textValue();
	}
	
	@Override
	public GoogleAccount getUserInfo (final String accessToken) throws ClientProtocolException, IOException {
		
	    String link = env.getProperty("google.link.get.user_info") + accessToken;
	    String response = Request.Get(link).execute().returnContent().asString();
	    ObjectMapper mapper = new ObjectMapper();
	    GoogleAccount googleAccount = mapper.readValue(response, GoogleAccount.class);
	
	    return googleAccount;
	  }
	

	@Override
	public User buildUser(GoogleAccount googleAccount) {
		
		User user = userSevice.findByUserName(googleAccount.getEmail());
		if(user == null) {
			user = new com.longnguyenquy.entity.User(googleAccount.getEmail(),
														RandomString.make(16),
														Optional.ofNullable(googleAccount.getGiven_name()).orElse("unknown"), 
														Optional.ofNullable(googleAccount.getFamily_name()).orElse("unknown"), 
														googleAccount.getEmail(), 
														"0000000000", 
														"unknown");
			userSevice.save(user);
			cartService.createCart(googleAccount.getEmail());
			
		}
		return user;
	}
	
}
