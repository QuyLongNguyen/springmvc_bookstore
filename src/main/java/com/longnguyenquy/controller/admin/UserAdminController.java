package com.longnguyenquy.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/users")
public class UserAdminController {
	
	@GetMapping(value = "")
	public String showUsers() {
		return "";
	}
}
