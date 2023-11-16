package com.hexaware.medicalbillingsystems.restcontroller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import com.hexaware.medicalbillingsystems.entities.HealthcareProvider;
import com.hexaware.medicalbillingsystems.entities.InsuranceClaims;
import com.hexaware.medicalbillingsystems.entities.InsurancePlans;
import com.hexaware.medicalbillingsystems.entities.Patients;
import com.hexaware.medicalbillingsystems.service.IHealthcareProviderService;
import com.hexaware.medicalbillingsystems.service.IInsuranceClaimsService;
import com.hexaware.medicalbillingsystems.service.IInsurancePlansService;
import com.hexaware.medicalbillingsystems.service.IPatientsService;

@RestController
	@RequestMapping("/api/admin")
	public class AdminRestController {

	Logger logger =LoggerFactory.getLogger(AdminRestController.class);
		
		private IHealthcareProviderService providerService;
		@Autowired
		public AdminRestController(IHealthcareProviderService providerService) {
			super();
			this.providerService = providerService;
		}

		
		private IPatientsService patientService;
		@Autowired
		public AdminRestController(IPatientsService patientService) {
			super();
			this.patientService = patientService;
		}

	
		private IInsuranceClaimsService claimService;
		@Autowired
		public AdminRestController(IInsuranceClaimsService claimService) {
			super();
			this.claimService = claimService;
		}

		
		private IInsurancePlansService planService;
		@Autowired
		public AdminRestController(IInsurancePlansService planService) {
			super();
			this.planService = planService;
		}

		@GetMapping("/welcome")
		public String heyAdmin() {
			return "Welcome Admin";
		}
		@GetMapping("/getallpatients")
		public List<Patients> getAllPatients() {
			logger.info("All the Patients List");
			return patientService.getAllPatients();
		}

		@GetMapping("/getallproviders")
		public List<HealthcareProvider> getAllHealthcareProviders() {
			logger.info("All HealthcareProviders are Inserted");
			return providerService.getAllHealthcareProviders();
		}

		@GetMapping("/getallinsuranceclaims")
		public List<InsuranceClaims> getAllInsuranceClaims() {
			logger.info("Getting all the InsuranceClaims");
			return claimService.getAllInsuranceClaims();
		}

		@GetMapping("/getallinsuranceplans")
		public List<InsurancePlans> getAllInsurancePlans() {
			return planService.getAllPlans();
		}

	}

