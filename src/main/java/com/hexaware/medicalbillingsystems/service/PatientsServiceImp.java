package com.hexaware.medicalbillingsystems.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.medicalbillingsystems.dto.PatientsDTO;
import com.hexaware.medicalbillingsystems.entities.InsurancePlans;
import com.hexaware.medicalbillingsystems.entities.Patients;
import com.hexaware.medicalbillingsystems.repository.PatientsRepository;
import com.hexaware.medicalbillingsystems.restcontroller.HealthcareProviderRestController;
/*
@Author :   Rajat Darvhekar  
Modified Date : 04-11-2023
Description :Service Implementation class for PatientsServiceImpl implementing PatientsService
*/
@Service
public class PatientsServiceImp implements IPatientsService {

	Logger logger = LoggerFactory.getLogger(PatientsServiceImp.class);
	@Autowired
	private PatientsRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public Patients addPatients(PatientsDTO patientsdto) {
		Patients patient = new Patients();
		
		patient.setPatientName(patientsdto.getPatientName());
		patient.setPatientEmail(patientsdto.getPatientEmail());
		patientsdto.setPatientPassword(passwordEncoder.encode(patient.getPatientPassword()));
//		patient.setPatientPassword(patientsdto.getPatientPassword());
		patient.setPatientDOB(patientsdto.getPatientDOB());
		patient.setPatientGender(patientsdto.getPatientGender());
		patient.setPatientContact(patientsdto.getPatientContact());
		patient.setPatientAddress(patientsdto.getPatientAddress());
		patient.setPatientDisease(patientsdto.getPatientDisease());
		
		logger.info("New patient/user registered with us!!!");
		return repository.save(patient);
	}
	@Override
	public Patients updatepatients(PatientsDTO patientsdto) {
		Patients patient = new Patients();
		patient.setPatientId(patientsdto.getPatientId());
		patient.setPatientName(patientsdto.getPatientName());
		patient.setPatientEmail(patientsdto.getPatientEmail());
		patient.setPatientPassword(patientsdto.getPatientPassword());
		patient.setPatientDOB(patientsdto.getPatientDOB());
		patient.setPatientGender(patientsdto.getPatientGender());
		patient.setPatientContact(patientsdto.getPatientContact());
		patient.setPatientAddress(patientsdto.getPatientAddress());
		patient.setPatientDisease(patientsdto.getPatientDisease());
		return repository.save(patient);
	}
	@Override
	public void deletePatients(long patientId) {
		logger.warn("Patient with id " + patientId + " is deleted!!!!");
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
		return patientdto;
	}
	@Override
	public List<Patients> getAllPatients() {
		return repository.findAll();
	}
	@Override
	public boolean loginPatient(String patientEmail, String password) {
		return false;
	}
}