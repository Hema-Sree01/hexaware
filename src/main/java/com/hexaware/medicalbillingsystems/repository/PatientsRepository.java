package com.hexaware.medicalbillingsystems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.medicalbillingsystems.entities.Patients;
@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {
	Optional<Patients> findByPatientName(String patientName);

}
