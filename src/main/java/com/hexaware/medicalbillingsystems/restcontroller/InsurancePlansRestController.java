package com.hexaware.medicalbillingsystems.restcontroller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystems.dto.InsurancePlansDTO;
import com.hexaware.medicalbillingsystems.entities.InsurancePlans;
import com.hexaware.medicalbillingsystems.exception.PlanNotFoundException;
import com.hexaware.medicalbillingsystems.service.IInsurancePlansService;

@RestController
@RequestMapping("/api/insuranceplans")
public class InsurancePlansRestController {
	Logger logger =LoggerFactory.getLogger(InsurancePlansRestController.class);
	
	@Autowired
	IInsurancePlansService service;

	@GetMapping("/welcome")
	public String visitor() {
		return "Welcome to our website Add Your Plans";

	}

	@PostMapping("/add/plan")
	public InsurancePlans addNewPlan(@RequestBody InsurancePlansDTO plansdto) {
		return service.addInsurancePlan(plansdto);
	}

	@DeleteMapping("/delete/plan/{planId}")
	public String deletePlans(@PathVariable int planId) {
		service.deleteInsurancePlan(planId);
		return "Plan with id " + planId + " deleted";
	}

	@GetMapping("/getplanbyname/{planName}")
	public InsurancePlansDTO getPlanByNamee(@PathVariable String planName) {
		InsurancePlansDTO planDTO = service.getPlanByName(planName);
		if (planDTO.getPlanName() == null) {
			throw new PlanNotFoundException(HttpStatus.NO_CONTENT,"There is no plan with name "+ planName+ " ! Kindly Add it");
		}
		return planDTO;
	}

	@GetMapping("/getallplans")
	public List<InsurancePlans> getAllPlanDetails() {
		return service.getAllPlans();
	}

}