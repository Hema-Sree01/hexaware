package com.hexaware.medicalbillingsystems.service;
import org.slf4j.Logger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystems.dto.InsuranceCompanyDTO;
import com.hexaware.medicalbillingsystems.entities.InsuranceCompany;
import com.hexaware.medicalbillingsystems.exception.CompanyNotRegisteredException;
import com.hexaware.medicalbillingsystems.repository.InsuranceCompanyRepository;

/*
@Author :  Hema Sree 
Modified Date : 04-11-2023
Description :Service Implementation class for InsuranceCompanyServiceImpl implementing IInsuranceCompanyService
*/
@Service
public class InsuranceCompanyServiceImp implements IInsuranceCompanyService {

	Logger logger=LoggerFactory.getLogger(InsuranceCompanyServiceImp.class);
	@Autowired
	private InsuranceCompanyRepository repository;
	@Override
	public InsuranceCompany addCompany(InsuranceCompanyDTO companydto) {
		InsuranceCompany company = new InsuranceCompany();
		company.setCompanyName(companydto.getCompanyName());
		company.setCompanyPassword(companydto.getCompanyPassword());
		company.setCompanyEmail(companydto.getCompanyEmail());
		company.setCompanyContact(companydto.getCompanyContact());
		company.setCompanyStartYears(companydto.getCompanyStartYears());
		logger.info("New Insurance Company is registered with us!!!");
		return repository.save(company);
	}
	@Override
	public InsuranceCompany updateCompany(InsuranceCompanyDTO companydto) {
		InsuranceCompany company = new InsuranceCompany();
		company.setCompanyId(companydto.getCompanyId());
		company.setCompanyName(companydto.getCompanyName());
		company.setCompanyPassword(companydto.getCompanyPassword());
		company.setCompanyEmail(companydto.getCompanyEmail());
		company.setCompanyContact(companydto.getCompanyContact());
		company.setCompanyStartYears(companydto.getCompanyStartYears());
		return repository.save(company);
	}
	@Override
	public void deleteCompanyById(int companyId) {
		logger.warn("Insurance Company with id "+companyId+" is deleted!!!!");
		repository.deleteById(companyId);
	}
	@Override
	public InsuranceCompanyDTO getCompanyByName(String companyName) {
		InsuranceCompany company = repository.findByCompanyName(companyName)
				.orElseThrow(() -> new CompanyNotRegisteredException(HttpStatus.SERVICE_UNAVAILABLE,
						"Company With name : " + companyName + " has not registered with us !!"));
		InsuranceCompanyDTO companyDTO = new InsuranceCompanyDTO();
		companyDTO.setCompanyId(company.getCompanyId());
		companyDTO.setCompanyName(company.getCompanyName());
		companyDTO.setCompanyPassword(company.getCompanyPassword());
		companyDTO.setCompanyEmail(company.getCompanyEmail());
		companyDTO.setCompanyContact(company.getCompanyContact());
		companyDTO.setCompanyStartYears(company.getCompanyStartYears());
		logger.info("Company with name "+companyName+" is displayed!!!!");
		return companyDTO;
	}
	@Override
	public List<InsuranceCompany> getAllInsuranceCompanyDetails() {
		return repository.findAll();
	}
	
	}
