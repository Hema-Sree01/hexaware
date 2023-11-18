package com.hexaware.medicalbillingsystems.service;

import java.util.List;
import java.util.Set;

import com.hexaware.medicalbillingsystems.dto.InsuranceCompanyDTO;
import com.hexaware.medicalbillingsystems.entities.InsuranceCompany;

/*
@Author :  Hema Sree  
Modified Date : 04-11-2023
Description : Interface of  IInsuranceCompanyService performing the following operations
*/
public interface IInsuranceCompanyService {
	public InsuranceCompany addCompany(InsuranceCompanyDTO companydto);

	public InsuranceCompany updateCompany(InsuranceCompanyDTO companydto);
	public void deleteCompanyById(int companyId);
	public InsuranceCompanyDTO getCompanyByName(String companyName);
	public List<InsuranceCompany> getAllInsuranceCompanyDetails();
}