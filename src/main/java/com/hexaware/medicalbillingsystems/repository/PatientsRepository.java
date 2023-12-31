package com.hexaware.medicalbillingsystems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.medicalbillingsystems.entities.Patients;

/*
@Author :   Rajat Darvhekar  
Modified Date :06-11-2023
Description : Repository for Patients class extending JpaRepository
*/
@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {

	Optional<Patients> findByPatientName(String patientName);
	
}