package com.hexaware.medicalbillingsystems.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.medicalbillingsystems.dto.InsuranceCompanyDTO;
import com.hexaware.medicalbillingsystems.entities.InsuranceCompany;
import com.hexaware.medicalbillingsystems.service.InsuranceCompanyServiceImp;

@SpringBootTest
public class InsuranceCompanyServiceTest {

    @Autowired
    private InsuranceCompanyServiceImp insuranceCompanyService;

    @Test
    public void testAddCompany() {
        InsuranceCompanyDTO companyDTO = new InsuranceCompanyDTO();
       

        Long companyId = insuranceCompanyService.addCompany(companyDTO);
        assertNotNull(companyId);
    }

    @Test
    public void testUpdateCompany() {
        InsuranceCompanyDTO companyDTO = new InsuranceCompanyDTO();
        

        Long companyId = insuranceCompanyService.addCompany(companyDTO);

        companyDTO.setName("Updated Company");
        insuranceCompanyService.updateCompany(companyDTO);

        InsuranceCompanyDTO updatedCompany = insuranceCompanyService.getCompanyById(companyId);
        assertEquals("Updated Company", updatedCompany.getName());
    }

    @Test
    public void testDeleteCompanyById() {
        InsuranceCompanyDTO companyDTO = new InsuranceCompanyDTO();
        

        Long companyId = insuranceCompanyService.addCompany(companyDTO);

        insuranceCompanyService.deleteCompanyById(companyId);

        assertNull(insuranceCompanyService.getCompanyById(companyId));
    }

    @Test
    public void testGetCompanyByName() {
        InsuranceCompanyDTO companyDTO = new InsuranceCompanyDTO();
        companyDTO.setName("Test Company");
        

        Long companyId = insuranceCompanyService.addCompany(companyDTO);

        InsuranceCompanyDTO retrievedCompany = insuranceCompanyService.getCompanyByName("Test Company");
        assertNotNull(retrievedCompany);
       
    }

    @Test
    public void testGetAllInsuranceCompanyDetails() {
        
        List<InsuranceCompanyDTO> companies = insuranceCompanyService.getAllInsuranceCompanyDetails();
        assertNotNull(companies);
        
    }
}