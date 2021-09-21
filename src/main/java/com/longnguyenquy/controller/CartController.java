package com.longnguyenquy.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.longnguyenquy.entity.Category;
import com.longnguyenquy.entity.Item;
import com.longnguyenquy.entity.User;
import com.longnguyenquy.service.CategoryService;
import com.longnguyenquy.service.UserService;
import com.longnguyenquy.service.CartService;


@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService shoppingService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = {"/",""})
	public String showCart(Model model,@RequestParam(required = false) boolean buy) {
		
		List<Category> categories = categoryService.getCategories();
		model.addAttribute("categories", categories);
		
		List<Item> items = shoppingService.getCartItems();
		
		model.addAttribute("items", items);
		model.addAttribute("cartCount", items.size());
		return "cart";
		
	}
	
	@GetMapping("/updateItem")
	public String updateItem(@RequestParam("itemId") int itemId, @RequestParam("quantity") int quantity) {
		
		shoppingService.updateItem(itemId, quantity);
		
		return "redirect:/cart";
	}
	
	@GetMapping("/deleteItem")
	public String deleteItem(@RequestParam("itemId") int itemId) {
		
		User user = userService.currentUser();
		
		shoppingService.deleteItem(user.getId(), itemId);
		
		return "redirect:/cart";
	}
	
	
	@PostMapping("/buy")
	public String buy() {
		
		shoppingService.buy();
		
		return "redirect:/cart?buy=true";
	}
}
