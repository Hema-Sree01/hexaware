package com.hexaware.medicalbillingsystems.service;

import java.util.List;
import java.util.Set;

import com.hexaware.medicalbillingsystems.dto.HealthcareProviderDTO;
import com.hexaware.medicalbillingsystems.entities.HealthcareProvider;


public interface IHealthcareProviderService {

	public HealthcareProvider addProvider(HealthcareProviderDTO providerdto);
	public HealthcareProvider updateProvider(HealthcareProviderDTO providerdto);
	public void deleteProvider(int providerId);
	
	public List<HealthcareProvider> getAllHealthcareProviders();
	public HealthcareProviderDTO getProviderById(int providerId);
    
}