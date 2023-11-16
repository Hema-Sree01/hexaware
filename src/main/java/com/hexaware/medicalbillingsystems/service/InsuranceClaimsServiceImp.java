package com.hexaware.medicalbillingsystems.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystems.dto.InsuranceClaimsDTO;
import com.hexaware.medicalbillingsystems.entities.InsuranceClaims;
import com.hexaware.medicalbillingsystems.repository.InsuranceClaimsRepository;
import com.hexaware.medicalbillingsystems.restcontroller.HealthcareProviderRestController;

@Service
public class InsuranceClaimsServiceImp implements IInsuranceClaimsService {
	Logger logger =LoggerFactory.getLogger(HealthcareProviderRestController.class);
	@Autowired
	InsuranceClaimsRepository repository;
	

	@Override
	public String approveClaim(int claimid) {
		
		return null;
	}

	@Override
	public int getTotalPendingInsuranceClaims(String claimStatus) {
        logger.warn("Pending Status");
		return repository.getTotalPendingInsuranceClaims(claimStatus);
	}

	@Override
	public int getTotalApprovedClaims(String claimStatus) {
        logger.info("Total Claims get approved");
		return repository.getTotalApprovedClaims(claimStatus);
	}

	@Override
	public InsuranceClaimsDTO getById(long claimId) {
		 InsuranceClaims claim=repository.findById(claimId).orElse(new InsuranceClaims());
		 
		 InsuranceClaimsDTO claimdto=new InsuranceClaimsDTO();
		 claimdto.setClaimId(claim.getClaimId());
		 claimdto.setClaimAmount(claim.getClaimAmount());
		 claimdto.setClaimStatus(claim.getClaimStatus());
		 claimdto.setPatient(claim.getPatient());
		 logger.warn("Claims By Id not found");
		return claimdto;
	}

	@Override
	public InsuranceClaims insertClaims(InsuranceClaimsDTO claimDTO) {
		InsuranceClaims claims=new InsuranceClaims();
		claims.setClaimAmount(claimDTO.getClaimAmount());
		claims.setClaimStatus(claimDTO.getClaimStatus());
		claims.setPatient(claimDTO.getPatient());
		claims.setPlans(claimDTO.getPlans());
		logger.info("Inserted Claims Successfully");
		return repository.save(claims);
	}

	@Override
	public InsuranceClaims updateClaimStatus(InsuranceClaimsDTO claimsDTO) {
		InsuranceClaims claims=new InsuranceClaims();
		claims.setClaimAmount(claimsDTO.getClaimAmount());
		claims.setClaimStatus(claimsDTO.getClaimStatus());
		claims.setPatient(claimsDTO.getPatient());
		claims.setPlans(claimsDTO.getPlans());
		return repository.save(claims);
	}

	@Override
	public List<InsuranceClaims> getAllInsuranceClaims() {

		return repository.findAll();
	}

	
	
}