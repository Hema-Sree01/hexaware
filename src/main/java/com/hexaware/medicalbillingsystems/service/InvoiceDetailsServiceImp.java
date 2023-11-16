package com.hexaware.medicalbillingsystems.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystems.entities.InsurancePlans;
import com.hexaware.medicalbillingsystems.entities.InvoiceDetails;

@Service
public class InvoiceDetailsServiceImp implements IInvoiceDetailsService{

	@Override
	public Set<InvoiceDetails> generateInvoice() {
      
		return null;
	}

	@Override
	public void invoiceGenerated(int invoiceId) {

	
	}

}