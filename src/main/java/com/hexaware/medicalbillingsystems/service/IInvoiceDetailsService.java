package com.hexaware.medicalbillingsystems.service;

import java.util.Set;

import com.hexaware.medicalbillingsystems.entities.InvoiceDetails;

public interface IInvoiceDetailsService {
	
	
	public Set<InvoiceDetails> generateInvoice();
	
	public void invoiceGenerated(int invoiceId);

}