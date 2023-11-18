package com.hexaware.medicalbillingsystems.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.medicalbillingsystems.dto.InvoiceDetailsDTO;
import com.hexaware.medicalbillingsystems.entities.InvoiceDetails;
import com.hexaware.medicalbillingsystems.service.InvoiceDetailsServiceImp;

@SpringBootTest
public class InvoiceDetailsServiceTest {

    @Autowired
    private InvoiceDetailsServiceImp invoiceDetailsService;

    @Test
    public void testGenerateInvoice() {
        InvoiceDetailsDTO invoiceDetailsDTO = new InvoiceDetailsDTO();
       

        Long invoiceId = invoiceDetailsService.generateInvoice(invoiceDetailsDTO);
        assertNotNull(invoiceId);
    }

    @Test
    public void testGetAllGeneratedInvoice() {
       
        List<InvoiceDetailsDTO> invoices = invoiceDetailsService.getAllGeneratedInvoice();
        assertNotNull(invoices);
       
    }

    @Test
    public void testGetInvoiceById() {
        InvoiceDetailsDTO invoiceDetailsDTO = new InvoiceDetailsDTO();
       

        Long invoiceId = invoiceDetailsService.generateInvoice(invoiceDetailsDTO);

        InvoiceDetailsDTO retrievedInvoice = invoiceDetailsService.getInvoiceById(invoiceId);
        assertNotNull(retrievedInvoice);
        
    }
}