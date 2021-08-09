package com.longnguyenquy.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longnguyenquy.entity.Role;
import com.longnguyenquy.entity.User;
import com.longnguyenquy.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String showAllUsers(Model model) {
		
		List<User> users = userService.getUsers();
		
		model.addAttribute("users", users);
		
		return "/admin/admin-users";
	}
	
	@GetMapping(value = "", params = "id")
	public String getUser(@RequestParam("id") long id, Model model) {
		
		User user = userService.getUser(id);
		List<Role> roles = userService.getRoles();
		
		model.addAttribute("user", user);
		model.addAttribute("allRoles", roles);
		
		
		return "/admin/user-form";
	}
	
	@PostMapping("save-user")
	public String saveUser(@ModelAttribute("user") User user) {
		
		System.out.println(user.getRoles());
		userService.setRoles(user);
		return "redirect:/admin/users";
	}
	
	
}
