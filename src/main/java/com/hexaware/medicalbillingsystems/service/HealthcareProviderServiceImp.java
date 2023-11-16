package com.hexaware.medicalbillingsystems.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystems.dto.HealthcareProviderDTO;
import com.hexaware.medicalbillingsystems.entities.HealthcareProvider;
import com.hexaware.medicalbillingsystems.repository.HealthcareProviderRepository;
import com.hexaware.medicalbillingsystems.restcontroller.HealthcareProviderRestController;
@Service
public class HealthcareProviderServiceImp implements IHealthcareProviderService {
	Logger logger =LoggerFactory.getLogger(HealthcareProviderRestController.class);
     @Autowired
	 HealthcareProviderRepository repository;
		@Override
	public HealthcareProvider addProvider(HealthcareProviderDTO providerdto) {
		HealthcareProvider provider = new HealthcareProvider();

		provider.setProviderName(providerdto.getProviderName());
		provider.setProviderPassword(providerdto.getProviderPassword());
		provider.setProviderEmail(providerdto.getProviderEmail());
		provider.setProviderGender(providerdto.getProviderGender());
		provider.setProviderSpeciality(providerdto.getProviderSpeciality());
		provider.setProviderDesignation(providerdto.getProviderDesignation());
		provider.setProviderExperience(providerdto.getProviderExperience());
		provider.setProviderQualification(providerdto.getProviderQualification());
		logger.info("The data get inserted successfully");
		return repository.save(provider);
	}


	@Override
	public HealthcareProvider updateProvider(HealthcareProviderDTO providerdto) {

		HealthcareProvider provider = new HealthcareProvider();
		provider.setProviderId(providerdto.getProviderId());
		provider.setProviderName(providerdto.getProviderName());
		provider.setProviderPassword(providerdto.getProviderPassword());
		provider.setProviderEmail(providerdto.getProviderEmail());
		provider.setProviderGender(providerdto.getProviderGender());
		provider.setProviderSpeciality(providerdto.getProviderSpeciality());
		provider.setProviderDesignation(providerdto.getProviderDesignation());
		provider.setProviderExperience(providerdto.getProviderExperience());
		provider.setProviderQualification(providerdto.getProviderQualification());
		logger.info("The Data updated successfully");
		return repository.save(provider);
	}

	@Override
	public void deleteProvider(int providerId) {
		repository.deleteById(providerId);
        logger.info("The provider deleted by using Id");
	}

	@Override
	public List<HealthcareProvider> getAllHealthcareProviders() {

		return repository.findAll();
	}

	@Override
	public HealthcareProviderDTO getProviderById(int providerId) {

		
		HealthcareProvider provider=repository.findById(providerId).orElse(new HealthcareProvider());
		HealthcareProviderDTO providerdto=new HealthcareProviderDTO();
		providerdto.setProviderId(provider.getProviderId());
		providerdto.setProviderName(provider.getProviderName());
		providerdto.setProviderPassword(provider.getProviderPassword());
		providerdto.setProviderEmail(provider.getProviderEmail());
		providerdto.setProviderGender(provider.getProviderGender());
		providerdto.setProviderSpeciality(provider.getProviderSpeciality());
		providerdto.setProviderDesignation(provider.getProviderDesignation());
		providerdto.setProviderExperience(provider.getProviderExperience());
		providerdto.setProviderQualification(provider.getProviderQualification());
		logger.info("Getting the provider by using Id");
		return providerdto;
	}

}