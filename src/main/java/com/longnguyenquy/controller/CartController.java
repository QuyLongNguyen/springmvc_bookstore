package com.longnguyenquy.controller;

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

import com.longnguyenquy.entity.Item;
import com.longnguyenquy.service.CartService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping(value = {"/",""})
	public String showCart(Model model) {
		
		List<Item> items = cartService.getCartItems();
	
		model.addAttribute("items", items);
		return "cart";
	}
	
	@GetMapping("/updateItem")
	public String updateItem(@RequestParam("itemId") int itemId, @RequestParam("quantity") int quantity) {
		
		cartService.updateItem(itemId, quantity);
		
		return "redirect:/cart";
	}
	
	@GetMapping("/deleteItem")
	public String deleteItem(@RequestParam("itemId") int itemId) {
		
		cartService.deleteItem(itemId);
		
		return "redirect:/cart";
	}
	
	
	
}
