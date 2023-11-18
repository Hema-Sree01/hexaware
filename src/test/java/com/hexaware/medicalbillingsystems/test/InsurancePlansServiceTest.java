package com.hexaware.medicalbillingsystems.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.medicalbillingsystems.dto.InsurancePlansDTO;
import com.hexaware.medicalbillingsystems.entities.InsurancePlans;
import com.hexaware.medicalbillingsystems.service.InsurancePlansServiceImp;

@SpringBootTest
public class InsurancePlansServiceTest {

    @Autowired
    private InsurancePlansServiceImp insurancePlansService;

    @Test
    public void testAddInsurancePlan() {
        InsurancePlansDTO insurancePlansDTO = new InsurancePlansDTO();
       

        Long planId = insurancePlansService.addInsurancePlan(insurancePlansDTO);
        assertNotNull(planId);
    }

    @Test
    public void testUpdateInsurancePlan() {
        InsurancePlansDTO insurancePlansDTO = new InsurancePlansDTO();
       

        Long planId = insurancePlansService.addInsurancePlan(insurancePlansDTO);

        insurancePlansDTO.setName("Updated Plan");
        insurancePlansService.updateInsurancePlan(insurancePlansDTO);

        InsurancePlansDTO updatedPlan = insurancePlansService.getPlanById(planId);
        assertEquals("Updated Plan", updatedPlan.getName());
    }

    @Test
    public void testDeleteInsurancePlan() {
        InsurancePlansDTO insurancePlansDTO = new InsurancePlansDTO();
        

        Long planId = insurancePlansService.addInsurancePlan(insurancePlansDTO);

        insurancePlansService.deleteInsurancePlan(planId);

        assertNull(insurancePlansService.getPlanById(planId));
    }

    @Test
    public void testGetPlanByName() {
        InsurancePlansDTO insurancePlansDTO = new InsurancePlansDTO();
        insurancePlansDTO.setName("Test Plan");
       

        Long planId = insurancePlansService.addInsurancePlan(insurancePlansDTO);

        InsurancePlansDTO retrievedPlan = insurancePlansService.getPlanByName("Test Plan");
        assertNotNull(retrievedPlan);
       
    }

    @Test
    public void testGetAllPlans() {
       
        List<InsurancePlansDTO> plans = insurancePlansService.getAllPlans();
        assertNotNull(plans);
        
    }
}