package com.longnguyenquy.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longnguyenquy.entity.Cart;
import com.longnguyenquy.entity.Item;
import com.longnguyenquy.service.CartService;

@Controller
@RequestMapping("/admin/carts")
public class AdminCartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("")
	public String getCarts(Model model) {
		
		List<Cart> carts = cartService.getCarts();
		
		model.addAttribute("carts", carts);
		
		return "/admin/admin-carts";
	}
	
	@GetMapping(value = "", params = {"id"})
	public String getCarts(@RequestParam("id") int cartId ,  Model model) {
		
		Cart cart = cartService.getCart(cartId);
		
		List<Item> items = cartService.getCartItemsOf(cartId);
		
		model.addAttribute("cart", cart);
		
		model.addAttribute("items", items);
		
		return "/admin/admin-cart";
	}
	
}
