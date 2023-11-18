package com.hexaware.medicalbillingsystems.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hexaware.medicalbillingsystems.entities.HealthcareProvider;
import com.hexaware.medicalbillingsystems.entities.InsuranceCompany;
import com.hexaware.medicalbillingsystems.entities.Patients;
import com.hexaware.medicalbillingsystems.repository.HealthcareProviderRepository;
import com.hexaware.medicalbillingsystems.repository.InsuranceCompanyRepository;
import com.hexaware.medicalbillingsystems.repository.PatientsRepository;

import java.util.Optional;


public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private PatientsRepository patientRepository;
    
    @Autowired
    private InsuranceCompanyRepository companyRepository;
    
    @Autowired
    private HealthcareProviderRepository providerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Patients> patientInfo = patientRepository.findByPatientName(username);

        Optional<InsuranceCompany> companyInfo = companyRepository.findByCompanyName(username);
        Optional<HealthcareProvider> providerInfo = providerRepository.findByProviderName(username);
        if (patientInfo.isPresent()) {
            return patientInfo.map(PatientInfoPatientDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("Patient Not Found: " + username));
        }

       
        else if (companyInfo.isPresent()) {
            // create UserDetails for company
            return companyInfo.map(CompanyInfoCompanyDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("Company Not Found: " + username));
        }

        
        else if (providerInfo.isPresent()) {
            // create UserDetails for provider
            return providerInfo.map(ProviderInfoproviderDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("Provider Not Found: " + username));
        }

        else
        {
        throw new UsernameNotFoundException("User Not Found: " + username);
        }
    }

    }