package com.longnguyenquy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.longnguyenquy.dto.PasswordChanger;
import com.longnguyenquy.dto.UserRegister;
import com.longnguyenquy.entity.User;
import com.longnguyenquy.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	
	@GetMapping("/profile")
	public String showProfile(Model model) {

		User user = userService.currentUser();
		
		model.addAttribute("user", user);

		return "user-profile";
	}
	
	@GetMapping("/password")
	public String showPasswordForm(Model model) {
		
		model.addAttribute("user", new PasswordChanger());
		
		return "change-password";
	}

	
	@PostMapping("/updateProfile")
	public String updateProfile(@Valid @ModelAttribute("user") User userDto, BindingResult bindingResult, Model model) {
		
		System.out.println(userDto);
		if (bindingResult.hasErrors()) {
			return "user-profile";
		}
		
		userService.updateProfile(userDto);
		
		return "redirect:/user/profile?update=true";
	}
	
	@PostMapping("/changePassword")
	public String changPassword(@Valid @ModelAttribute("user") PasswordChanger userDto, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "change-password";
		}
		
		boolean check = userService.changePassword(userDto);
		
		return "redirect:/user/password?change=true";
	}

}
