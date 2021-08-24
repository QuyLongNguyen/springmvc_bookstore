package com.longnguyenquy.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longnguyenquy.dto.GoogleAccount;
import com.longnguyenquy.dto.PasswordChanger;
import com.longnguyenquy.entity.User;
import com.longnguyenquy.service.GoogleService;
import com.longnguyenquy.service.SenderService;
import com.longnguyenquy.service.UserService;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	GoogleService googleService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SenderService senderService;
	
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
	
	@GetMapping("/forgetPassword")
	public String showForgetPasswordForm() {
		
		return "forget-password";
	}
	
	@PostMapping("/sendEmail")
	public String sendEmail(HttpServletRequest request, Model model) {
		
		String email = request.getParameter("email");
		System.out.println(email);
		User user = userService.findByEmail(email);
		if(user == null) {
			model.addAttribute("error", new String("Not found user with this email"));
		}
		else {
			String contextPath = request.getContextPath();		
			String token = senderService.generateToken(32);
			String link = "localhost:8080" + contextPath +"/login/resetPassword?token="+ token;
			user.setResetPasswordToken(token);
			userService.save(user);
			try {
				senderService.sendMessages(email, link);
				model.addAttribute("message", new String("Please check your email, maybe in spam"));
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
	
		}
		return "forget-password";
	}
	
	@GetMapping(value = "/resetPassword", params = {"token"})
	public String showResetPasswordForm(@RequestParam("token") String token, Model model){
		
		PasswordChanger passwordChanger = new PasswordChanger();
		passwordChanger.setOldPassword(token);
		model.addAttribute("passwordChanger", passwordChanger);
		
		return "reset-password";
	}
	
	@PostMapping("/resetPassword")
	public String resetPassword(@Validated @ModelAttribute("passwordChanger") PasswordChanger passwordChanger
			, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()) {
			model.addAttribute("error", new String("Invalid request"));
			return "reset-password";
		}
		if(userService.resetPassword(passwordChanger)) {
			return "registration-confirmation";
		}
		model.addAttribute("error", new String("Can't reset password"));
		return "reset-password";
	}
	
	@GetMapping("/access-denied")
	public String showDeniedForm() {
		return "access-denied";
	}
}
