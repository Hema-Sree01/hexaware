package com.hexaware.medicalbillingsystems.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystems.dto.InvoiceDetailsDTO;
import com.hexaware.medicalbillingsystems.entities.InvoiceDetails;
import com.hexaware.medicalbillingsystems.service.IInvoiceDetailsService;
/*
@Author :  Hema Sree
Modified Date : 14-11-2023
Description : Controller  InvoiceDetails
*/
@RestController
@RequestMapping("/api/v1/invoicedetails")
public class InvoiceDetailsRestController {
	@Autowired
	private IInvoiceDetailsService service;
	
	@PostMapping( path="/add/newinvoice",consumes = "application/json",produces="application/json")
	public InvoiceDetails generateNewInvoice(@RequestBody InvoiceDetailsDTO detailsDTO)
	{
		return service.generateInvoice(detailsDTO);
	}
	
	@GetMapping(path = "/getinvoicebyid/{invoiceId}",produces="application/json")
	public InvoiceDetailsDTO getInvoiceDetailsById(@PathVariable int invoiceId )
	{
		return service.getInvoiceById(invoiceId);
	}
	
	@GetMapping("/getallinvoices")
	public List<InvoiceDetails> getAllInvoiceDetails()
	{
		return service.getAllGeneratedInvoice();
	}
}
