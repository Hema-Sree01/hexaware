package com.hexaware.medicalbillingsystems.service;
import org.slf4j.Logger;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystems.dto.InvoiceDetailsDTO;
import com.hexaware.medicalbillingsystems.entities.InsurancePlans;
import com.hexaware.medicalbillingsystems.entities.InvoiceDetails;
import com.hexaware.medicalbillingsystems.exception.NoSuchInvoiceGeneratedException;
import com.hexaware.medicalbillingsystems.repository.InvoiceDetailsRepository;
/*
@Author :   Rajat Darvhekar
Modified Date : 04-11-2023
Description :Service Implementation class for InvoiceDetailsServiceImpl implementing InvoiceDetailsService
*/
@Service
public class InvoiceDetailsServiceImp implements IInvoiceDetailsService {

	Logger logger=LoggerFactory.getLogger(InvoiceDetailsServiceImp.class);
	
	@Autowired
	private InvoiceDetailsRepository repository;
	
	@Override
	public InvoiceDetails generateInvoice(InvoiceDetailsDTO detailsDTO) {
		InvoiceDetails details=new InvoiceDetails();
		details.setInvoiceDate(detailsDTO.getInvoiceDate());
		details.setInvoiceDueDate(detailsDTO.getInvoicedueDate());
		details.setInvoiceTax(detailsDTO.getInvoiceTax());
		details.setInvoiceTotalAmount(detailsDTO.getInvoiceTotalAmount());
		details.setPatient(detailsDTO.getPatient());
		details.setConsultationFee(detailsDTO.getConsultationFee());
		details.setDiagnosticTestsFeee(detailsDTO.getDiagnosticTestsFeee());
		details.setDiagnosticScanFee(detailsDTO.getDiagnosticScanFee());

		logger.info("Invoice Generated Successfully!!!!!!!");

		
		return repository.save(details);
	}

	@Override
	public List<InvoiceDetails> getAllGeneratedInvoice() {
		logger.info("All the Invoice Generated Details Fetched Successfully!!!!!");
		return repository.findAll();
	}
	@Override
	public InvoiceDetailsDTO getInvoiceById(int invoiceId) {
		InvoiceDetails details= repository.findById(invoiceId).orElseThrow(() -> new NoSuchInvoiceGeneratedException(
		         HttpStatus.NO_CONTENT,"No such Invoice with Id :"+invoiceId+" Found"));
		InvoiceDetailsDTO detailsDTO=new InvoiceDetailsDTO();
		detailsDTO.setInvoiceId(details.getInvoiceId());
		detailsDTO.setInvoiceDate(details.getInvoiceDate());
		detailsDTO.setInvoicedueDate(details.getInvoiceDueDate());
		detailsDTO.setInvoiceTax(details.getInvoiceTax());
		detailsDTO.setInvoiceTotalAmount(details.getInvoiceTotalAmount());
		detailsDTO.setPatient(details.getPatient());

		logger.info("Fetched the Invoice by Id "+invoiceId+" !!!!!!!!!");
        detailsDTO.setConsultationFee(details.getConsultationFee());
		detailsDTO.setDiagnosticTestsFeee(details.getDiagnosticTestsFeee());
		detailsDTO.setDiagnosticScanFee(details.getDiagnosticScanFee());

		return detailsDTO;
	}

}