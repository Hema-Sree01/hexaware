package com.hexaware.medicalbillingsystems.restcontroller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystems.entities.HealthcareProvider;
import com.hexaware.medicalbillingsystems.entities.InsuranceClaims;
import com.hexaware.medicalbillingsystems.entities.InsurancePlans;
import com.hexaware.medicalbillingsystems.entities.Patients;
import com.hexaware.medicalbillingsystems.service.IHealthcareProviderService;
import com.hexaware.medicalbillingsystems.service.IInsuranceClaimsService;
import com.hexaware.medicalbillingsystems.service.IInsurancePlansService;
import com.hexaware.medicalbillingsystems.service.IPatientsService;


/*
@Author :  Hema Sree  
Modified Date : 14-11-2023
Description : Controller  for Admin 
*/
@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestController {
	@Autowired
	private IHealthcareProviderService providerService;
	@Autowired
	private IPatientsService patientService;
	@Autowired
	private IInsuranceClaimsService claimService;
	@Autowired
	private IInsurancePlansService planService;
	@GetMapping("/welcome")
	
	public String heyAdmin() {
		return "Welcome Admin";
	}
	@GetMapping("/getallpatients")
	
	public List<Patients> getAllPatients() {
		return patientService.getAllPatients();
	}
	@GetMapping("/getallproviders")
	public List<HealthcareProvider> getAllHealthcareProviders() {
		return providerService.getAllHealthcareProviders();
	}
	@GetMapping("/getallinsuranceclaims")
	public List<InsuranceClaims> getAllInsuranceClaims() {
		return claimService.getAllInsuranceClaims();
	}
	@GetMapping("/getallinsuranceplans")
	public List<InsurancePlans> getAllInsurancePlans() {
		return planService.getAllPlans();
	}
}