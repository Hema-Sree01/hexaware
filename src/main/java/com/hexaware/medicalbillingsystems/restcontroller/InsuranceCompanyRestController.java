package com.hexaware.medicalbillingsystems.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexaware.medicalbillingsystems.service.IInsuranceCompanyService;

@RestController
@RequestMapping("/api/insurancecompany")
public class InsuranceCompanyRestController {
	@Autowired
	IInsuranceCompanyService service;
	
	@GetMapping("/new")
	public String getString() {
		return "Insurance Company";
	}

	
	

}



