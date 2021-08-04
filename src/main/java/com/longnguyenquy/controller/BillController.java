package com.longnguyenquy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.longnguyenquy.entity.Bill;
import com.longnguyenquy.service.BillService;

@Controller
@RequestMapping("/bills")
public class BillController {
	
	@Autowired
	BillService billService;
	
	@GetMapping("")
	public String showBills(Model model) {
		
		List<Bill> bills = billService.getBillsOfCurentUser();
		
		model.addAttribute("bills", bills);
		
		return "bills";
	}
}
