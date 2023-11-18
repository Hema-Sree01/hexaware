package com.hexaware.medicalbillingsystems.service;

import java.util.List;
import java.util.Set;

import com.hexaware.medicalbillingsystems.dto.InsurancePlansDTO;
import com.hexaware.medicalbillingsystems.entities.InsurancePlans;

/*
@Author :  Rajat Darvhekar  
Modified Date : 02-11-2023
Description : Interface of  InsurancePlansService performing the following operations
*/
public interface IInsurancePlansService {

	public InsurancePlans addInsurancePlan(InsurancePlansDTO plansdto);
	
	public InsurancePlans updateInsurancePlans(InsurancePlansDTO plansdto);
	 
	public void deleteInsurancePlan(int planId);
	
	public InsurancePlansDTO  getPlanByName(String planName);
	
	public List<InsurancePlans> getAllPlans();
	
}