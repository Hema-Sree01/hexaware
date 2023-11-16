package com.hexaware.medicalbillingsystems.restcontroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystems.dto.InsuranceClaimsDTO;
import com.hexaware.medicalbillingsystems.entities.InsuranceClaims;
import com.hexaware.medicalbillingsystems.service.IInsuranceClaimsService;

@RestController
	@RequestMapping("/api/insuranceclaims")
	public class InsuranceClaimsRestController {

	
	Logger logger =LoggerFactory.getLogger(InsuranceClaimsRestController.class);
	
	
	    private IInsuranceClaimsService claimService;
	    @Autowired
		public InsuranceClaimsRestController(IInsuranceClaimsService claimService) {
		super();
		this.claimService = claimService;
	}
        
		@GetMapping("/new")
		public String getString() {
			return "Hello new Claim";
		}

		@PostMapping("/add/newclaim")
		public InsuranceClaims insertNewClaim(@RequestBody InsuranceClaimsDTO claimDTO) {
			return claimService.insertClaims(claimDTO);
		}

		@PutMapping("/update/claim")
		public InsuranceClaims updateStatus(@RequestBody InsuranceClaimsDTO claimDTO) {
			return claimService.updateClaimStatus(claimDTO);
		}

		@GetMapping("/getclaimbyid/{claimId}")
		public InsuranceClaimsDTO getClaimById(@PathVariable long claimId) {
			return claimService.getById(claimId);
		}

		@GetMapping("/getall/approvedclaims/{claimStatus}")
		public int getAllApprovedClaims(@PathVariable String claimStatus) {
			return claimService.getTotalApprovedClaims(claimStatus);

		}

		@GetMapping("/getall/pendingclaims")
		public int getAllPendingClaims() {
			return claimService.getTotalPendingInsuranceClaims("Pending");

		}

	}

