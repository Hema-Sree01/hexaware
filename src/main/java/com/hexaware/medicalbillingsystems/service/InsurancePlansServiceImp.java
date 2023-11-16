package com.hexaware.medicalbillingsystems.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystems.dto.InsurancePlansDTO;
import com.hexaware.medicalbillingsystems.entities.InsurancePlans;
import com.hexaware.medicalbillingsystems.repository.InsurancePlansRepository;
import com.hexaware.medicalbillingsystems.restcontroller.HealthcareProviderRestController;

@Service
public class InsurancePlansServiceImp implements IInsurancePlansService{
	Logger logger =LoggerFactory.getLogger(HealthcareProviderRestController.class);
	@Autowired
	IInsuranceClaimsService service;
	@Autowired
	InsurancePlansRepository repository;
	@Override
	public InsurancePlans addInsurancePlan(InsurancePlansDTO plansdto) {
		
		InsurancePlans plans=new InsurancePlans();
		plans.setPlanName(plansdto.getPlanName());
		plans.setPlanType(plansdto.getPlanType());
		plans.setPlanCoverAmount(plansdto.getPlanCoverAmount());
		plans.setPlanEmi(plansdto.getPlanEmi());
		plans.setPlanDetails(plansdto.getPlanDetails());
		/*
		 * 
		 * Set<InsuranceClaims> claimSet = new HashSet<>(); for (InsuranceClaims
		 * claimdto : plansdto.getClaims()) { InsuranceClaims claims = new
		 * InsuranceClaims(); claims.setClaimAmount(claimdto.getClaimAmount());
		 * claims.setClaimStatus(claimdto.getClaimStatus());
		 * claims.setPatient(claimdto.getPatient()); claims.setPlans(plans);
		 * 
		 * claimSet.add(claimdto); }
		 * 
		 * plans.setClaims(claimSet);
		 */
		
		
		return repository.save(plans);
	}

//	@Override
//	public InsurancePlans updateInsurancePlans(InsurancePlansDTO plansdto) {
//		// TODO Auto-generated method stub
//		return ;
//	}

	@Override
	public void deleteInsurancePlan(int planId) {
		
		repository.deleteById(planId);
		
	}

	@Override
	public InsurancePlansDTO getPlanByName(String planName) {
		InsurancePlans plans=repository.findByPlanName(planName).orElse(new InsurancePlans());
		InsurancePlansDTO planDTO=new InsurancePlansDTO();
		planDTO.setPlanId(plans.getPlanId());
		planDTO.setPlanName(plans.getPlanName());
		planDTO.setPlanType(plans.getPlanType());
		planDTO.setPlanCoverAmount(plans.getPlanCoverAmount());
		planDTO.setPlanEmi(plans.getPlanEmi());
		planDTO.setPlanEmi(plans.getPlanEmi());
		planDTO.setClaims(plans.getClaims());
		logger.warn("Plan by name not found");
		return planDTO;
		
	}

	@Override
	public List<InsurancePlans> getAllPlans() {

		return repository.findAll();
	}

	@Override
	public InsurancePlans updateInsurancePlans(InsurancePlansDTO plansdto) {
    logger.info("Updated Successfully");
		return null;
	}


}