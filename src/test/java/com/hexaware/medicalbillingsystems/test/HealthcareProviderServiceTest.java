package com.hexaware.medicalbillingsystems.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.medicalbillingsystems.dto.HealthcareProviderDTO;
import com.hexaware.medicalbillingsystems.entities.HealthcareProvider;
import com.hexaware.medicalbillingsystems.service.HealthcareProviderServiceImp;

@SpringBootTest
public class HealthcareProviderServiceTest {

    @Autowired
    private HealthcareProviderServiceImp healthcareProviderService;

    @Test
    public void testAddProvider() {
        HealthcareProviderDTO providerDTO = new HealthcareProviderDTO();
        

        Long providerId = healthcareProviderService.addProvider(providerDTO);
        assertNotNull(providerId);
    }

    @Test
    public void testUpdateProvider() {
        HealthcareProviderDTO providerDTO = new HealthcareProviderDTO();
        

        Long providerId = healthcareProviderService.addProvider(providerDTO);

        providerDTO.setName("Updated Name");
        healthcareProviderService.updateProvider(providerDTO);

        HealthcareProviderDTO updatedProvider = healthcareProviderService.getProviderById(providerId);
        assertEquals("Updated Name", updatedProvider.getName());
    }

    @Test
    public void testDeleteProvider() {
        HealthcareProviderDTO providerDTO = new HealthcareProviderDTO();
        

        Long providerId = healthcareProviderService.addProvider(providerDTO);

        healthcareProviderService.deleteProvider(providerId);

        assertNull(healthcareProviderService.getProviderById(providerId));
    }

    @Test
    public void testGetAllHealthcareProviders() {
       
        List<HealthcareProviderDTO> providers = healthcareProviderService.getAllHealthcareProviders();
        assertNotNull(providers);
        
    }

    @Test
    public void testGetProviderById() {
        HealthcareProviderDTO providerDTO = new HealthcareProviderDTO();
       

        Long providerId = healthcareProviderService.addProvider(providerDTO);

        HealthcareProviderDTO retrievedProvider = healthcareProviderService.getProviderById(providerId);
        assertNotNull(retrievedProvider);
        
    }
}
