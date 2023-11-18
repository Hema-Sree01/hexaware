package com.hexaware.medicalbillingsystems.service;

import java.util.List;

import com.hexaware.medicalbillingsystems.dto.InsuranceClaimsDTO;
import com.hexaware.medicalbillingsystems.entities.InsuranceClaims;
/*
@Author :  Hema Sree 
Modified Date : 04-11-2023
Description : Interface of  IInsuranceClaimsService performing the following operations
*/
public interface IInsuranceClaimsService {

	public InsuranceClaims insertClaims(InsuranceClaimsDTO claimDTO);
	public InsuranceClaims updateClaimStatus(InsuranceClaimsDTO claimsDTO,long claimId);
	
 
	public InsuranceClaimsDTO getById(long claimId);
	 
	public InsuranceClaimsDTO getTotalPendingInsuranceClaims(String claimStatus);
	public InsuranceClaimsDTO getTotalApprovedClaims(String claimStatus);
	
	public List<InsuranceClaims> getAllInsuranceClaims();
	
}