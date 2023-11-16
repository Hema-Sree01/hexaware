package com.hexaware.medicalbillingsystems.restcontroller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystems.dto.InsurancePlansDTO;
import com.hexaware.medicalbillingsystems.dto.PatientsDTO;
import com.hexaware.medicalbillingsystems.entities.Patients;
import com.hexaware.medicalbillingsystems.exception.PatientIllegalArgumentsException;
import com.hexaware.medicalbillingsystems.exception.PatientNotFoundException;
import com.hexaware.medicalbillingsystems.exception.PlanNotFoundException;
import com.hexaware.medicalbillingsystems.service.IInsurancePlansService;
import com.hexaware.medicalbillingsystems.service.IPatientsService;

@RestController
@RequestMapping("/api/patients")
public class PatientsRestController {
	Logger logger =LoggerFactory.getLogger(PatientsRestController.class);
	
	@Autowired
	IInsurancePlansService planService;
	@Autowired
	IPatientsService service;

	@GetMapping("/welcome")
	public String newPatient() {
		return "Hello New Patient";
	}

	@PostMapping("/add/new")
	public Patients insertPatients(@RequestBody PatientsDTO patientDTO) {

		Patients patient = service.addPatients(patientDTO);

		if (patient.getPatientName() == null || patient.getPatientGender() == null) {
			throw new PatientIllegalArgumentsException(HttpStatus.BAD_REQUEST, "You have entered Invalid values.");
		}
		return patient;
	}

	@PutMapping("/update/patient")
	public Patients updatePatient(@RequestBody PatientsDTO patientDTO) {
		return service.updatepatients(patientDTO);

	}

	@DeleteMapping("/delete/patient/{patientId}")
	public String deletePatients(@PathVariable int patientId) {

		service.deletePatients(patientId);
		return "Successfully Delete patient with id: " + patientId;
	}

	@GetMapping("/getbyname/{patientName}")
	public PatientsDTO getByPatientName(@PathVariable String patientName) {
		PatientsDTO patientdto = service.getPatientByName(patientName);
		if (patientdto.getPatientName() == null) {
			throw new PatientNotFoundException(HttpStatus.NOT_FOUND,
					"Patient with name " + patientName + " does not exist");
		}
		return patientdto;
	}

	@GetMapping("/get/allPatients")
	public List<Patients> getAllPatients() {
		return service.getAllPatients();
	}

	@GetMapping("/searchplanbyname/{planName}")
	public InsurancePlansDTO getPlanByNamee(@PathVariable String planName) {
		InsurancePlansDTO planDTO = planService.getPlanByName(planName);
		if (planDTO.getPlanName() == null) {
			throw new PlanNotFoundException(HttpStatus.NO_CONTENT,
					"There is no plan with name " + planName + " ! Kindly Add it");
		}
		return planDTO;
	}
}