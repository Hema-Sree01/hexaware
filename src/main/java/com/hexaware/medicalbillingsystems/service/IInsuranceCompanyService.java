package com.hexaware.medicalbillingsystems.service;

import java.util.Set;

import com.hexaware.medicalbillingsystems.dto.InsuranceCompanyDTO;
import com.hexaware.medicalbillingsystems.entities.InsuranceCompany;


public interface IInsuranceCompanyService {
	public InsuranceCompany addCompany(InsuranceCompanyDTO companydto);
	public InsuranceCompany updateCompany(InsuranceCompanyDTO companydto);
	public void deleteCompany(int companyId);
	public InsuranceCompanyDTO  getCompanyByName(String companyName);
	public Set<InsuranceCompany> getAllInsuranceCompanyDetails();
}