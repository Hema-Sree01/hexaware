package com.hexaware.medicalbillingsystems.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
/*
@Author :  Hema Sree  
Modified Date : 28-10-2023
Description : Entity class for InvoiceDetails containing various properties
*/
@Entity
public class InvoiceDetails {

	@Id
	@SequenceGenerator(name="invoiceSeq",initialValue = 500,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "invoiceSeq")
	private int invoiceId;
	private LocalDate invoiceDate;
	private LocalDate invoiceDueDate;
	@DecimalMin(value="1000.00")
	@DecimalMax(value="8000.00")
	private double consultationFee;
	private double diagnosticTestsFeee;
	private double diagnosticScanFee;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_Id")
	private Patients patient;
	@NotNull
	private int invoiceTax;


	private double invoiceTotalAmount;


	public int getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}


	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}


	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}


	public LocalDate getInvoiceDueDate() {
		return invoiceDueDate;
	}


	public void setInvoiceDueDate(LocalDate invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
	}


	public double getConsultationFee() {
		return consultationFee;
	}


	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}


	public double getDiagnosticTestsFeee() {
		return diagnosticTestsFeee;
	}


	public void setDiagnosticTestsFeee(double diagnosticTestsFeee) {
		this.diagnosticTestsFeee = diagnosticTestsFeee;
	}


	public double getDiagnosticScanFee() {
		return diagnosticScanFee;
	}


	public void setDiagnosticScanFee(double diagnosticScanFee) {
		this.diagnosticScanFee = diagnosticScanFee;
	}


	public Patients getPatient() {
		return patient;
	}


	public void setPatient(Patients patient) {
		this.patient = patient;
	}


	public int getInvoiceTax() {
		return invoiceTax;
	}


	public void setInvoiceTax(int invoiceTax) {
		this.invoiceTax = invoiceTax;
	}


	public double getInvoiceTotalAmount() {
		return invoiceTotalAmount;
	}


	public void setInvoiceTotalAmount(double invoiceTotalAmount) {
		this.invoiceTotalAmount = invoiceTotalAmount;
	}


public InvoiceDetails(int invoiceId, LocalDate invoiceDate, LocalDate invoiceDueDate,
		@DecimalMin("1000.00") @DecimalMax("8000.00") double consultationFee, double diagnosticTestsFeee,
		double diagnosticScanFee, Patients patient, @NotNull int invoiceTax, double invoiceTotalAmount) {
	super();
	this.invoiceId = invoiceId;
	this.invoiceDate = invoiceDate;
	this.invoiceDueDate = invoiceDueDate;
	this.consultationFee = consultationFee;
	this.diagnosticTestsFeee = diagnosticTestsFeee;
	this.diagnosticScanFee = diagnosticScanFee;
	this.patient = patient;
	this.invoiceTax = invoiceTax;
	this.invoiceTotalAmount = invoiceTotalAmount;
}


public InvoiceDetails() {
	super();
}


}