package com.hexaware.medicalbillingsystems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.medicalbillingsystems.entities.HealthcareProvider;
@Repository
public interface HealthcareProviderRepository  extends JpaRepository<HealthcareProvider , Integer> {
   
}