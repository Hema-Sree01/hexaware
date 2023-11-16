package com.hexaware.medicalbillingsystems.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystems.dto.PatientsDTO;
import com.hexaware.medicalbillingsystems.entities.InsurancePlans;
import com.hexaware.medicalbillingsystems.entities.Patients;
import com.hexaware.medicalbillingsystems.repository.PatientsRepository;
import com.hexaware.medicalbillingsystems.restcontroller.HealthcareProviderRestController;
@Service
public class PatientsServiceImp implements IPatientsService {
	Logger logger =LoggerFactory.getLogger(HealthcareProviderRestController.class);
	@Autowired
	PatientsRepository repository;

	@Override
	public Patients addPatients(PatientsDTO patientsdto) {
		Patients patient = new Patients();
		patient.setPatientName(patientsdto.getPatientName());
		patient.setPatientEmail(patientsdto.getPatientEmail());
		patient.setPatientPassword(patientsdto.getPatientPassword());
		patient.setPatientDOB(patientsdto.getPatientDOB());
		patient.setPatientGender(patientsdto.getPatientGender());
		patient.setPatientContact(patientsdto.getPatientContact());
		patient.setPatientAddress(patientsdto.getPatientAddress());
		patient.setPatientDisease(patientsdto.getPatientDisease());
		patient.setPlans(patientsdto.getPlans());
		logger.info("Added Successfully Patients");
		return repository.save(patient);
	}

	@Override
	public Patients updatepatients(PatientsDTO patientsdto) {
		Patients patient = new Patients();
		patient.setPatientName(patientsdto.getPatientName());
		patient.setPatientEmail(patientsdto.getPatientEmail());
		patient.setPatientPassword(patientsdto.getPatientPassword());
		patient.setPatientDOB(patientsdto.getPatientDOB());
		patient.setPatientGender(patientsdto.getPatientGender());
		patient.setPatientContact(patientsdto.getPatientContact());
		patient.setPatientAddress(patientsdto.getPatientAddress());
		patient.setPatientDisease(patientsdto.getPatientDisease());
		logger.info("Updated successfully");
		return repository.save(patient);
	}

	@Override
	public void deletePatients(long patientId) {
      logger.info("Get deleted by using PatientId");
      logger.warn("Not deleted by using Id");
		repository.deleteById(patientId);
		
	}

	@Override
	public PatientsDTO getPatientByName(String patientName) {
		Patients patient = repository.findByPatientName(patientName).orElse(new Patients());
		PatientsDTO patientdto = new PatientsDTO();
		patientdto.setPatientId(patient.getPatientId());
		patientdto.setPatientName(patient.getPatientName());
		patientdto.setPatientEmail(patient.getPatientEmail());
		patientdto.setPatientPassword(patient.getPatientPassword());
		patientdto.setPatientDOB(patient.getPatientDOB());
		patientdto.setPatientGender(patient.getPatientGender());
		patientdto.setPatientContact(patient.getPatientContact());
		patientdto.setPatientAddress(patient.getPatientAddress());
		patientdto.setPatientDisease(patient.getPatientDisease());
		logger.info("Patients found by name");
        logger.warn("Patient by name not found");
		return patientdto;
	}

	@Override
	public List<Patients> getAllPatients() {

		return repository.findAll();
	}

}