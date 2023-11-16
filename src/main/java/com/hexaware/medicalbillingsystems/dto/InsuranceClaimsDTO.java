package com.hexaware.medicalbillingsystems.dto;

import com.hexaware.medicalbillingsystems.entities.InsuranceCompany;
import com.hexaware.medicalbillingsystems.entities.InsurancePlans;
import com.hexaware.medicalbillingsystems.entities.Patients;

public class InsuranceClaimsDTO {
	private long claimId;
	private double claimAmount;
	private String ClaimStatus="Pending";
	private Patients patient;
   private InsurancePlans plans;
    
   private InsuranceCompany company;
   

public InsuranceClaimsDTO() {
	super();
}

public InsuranceClaimsDTO(long claimId, double claimAmount, String claimStatus, Patients patient, InsurancePlans plans,
		InsuranceCompany company) {
	super();
	this.claimId = claimId;
	this.claimAmount = claimAmount;
	ClaimStatus = claimStatus;
	this.patient = patient;
	this.plans = plans;
	this.company = company;
}

public long getClaimId() {
	return claimId;
}

public void setClaimId(long claimId) {
	this.claimId = claimId;
}

public double getClaimAmount() {
	return claimAmount;
}

public void setClaimAmount(double claimAmount) {
	this.claimAmount = claimAmount;
}

public String getClaimStatus() {
	return ClaimStatus;
}

public void setClaimStatus(String claimStatus) {
	ClaimStatus = claimStatus;
}

public Patients getPatient() {
	return patient;
}

public void setPatient(Patients patient) {
	this.patient = patient;
}

public InsurancePlans getPlans() {
	return plans;
}

public void setPlans(InsurancePlans plans) {
	this.plans = plans;
}

public InsuranceCompany getCompany() {
	return company;
}

public void setCompany(InsuranceCompany company) {
	this.company = company;
}
   

}