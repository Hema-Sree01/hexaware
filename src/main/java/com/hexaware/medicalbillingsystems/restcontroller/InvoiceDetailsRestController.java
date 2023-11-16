package com.hexaware.medicalbillingsystems.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexaware.medicalbillingsystems.service.IInvoiceDetailsService;

@RestController
@RequestMapping("/api/invoicedetails")
public class InvoiceDetailsRestController {
	@Autowired
	IInvoiceDetailsService service;
	
	
	@GetMapping("/welcome")
	public String visitor() {
		return "Welcome to our website check your Details";

	}



}
