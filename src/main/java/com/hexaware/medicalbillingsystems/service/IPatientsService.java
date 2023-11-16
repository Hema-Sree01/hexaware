package com.hexaware.medicalbillingsystems.service;

import java.util.List;

import com.hexaware.medicalbillingsystems.dto.PatientsDTO;
import com.hexaware.medicalbillingsystems.entities.Patients;

public interface IPatientsService {
	
	public Patients addPatients(PatientsDTO patientsdto);
	public Patients updatepatients(PatientsDTO patientsdto);
	public void deletePatients(long patientId);
	public PatientsDTO getPatientByName(String patientName);
	public List<Patients> getAllPatients();

}