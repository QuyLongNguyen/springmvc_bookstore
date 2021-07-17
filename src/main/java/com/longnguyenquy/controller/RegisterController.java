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

import com.longnguyenquy.dto.UserDto;
import com.longnguyenquy.entity.User;
import com.longnguyenquy.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model) {

		model.addAttribute("userDto", new UserDto());

		return "registration-form";
	}

	@PostMapping("/processRegistration")
	public String processRegistration(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult,
			Model model) {
		String userName = userDto.getUsername();

		// form validation
		if (bindingResult.hasErrors()) {
			System.out.println("error");
			return "registration-form";
		}

		// check the database if user already exists
		User existing = userService.findByUserName(userName);
		if (existing != null) {
			model.addAttribute("crmUser", new UserDto());
			model.addAttribute("registrationError", "User name already exists.");

			return "registration-form";
		}
		// create user account
		userService.save(userDto);

		return "registration-confirmation";
	}

}
