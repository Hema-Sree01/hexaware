package com.hexaware.medicalbillingsystems.restcontroller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystems.dto.HealthcareProviderDTO;
import com.hexaware.medicalbillingsystems.entities.HealthcareProvider;
import com.hexaware.medicalbillingsystems.service.IHealthcareProviderService;
/*
@Author :   Rajat Darvhekar  
Modified Date : 14-11-2023
Description : Controller  for HealthcareProvider
*/
@RestController
@RequestMapping("/api/v1/provider")
public class HealthcareProviderRestController {
	@Autowired
	private  IHealthcareProviderService service;
	@GetMapping("/welcome")
	public String newProvider() {
		return "Hello New Provider";
	}
	@PostMapping(path="/add/provider",consumes = "application/json",produces="application/json")
	public HealthcareProvider insertNewProvider(@RequestBody HealthcareProviderDTO providerdto) {
		return service.addProvider(providerdto);
	}
	@PutMapping("/update/provider")
	public HealthcareProvider updateprovider(@RequestBody HealthcareProviderDTO providerdto) {
		return service.updateProvider(providerdto);
	}
	@GetMapping("/getall/provider")
	public List<HealthcareProvider> getAllProviders() {
		return service.getAllHealthcareProviders();
	}
	@DeleteMapping("/delete/provider")
	public String deleteProvider(int providerId) {
		service.deleteProvider(providerId);
		return "Provider with id " + providerId + " is deleted";
	}
	@GetMapping("/getById/{providerId}")
	public HealthcareProviderDTO getProviderById(int providerId) {
		return service.getProviderById(providerId);
	}
}