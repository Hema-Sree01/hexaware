package com.hexaware.medicalbillingsystems.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystems.dto.InsuranceCompanyDTO;
import com.hexaware.medicalbillingsystems.entities.InsuranceCompany;
import com.hexaware.medicalbillingsystems.service.IInsuranceCompanyService;
/*
@Author :  Rajat Darvhekar 
Modified Date : 14-11-2023
Description : Controller  InsuranceCompany
*/
@RestController
@RequestMapping("/api/v1/companies")
public class InsuranceCompanyRestController {
	@Autowired
	private IInsuranceCompanyService service;
	
	@PostMapping(path = "/add/newcompany",consumes = "application/json",produces="application/json")
	public InsuranceCompany addNewCompany(@RequestBody InsuranceCompanyDTO companyDTO)
	{
		return service.addCompany(companyDTO);
	}
	
	@PutMapping(path = "/update/company",consumes = "application/json",produces="application/json")
	public InsuranceCompany updateExistingCompany(@RequestBody InsuranceCompanyDTO companyDTO)
	{
		return service.updateCompany(companyDTO);
	}
	
	@DeleteMapping("/delete/companyById/{companyId}")
	public void deleteExistingCompany(@PathVariable int companyId)
	{
			service.deleteCompanyById(companyId);
	}
	
	@GetMapping("/getbycompanyname/{companyName}")
	public InsuranceCompanyDTO getCompanyByName(@PathVariable String companyName)
	{
		 return service.getCompanyByName(companyName);
		
	}
	
	@GetMapping("/getallcompaniesdata")
	public List<InsuranceCompany> getAllInsuranceCompanies()
	{
		return service.getAllInsuranceCompanyDetails();
	}
}
  