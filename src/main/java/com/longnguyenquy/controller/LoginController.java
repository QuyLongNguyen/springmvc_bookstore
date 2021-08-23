package com.longnguyenquy.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longnguyenquy.dto.GoogleAccount;
import com.longnguyenquy.entity.User;
import com.longnguyenquy.service.GoogleService;
import com.longnguyenquy.service.UserService;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	GoogleService googleService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public String showLoginForm() {
		
		return "login";
	}
	
	@GetMapping("/google")
	public String loginGoogle(@RequestParam(required = false) String code) throws ClientProtocolException, IOException {
		
		if (code == null || code.isEmpty()) {
		     return "redirect:/login?google=error";
		 }
		
		String accessToken = googleService.getToken(code);	
		GoogleAccount account = googleService.getUserInfo(accessToken);
		UserDetails userDetails = googleService.buildUser(account);
		UsernamePasswordAuthenticationToken authentication = 
				new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
		return "redirect:/home";
	}
	
	@GetMapping("/access-denied")
	public String showDeniedForm() {
		return "access-denied";
	}
}
