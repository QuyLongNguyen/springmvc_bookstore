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

import com.longnguyenquy.dto.UserRegister;
import com.longnguyenquy.entity.User;
import com.longnguyenquy.service.CartService;
import com.longnguyenquy.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService shoppingService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("")
	public String showRegistrationForm(Model model) {

		model.addAttribute("userDto", new UserRegister());

		return "registration-form";
	}
	
	
	@PostMapping("/processRegistration")
	public String processRegistration(@Valid @ModelAttribute("userDto") UserRegister userDto, BindingResult bindingResult,
			Model model) {
		String userName = userDto.getUsername();

		// form validation
		if (bindingResult.hasErrors()) {
			return "registration-form";
		}

		// check the database if user already exists
		User existing = userService.findByUserName(userName);
		if (existing != null) {
			model.addAttribute("crmUser", new UserRegister());
			model.addAttribute("registrationError", "User name already exists.");

			return "registration-form";
		}
		// create user account
		userService.save(userDto);
		
		//create avaiable cart for user
		shoppingService.createCart(userName);
		
		return "registration-confirmation";
	}
}
