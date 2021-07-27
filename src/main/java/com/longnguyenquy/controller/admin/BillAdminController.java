package com.longnguyenquy.controller.admin;

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
import com.longnguyenquy.entity.Status;
import com.longnguyenquy.service.BillService;

@Controller
@RequestMapping("/admin/bills")
public class BillAdminController {

	@Autowired
	BillService billService;
	
	@GetMapping("")
	public String showBills(Model model) {
		
		List<Bill> bills = billService.getBills();
		
		model.addAttribute("bills", bills);
		
		return "/admin/admin-bills";
	}
	
	@GetMapping("/{billId}")
	public String showBill(@PathVariable(name = "billId") int billId, Model model) {
		
		Bill bill = billService.getBill(billId);
		
		List<BillItem> billItems = billService.getItemsOf(bill);
		
		List<Status> status = billService.getAllStatus(); 
		
		model.addAttribute("bill", bill);
		model.addAttribute("billItems", billItems);
		model.addAttribute("status",status);
		
		return "/admin/bill-form";
	}
}
