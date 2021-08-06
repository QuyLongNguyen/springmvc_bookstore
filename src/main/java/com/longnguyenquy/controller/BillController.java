package com.longnguyenquy.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.longnguyenquy.entity.Bill;
import com.longnguyenquy.entity.BillItem;
import com.longnguyenquy.entity.User;
import com.longnguyenquy.service.BillService;
import com.longnguyenquy.service.UserService;

@Controller
@RequestMapping("/bills")
public class BillController {

	@Autowired
	BillService billService;

	@Autowired
	UserService userService;

	@GetMapping("")
	public String showBills(Model model) {

		List<Bill> bills = billService.getBillsOfCurentUser();
		model.addAttribute("bills", bills);

		List<BigDecimal> totals = new ArrayList<BigDecimal>(bills.size());
		for (Bill bill : bills) {
			totals.add(billService.getTotalPrice(bill));

		}

		model.addAttribute("totals", totals);

		return "bills";
	}

	@GetMapping("/{billId}")
	public String viewBilldetail(@PathVariable("billId") int billId, Model model) {

		Bill bill = billService.getBill(billId);
		model.addAttribute("bill", bill);

		List<BillItem> billItems = billService.getItemsOf(bill);
		model.addAttribute("billItems", billItems);

		return "bill";
	}

	@GetMapping("/deleteBill")
	public String deleteBill(@RequestParam("billId") int billId, Model model) {

		Bill bill = billService.getBill(billId);
		
		User user = userService.currentUser();
		
		if(bill.getUser().getId() == user.getId()) {
			
			if(bill.getStatus().getStatusId() == 1) {
				billService.deleteBill(billId);
				return "redirect:/bills?delete=true";
			}
			
		}
		return "redirect:/bills?delete=false";
	}
}
