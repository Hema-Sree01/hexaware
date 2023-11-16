package com.hexaware.medicalbillingsystems.service;

import java.util.List;

import com.hexaware.medicalbillingsystems.dto.InsuranceClaimsDTO;
import com.hexaware.medicalbillingsystems.entities.InsuranceClaims;

public interface IInsuranceClaimsService {
	
	public InsuranceClaims insertClaims(InsuranceClaimsDTO claimDTO);

	public InsuranceClaims updateClaimStatus(InsuranceClaimsDTO claimsDTO);

	public String approveClaim(int claimid);
 
	public InsuranceClaimsDTO getById(long claimId);
	 
	public int getTotalPendingInsuranceClaims(String claimStatus);

	public int getTotalApprovedClaims(String claimStatus);
	
	public List<InsuranceClaims> getAllInsuranceClaims();

}