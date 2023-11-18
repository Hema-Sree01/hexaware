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
/*
@Author :   Rajat Darvhekar  
Modified Date : 02-11-2023
Description :Service Implementation class for InsurancePlansServiceImpl implementing IInsurancePlansService
*/
@Service
public class InsurancePlansServiceImp implements IInsurancePlansService {

	Logger logger=LoggerFactory.getLogger(InsurancePlansServiceImp.class);
	@Autowired
	private InsurancePlansRepository repository;
	@Override
	public InsurancePlans addInsurancePlan(InsurancePlansDTO plansdto) {
		InsurancePlans plans = new InsurancePlans();
		plans.setPlanName(plansdto.getPlanName());
		plans.setPlanType(plansdto.getPlanType());
		plans.setPlanCoverAmount(plansdto.getPlanCoverAmount());
		plans.setPlanEmi(plansdto.getPlanEmi());
		plans.setPlanDetails(plansdto.getPlanDetails());
		logger.info("New insurance plan is added!!!");
		return repository.save(plans);
	}
	@Override
	public void deleteInsurancePlan(int planId) {
		logger.warn("Insurance plans "+planId+" is deleted!!!");
		repository.deleteById(planId);
	}
	@Override
	public InsurancePlansDTO getPlanByName(String planName) {
		InsurancePlans plans = repository.findByPlanName(planName).orElse(new InsurancePlans());
		InsurancePlansDTO planDTO = new InsurancePlansDTO();
		planDTO.setPlanId(plans.getPlanId());
		planDTO.setPlanName(plans.getPlanName());
		planDTO.setPlanType(plans.getPlanType());
		planDTO.setPlanCoverAmount(plans.getPlanCoverAmount());
		planDTO.setPlanEmi(plans.getPlanEmi());
		planDTO.setPlanDetails(plans.getPlanDetails());
		planDTO.setClaims(plans.getClaims());
		logger.info("Insurance plan "+planName+" is displayed!!!");;
		return planDTO;
	}
	@Override
	public List<InsurancePlans> getAllPlans() {
		return repository.findAll();
	}
	@Override
	public InsurancePlans updateInsurancePlans(InsurancePlansDTO plansdto) {
		InsurancePlans plans = new InsurancePlans();
		plans.setPlanId(plansdto.getPlanId());
		plans.setPlanName(plansdto.getPlanName());
		plans.setPlanType(plansdto.getPlanType());
		plans.setPlanCoverAmount(plansdto.getPlanCoverAmount());
		plans.setPlanEmi(plansdto.getPlanEmi());
		plans.setPlanDetails(plansdto.getPlanDetails());
		logger.warn("Insurance plan is updated!!!");
		return repository.save(plans);
	}
}